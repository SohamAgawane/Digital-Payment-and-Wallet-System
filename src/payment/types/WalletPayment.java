package payment.types;

import payment.core.Payment;

public class WalletPayment extends Payment {
    private String walletProvider;
    private String walletName;

    public WalletPayment(int paymentId, int amount, String walletProvider) {
        super(paymentId, amount);
        this.walletProvider = walletProvider;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Wallet payment via " + walletProvider);

    }
}