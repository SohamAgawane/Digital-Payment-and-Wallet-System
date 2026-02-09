package payment.types;

import payment.core.Payment;

public class WalletPayment extends Payment {
    private String walletProvider;
    private String walletName;

    public WalletPayment(int paymentId, int amount, boolean status, String walletProvider, String walletName) {
        super(paymentId, amount, status);
        this.walletProvider = walletProvider;
        this.walletName = walletName;
    }

    public String getWalletProvider() {
        return walletProvider;
    }

    public String getWalletName() {
        return walletName;
    }
}
