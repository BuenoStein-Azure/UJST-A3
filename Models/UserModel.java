package Models;
import java.util.List;

public class UserModel {
    private String username;
    private String password;
    private String email;
    private double phoneNumber;
    private List<ProdutosERestaurant> carrinho = null;
    private List<Object> metodoPagamento = null;

    public UserModel(String username, String password, String email, double phoneNumber, List<ProdutosERestaurant> carrinho, List<Object> metodoPagamento) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.carrinho = carrinho;
        this.metodoPagamento = metodoPagamento;

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

    public List<ProdutosERestaurant> getCarrinho(){
        return carrinho;
    }
    public void setCarrinho(List<ProdutosERestaurant> carrinho){
        this.carrinho = carrinho;
    }
    public List<Object> getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(List<Object> metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
}
