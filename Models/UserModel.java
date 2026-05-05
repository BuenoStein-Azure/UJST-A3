package Models;
import java.util.List;

public class UserModel {
    private String username;
    private String password;
    private String email;
    private double phoneNumber;
    private List<String> pedidos = null;

    public UserModel(String username, String password, String email, double phoneNumber, List<String> pedidos) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pedidos = pedidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> pedidos(){
        return pedidos;
    }
    
}
