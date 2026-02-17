package payment.util;

import payment.core.Payment;

public class TransactionBox<T extends Payment> {

    private T transaction;

    public TransactionBox(T transaction) {
        this.transaction = transaction;
    }

    public T getTransaction() {
        return transaction;
    }

    public void setTransaction(T transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "TransactionBox{" +
                "transaction=" + transaction +
                '}';
    }
}