package payment.core;

import notification.logger.Logger;
import notification.service.NotificationService;
import payment.enums.PaymentStatus;
import payment.exception.PaymentFailedException;

import java.util.*;

public class PaymentGateway {

    private static PaymentGateway instance;

    private final List<Payment> paymentHistory = new ArrayList<>();
    private final Map<Integer, Payment> paymentMap = new HashMap<>();
    private final Vector<String> legacyLogs = new Vector<>();

    private PaymentGateway() {
        Logger.getInstance().log("PaymentGateway initialized");
    }

    public static PaymentGateway getGatewayInstance() {
        if (instance == null) {
            instance = new PaymentGateway();
        }
        return instance;
    }

    public void processPayment(Payment payment,
                               NotificationService notifier)
            throws PaymentFailedException {

        Logger.getInstance().log(
                "Processing payment ID: " + payment.getPaymentId()
        );

        payment.setStatus(PaymentStatus.INITIATED);
        legacyLogs.add("INITIATED: " + payment.getPaymentId());

        try {

            payment.pay();

            payment.setStatus(PaymentStatus.SUCCESS);

            Payment copy = payment.clone();
            paymentHistory.add(copy);
            paymentMap.put(copy.getPaymentId(), copy);

            notifier.sendNotification(
                    "Payment successful: ₹" + payment.getAmount()
            );

            legacyLogs.add("SUCCESS: " + payment.getPaymentId());

        } catch (PaymentFailedException e) {

            payment.setStatus(PaymentStatus.FAILED);
            legacyLogs.add("FAILED: " + payment.getPaymentId());

            throw e;

        } catch (CloneNotSupportedException e) {

            throw new PaymentFailedException(
                    "Audit cloning failed", e
            );
        }
    }

    public Payment findPaymentById(int id) {
        return paymentMap.get(id);
    }

    public List<Payment> getSuccessfulPayments() {
        return paymentHistory.stream()
                .filter(p -> p.getStatus() == PaymentStatus.SUCCESS)
                .toList();
    }

    public List<Payment> getPaymentHistory() {
        return paymentHistory;
    }

    public Vector<String> getLegacyLogs() {
        return legacyLogs;
    }
}