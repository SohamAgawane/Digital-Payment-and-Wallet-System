package payment.types;

import payment.core.Payment;

public class WalletPayment extends Payment {

    private String walletProvider;

    public WalletPayment(int paymentId, int amount, String walletProvider) {
        super(paymentId, amount);
        this.walletProvider = walletProvider;
    }

    @Override
    public boolean pay() {
        System.out.println("Processing Wallet payment via " + walletProvider);
        markAsSuccess();
        return true;
    }
}