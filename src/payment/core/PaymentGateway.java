package payment.core;

import notification.logger.Logger;

public class PaymentGateway {
    private static PaymentGateway gatewayInstance;

    private static final String GATEWAY_NAME = "DigitalPay";
    private static final String VERSION = "v1.0";

    private PaymentGateway() {
        Logger.getInstance().log(
                "PaymentGateway initialized: " + GATEWAY_NAME + " " + VERSION
        );
    }

    public static PaymentGateway getGatewayInstance() {
        if(gatewayInstance == null) {
            gatewayInstance = new PaymentGateway();
        }
        return gatewayInstance;
    }

    public void getGatewayInfo() {
        Logger.getInstance().log(
                "Accessing Gateway: " + GATEWAY_NAME
        );
    }
}