package payment.types;

import payment.core.Payment;

public class CardPayment extends Payment {
    private long cardNumber;
    private int cvv;

    public CardPayment(int paymentId, int amount, long cardNumber, int cvv) {
        super(paymentId, amount);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Card payment ending with "
                + String.valueOf(cardNumber).substring(12));
        markAsSuccess();
    }
}
