package payment.exception;

public class InsufficientWalletBalanceException
        extends PaymentFailedException {

    public InsufficientWalletBalanceException(String message) {
        super(message);
    }
}