package User;


public class User {
    private int userId;
    private String name;
    private String email;
    private String phoneNr;
    private int ssn;

    public User(int userId, String name, String email, String phoneNr, int ssn) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNr = phoneNr;
        this.ssn = ssn;
    }
}
