package payment.core;

import payment.enums.PaymentStatus;
import payment.exception.PaymentFailedException;

import java.util.Objects;

public abstract class Payment
        implements Comparable<Payment>, Cloneable {

    protected final int paymentId;
    protected int amount;
    private PaymentStatus status;   // 🔴 Replaced boolean
    private final long timestamp;

    public Payment(int paymentId, int amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.INITIATED;  // 🔴 Default state
        this.timestamp = System.currentTimeMillis();
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    protected void markAsSuccess() {
        this.status = PaymentStatus.SUCCESS;
    }

    protected void markAsFailed() {
        this.status = PaymentStatus.FAILED;
    }

    public abstract boolean pay()
            throws PaymentFailedException;

    @Override
    public int compareTo(Payment other) {
        return Integer.compare(this.amount, other.amount);
    }

    @Override
    public Payment clone() throws CloneNotSupportedException {
        return (Payment) super.clone();
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                ", status=" + status +
                ", timestamp=" + timestamp +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return paymentId == payment.paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }
}