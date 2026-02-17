package payment.types;

import payment.core.Payment;
import payment.exception.InsufficientWalletBalanceException;
import payment.exception.PaymentFailedException;

public class WalletPayment extends Payment {

    private String walletProvider;
    private int walletBalance;   // simulate wallet balance

    public WalletPayment(int paymentId, int amount,
                         String walletProvider) {
        super(paymentId, amount);
        this.walletProvider = walletProvider;
        this.walletBalance = 800;  // sample default balance
    }

    @Override
    public boolean pay() throws PaymentFailedException {

        System.out.println("Processing Wallet payment via " + walletProvider);

        if (walletProvider == null || walletProvider.isBlank()) {
            throw new PaymentFailedException(
                    "Invalid wallet provider"
            );
        }

        if (amount <= 0) {
            throw new PaymentFailedException(
                    "Invalid payment amount"
            );
        }

        if (walletBalance < amount) {
            throw new InsufficientWalletBalanceException(
                    "Insufficient wallet balance"
            );
        }

        walletBalance -= amount;   // deduct from wallet
        markAsSuccess();
        return true;
    }
}