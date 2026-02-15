package notification.service;

import notification.logger.Logger;

public class EmailNotification implements NotificationService{
    private final String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void sendNotification(String message) {
        Logger.getInstance().log("Email sent to " + email + " : " + message);
    }
}
