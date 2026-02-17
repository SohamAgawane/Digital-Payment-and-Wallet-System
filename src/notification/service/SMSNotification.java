package notification.service;

import notification.logger.Logger;

public class SMSNotification implements NotificationService {

    private final String mobile;

    public SMSNotification(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public void sendNotification(String message) {
        Logger.getInstance()
                .log("[SMS] Sent to " + mobile + " : " + message);
    }
}