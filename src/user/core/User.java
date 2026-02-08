package user.core;

public class User {
    private final int userID;
    private String name;
    private String mobileNumber;

    public User(int userID, String name, String mobileNumber) {
        this.userID = userID;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }
}