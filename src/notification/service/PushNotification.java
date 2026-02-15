package notification.service;

import notification.logger.Logger;

public class PushNotification implements NotificationService{
    private final String deviceId;

    public PushNotification(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void sendNotification(String message) {
        Logger.getInstance().log("Push sent to device " + deviceId + " : " + message);
    }
}
