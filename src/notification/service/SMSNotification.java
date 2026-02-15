package notification.service;

import notification.logger.Logger;

public class SMSNotification implements NotificationService{
    private final String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification(String message) {
        Logger.getInstance().log("SMS sent to " + phoneNumber + " : " + message);
    }

    @Deprecated
    public void OldGateway(String message) {
        System.out.println("Old SMS gateway used");
    }
}
