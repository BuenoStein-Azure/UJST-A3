package Models;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private List<ProdutosERestaurant> carrinho = null;
    private List<Object> metodoPagamento = null;
    
    private List<List<ProdutosERestaurant>> historicoPedidos = new ArrayList<>();

    public UserModel(String username, String password, String email, String phoneNumber, List<ProdutosERestaurant> carrinho, List<Object> metodoPagamento) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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
    
    // Não pensei nessa logica, gpt ajudou a criar / abriu minha mente 
    public List<List<ProdutosERestaurant>> getHistoricoPedidos() {
        // Lógica para retornar o histórico de pedidos do usuário
        return historicoPedidos; // Retorna a lista de pedidos do usuário
    }

    public void adicionarPedidoAoHistorico(List<ProdutosERestaurant> pedido) {
        // Lógica para adicionar um pedido ao histórico do usuário
        if(historicoPedidos == null){
            historicoPedidos = new ArrayList<>();
        }
        historicoPedidos.add(new ArrayList<>(pedido)); // Adiciona o pedido à lista de pedidos do usuário
    }
}
