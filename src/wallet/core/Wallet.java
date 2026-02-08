package wallet.core;

public class Wallet {
    private final int walletID;
    private double balance;

    public Wallet(int walletID, double balance) {
        this.walletID = walletID;
        this.balance = balance;
    }
}