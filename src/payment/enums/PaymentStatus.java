package payment.enums;

public enum PaymentStatus {

    INITIATED("Payment initiated"),
    SUCCESS("Payment completed successfully"),
    FAILED("Payment failed");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}