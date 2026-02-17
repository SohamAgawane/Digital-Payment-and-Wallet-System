package payment.types;

import payment.core.Payment;
import payment.exception.PaymentFailedException;

public class UPIPayment extends Payment {

    private String upiId;

    public UPIPayment(int paymentId, int amount, String upiId) {
        super(paymentId, amount);
        this.upiId = upiId;
    }

    @Override
    public boolean pay() throws PaymentFailedException {

        System.out.println("Processing UPI payment via " + upiId);

        if (upiId == null || upiId.isBlank()) {
            throw new PaymentFailedException(
                    "Invalid UPI ID"
            );
        }

        if (amount <= 0) {
            throw new PaymentFailedException(
                    "Invalid payment amount"
            );
        }

        markAsSuccess();
        return true;
    }
}