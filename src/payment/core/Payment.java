package payment.core;

public class Payment {
    private int paymentId;
    private int amount;
    private boolean status;

    public Payment(int paymentId, int amount, boolean status) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isStatus() {
        return status;
    }
}
