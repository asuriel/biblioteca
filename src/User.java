
public class User {
    private String fullName;
    private String password;
    private String email;
    private String address;

    public User(String fullName, String password, String email, String address) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public String displayDetails(){
        return fullName + email + address;
    }

    public boolean isValidPassword(String pwd)
    {
        return (pwd.equals(password));
    }
}
