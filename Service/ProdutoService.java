package Service;
import java.util.List;

import Models.*;
import Service.*;

public class ProdutoService {
    static RestaurantModel rest1;
    static RestaurantModel rest2;
    static RestaurantModel rest3;
    static RestaurantModel rest4;



    public ProdutoService(){
        // Criação dos Restaurantes e seus respectivos cardápios utilizando a classe RestaurantModel e ProdutoModel
         rest1 = new RestaurantModel("Mcdonald's", "Rua das Laranjeiras, 123", 40028922,null);
         rest2 = new RestaurantModel("Pizza Hut", "Avenida dos Pizzaiolos, 456", 40028923, null);
         rest3 = new RestaurantModel("Mania de Churrasco", "Rua do Churrasco, 789", 40028924, null);
         rest4 = new RestaurantModel("Burguer King", "Avenida dos Burgers, 321", 40028925, null);
        

        rest1.setcatalogo(List.of(
            new ProdutoModel("BigMac", 25.0),
            new ProdutoModel("McQuarteirão", 28.0),
            new ProdutoModel("McChicken", 22.0),
            new ProdutoModel("McCheddar", 30.0)
        )); 
    }
    public static void exibirCatalogoMcDonald(){
        System.out.println(rest1.getRestaurantName() + " - " 
            + rest1.getLocate() + " - " 
            + rest1.getphoneRestaurantNumber());
        
        for(ProdutoModel produto: rest1.getcatalogo()){
            System.out.println(produto.getNome()+ " - R$ " + produto.getPreco());
        }
    }
    public static void exibirCatalogoPizzaHut() {
        System.out.println(rest2.getRestaurantName() + " - " 
            + rest2.getLocate() + " - " 
            + rest2.getphoneRestaurantNumber());
        
        for (ProdutoModel produto : rest2.getcatalogo()) {
            System.out.println(produto.getNome() + " - R$ " + produto.getPreco());
        }
    }
    
    public static void exibirCatalogoManiaChurrasco() {
        System.out.println(rest3.getRestaurantName() + " - " 
            + rest3.getLocate() + " - " 
            + rest3.getphoneRestaurantNumber());
        
        for (ProdutoModel produto : rest3.getcatalogo()) {
            System.out.println(produto.getNome() + " - R$ " + produto.getPreco());
        }
    }
    
    public static void exibirCatalogoBurgerKing() {
        System.out.println(rest4.getRestaurantName() + " - " 
            + rest4.getLocate() + " - " 
            + rest4.getphoneRestaurantNumber());
        
        for (ProdutoModel produto : rest4.getcatalogo()) {
            System.out.println(produto.getNome() + " - R$ " + produto.getPreco());
        }
    }
    
}
