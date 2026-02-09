package payment.types;

import payment.core.Payment;

public class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(int paymentId, int amount, boolean status, String upiId) {
        super(paymentId, amount, status);
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }
}
