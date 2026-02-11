package payment.core;

public class Payment {
    private int paymentId;
    private int amount;
    private boolean status;

    public Payment(int paymentId, int amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = false;
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

    protected void markAsSuccess() {
        this.status = true;
    }

    public void processPayment() {
        System.out.println("Processing generic payment...");
        markAsSuccess();
    }
}
