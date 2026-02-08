package app;

import notification.logger.Logger;
import payment.core.PaymentGateway;
import user.core.User;
import wallet.core.Wallet;

public class Main  {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application Started");

        PaymentGateway gateway  = PaymentGateway.getGatewayInstance();
        gateway.getGatewayInfo();

        User user = new User(1001, "Soham Agawane", "9876543210");
        Wallet wallet = new Wallet(50001, 20000.00);

        logger.log("User and Wallet object created");
    }
}
