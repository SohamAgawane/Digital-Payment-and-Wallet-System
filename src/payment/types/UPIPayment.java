package payment.types;

import payment.core.Payment;

public class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(int paymentId, int amount, String upiId) {
        super(paymentId, amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment using UPI ID: " + upiId);
        markAsSuccess();
    }
}
