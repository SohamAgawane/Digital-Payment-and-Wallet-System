package notification.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logInstance;
    private Logger() { }

    public static Logger getInstance() {
        if(logInstance == null) {
            logInstance = new Logger();
        }
        return logInstance;
    }

    public void log(String message) {
        long timestamp = System.currentTimeMillis();

        Date date = new Date(timestamp);
        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println("[LOG] " + sdf.format(date) + " : " + message);
    }
}
