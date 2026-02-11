package app;

import notification.logger.Logger;
import payment.core.Payment;
import payment.core.PaymentGateway;
import payment.types.CardPayment;
import payment.types.UPIPayment;
import payment.types.WalletPayment;
import user.core.User;

public class Main  {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application Started");

        PaymentGateway gateway  = PaymentGateway.getGatewayInstance();
        gateway.getGatewayInfo();

        User user = new User(1001, "Soham Agawane", "9876543210");

        logger.log("User created successfully");

        Payment p1 = new UPIPayment(101, 500, "sohamokupi");
        Payment p2 = new CardPayment(102, 1500, 1234567812345678L, 123);
        Payment p3 = new WalletPayment(103, 1000, "PayFast");

        logger.log("Payments created");

        System.out.println("\n--- Processing Payments ---");

        p1.processPayment();
        p2.processPayment();
        p3.processPayment();

        logger.log("Payments processed successfully");
    }
}
