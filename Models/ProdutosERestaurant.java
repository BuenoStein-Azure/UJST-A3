package Models;

import java.util.List;

public class ProdutosERestaurant {
    private List<ProdutoModel> produtos;
    private List<RestaurantModel> restaurantes;

    public ProdutosERestaurant(List<ProdutoModel> produtos, List<RestaurantModel> restaurantes) {
        this.produtos = produtos;
        this.restaurantes = restaurantes;
    }

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoModel> produtos) {
        this.produtos = produtos;
    }
    public List<RestaurantModel> getRestaurantes() {
        return restaurantes;
    }
    public void setRestaurantes(List<RestaurantModel> restaurantes) {
        this.restaurantes = restaurantes;
    }
}
