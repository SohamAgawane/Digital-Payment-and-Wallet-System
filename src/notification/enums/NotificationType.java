package notification.enums;

public enum NotificationType {

    SMS("Text Message"),
    EMAIL("Email Notification"),
    PUSH("Push Notification");

    private final String description;

    NotificationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}