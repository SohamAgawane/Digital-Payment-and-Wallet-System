import java.util.Date;
import java.text.SimpleDateFormat;

class User {
    final int userID;
    String name;
    String mobileNumber;

    User(int userID, String name, String mobileNumber) {
        this.userID = userID;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    void printDetails() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Mobile Number: " + mobileNumber);
    }
}

class Wallet {
    final int walletID;
    double balance;

    Wallet(int walletID, double balance) {
        this.walletID = walletID;
        this.balance = balance;
    }

    void printDetails() {
        System.out.println("Wallet ID: " + walletID);
        System.out.println("Balance: " + balance);
    }
}

class Payment {
    final int paymentID;
    double amount;
    long timestamp;

    Payment(int paymentID, double amount, long timestamp) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    void printDetails() {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println("Payment ID: " + paymentID);
        System.out.println("Amount: " + amount);
        System.out.println("Time: " + sdf.format(date));
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User(1001, "Soham Agawane", "9876543210");
        Wallet wallet = new Wallet(50001, 20000.00);

        Payment p1 = new Payment(900001, 500.00, System.currentTimeMillis());
        Payment p2 = new Payment(900002, 1200.00, System.currentTimeMillis());

        user.printDetails();
        wallet.printDetails();
        p1.printDetails();
        p2.printDetails();
    }
}