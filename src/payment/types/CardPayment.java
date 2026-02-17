package payment.types;

import payment.core.Payment;
import payment.exception.PaymentFailedException;

public class CardPayment extends Payment {

    private long cardNumber;
    private int cvv;

    public CardPayment(int paymentId, int amount,
                       long cardNumber, int cvv) {
        super(paymentId, amount);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean pay() throws PaymentFailedException {

        System.out.println("Processing Card payment");

        // Basic validation example
        if (cardNumber <= 0 || cvv <= 0) {
            throw new PaymentFailedException(
                    "Invalid card details"
            );
        }

        if (amount <= 0) {
            throw new PaymentFailedException(
                    "Invalid payment amount"
            );
        }

        markAsSuccess();
        return true;
    }
}