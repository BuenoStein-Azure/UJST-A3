package Service;
import Models.*;
import java.util.List;
public class RestaurantService {
    private static RestaurantModel rest1;
    private static RestaurantModel rest2;       
    private static RestaurantModel rest3;
    private static RestaurantModel rest4;
    
    
    

    // adicionando todos os restaurantes e seus cardápios em um repositório chamado CarteItem, para facilitar o acesso aos dados dos restaurantes e seus produtos. Dessa forma, o repositório CarteItem pode ser utilizado para armazenar e acessar as informações dos restaurantes e seus cardápios de forma centralizada. E como é um repositório estático, ele é compartilhado por todas as instâncias da classe RestaurantService, ou seja, os dados dos restaurantes e seus cardápios são acessíveis a partir de qualquer instância da classe RestaurantService, sem a necessidade de criar uma nova instância para acessar os dados.
    
    
    
    
    
    // assim é sempre inicializado automaticamente, sem precisar chamar o construtor.
    static{
        // Criação dos Restaurantes e seus respectivos cardápios utilizando a classe RestaurantModel e ProdutoModel
         rest1 = new RestaurantModel("Mcdonald's", "Rua das Laranjeiras, 123", 40028922,null);
         rest1.setcatalogo(List.of(
            new ProdutoModel("1. BigMac", 25.0),
            new ProdutoModel("2. McQuarteirão", 28.0),
            new ProdutoModel("3. McChicken", 22.0),
            new ProdutoModel("4. McCheddar", 30.0)
        ));

         rest2 = new RestaurantModel("Pizza Hut", "Avenida dos Pizzaiolos, 456", 40028923, null);
         rest2.setcatalogo(List.of(
            new ProdutoModel("1. Pizza Margherita", 35.0),
            new ProdutoModel("2. Pizza Pepperoni", 40.0),
            new ProdutoModel("3. Pizza Vegetariana", 30.0)
        ));

         rest3 = new RestaurantModel("Mania de Churrasco", "Rua do Churrasco, 789", 40028924, null);
         rest3.setcatalogo(List.of(
            new ProdutoModel("1. Churrasco de Frango", 25.0),
            new ProdutoModel("2. Churrasco de Carne", 30.0),
            new ProdutoModel("3. Churrasco de Linguiça", 20.0)
        ));
         rest4 = new RestaurantModel("Burguer King", "Avenida dos Burgers, 321", 40028925, null);
         rest4.setcatalogo(List.of(
            new ProdutoModel("1. Whopper", 25.0),
            new ProdutoModel("2. Big King", 30.0),
            new ProdutoModel("3. Chicken King", 22.0)
        ));
    }
    public static RestaurantModel getRest1() {
        return rest1;
    }
    public static RestaurantModel getRest2() {
        return rest2;
    }   
    public static RestaurantModel getRest3() {
        return rest3;
    }
    public static RestaurantModel getRest4() {
        return rest4;
    }
    public static List<ProdutoModel> getRestCatalogoList() {
        return List.of(rest1.getcatalogo(), rest2.getcatalogo(), rest3.getcatalogo(), rest4.getcatalogo()).stream().flatMap(List::stream).toList();
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
