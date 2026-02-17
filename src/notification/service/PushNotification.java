package notification.service;

import notification.logger.Logger;

public class PushNotification implements NotificationService {

    private final String userId;

    public PushNotification(String userId) {
        this.userId = userId;
    }

    @Override
    public void sendNotification(String message) {
        Logger.getInstance()
                .log("[PUSH] Sent to user " + userId + " : " + message);
    }
}