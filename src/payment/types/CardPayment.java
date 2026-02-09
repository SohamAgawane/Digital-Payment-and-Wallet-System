package payment.types;

import payment.core.Payment;

public class CardPayment extends Payment {
    private int cardNumber;
    private int cvv;

    public CardPayment(int paymentId, int amount, boolean status, int cardNumber, int cvv) {
        super(paymentId, amount, status);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }
}
