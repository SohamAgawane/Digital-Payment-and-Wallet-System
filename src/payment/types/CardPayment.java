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
    public boolean pay() {
        System.out.println("Processing Card payment");
        markAsSuccess();
        return true;
    }
}