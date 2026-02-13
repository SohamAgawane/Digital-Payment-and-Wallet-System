package payment.core;

import java.util.Objects;

public class Payment {
    private final int paymentId;
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

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                ", status=" + status +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;
        return paymentId == payment.paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }
}
