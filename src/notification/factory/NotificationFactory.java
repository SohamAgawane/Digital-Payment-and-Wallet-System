package notification.factory;

import notification.enums.NotificationType;
import notification.service.*;

public class NotificationFactory {

    public static NotificationService getNotifier(
            NotificationType type,
            String destination) {

        return switch (type) {
            case EMAIL -> new EmailNotification(destination);
            case SMS -> new SMSNotification(destination);
            case PUSH -> new PushNotification(destination);
        };
    }
}