package app;

import notification.enums.NotificationType;
import notification.factory.NotificationFactory;
import notification.logger.Logger;
import notification.service.NotificationService;
import payment.core.Payment;
import payment.core.PaymentGateway;
import payment.exception.PaymentFailedException;
import payment.types.*;
import user.core.User;

public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log("Application Started");

        PaymentGateway gateway =
                PaymentGateway.getGatewayInstance();

        User user = new User(1001,
                "Soham Agawane",
                "9876543210");

        Payment p1 = new UPIPayment(101, 500, "soham@upi");
        Payment p2 = new CardPayment(102, 1500,
                1234567812345678L, 123);
        Payment p3 = new WalletPayment(103, 1000, "PayFast");

        try {

            NotificationService sms =
                    NotificationFactory.getNotifier(
                            NotificationType.SMS,
                            "9876543210");

            NotificationService email =
                    NotificationFactory.getNotifier(
                            NotificationType.EMAIL,
                            "soham@gmail.com");

            NotificationService push =
                    NotificationFactory.getNotifier(
                            NotificationType.PUSH,
                            "1001");

            gateway.processPayment(p1, sms);
            gateway.processPayment(p2, email);
            gateway.processPayment(p3, push);

        } catch (PaymentFailedException e) {
            logger.log("Error: " + e.getMessage());
        }

        System.out.println("\n--- Successful Payments ---");
        gateway.getSuccessfulPayments()
                .forEach(System.out::println);

        System.out.println("\n--- Lookup Payment 102 ---");
        System.out.println(gateway.findPaymentById(102));

        System.out.println("\n--- Legacy Logs ---");
        gateway.getLegacyLogs()
                .forEach(System.out::println);

        logger.log("Application Finished");
    }
}