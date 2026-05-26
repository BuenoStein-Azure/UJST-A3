package Service;
import Models.*;
import static Service.UsuarioService.AMARELO;
import static Service.UsuarioService.AZUL_ESCURO;
import static Service.UsuarioService.BRANCO;
import static Service.UsuarioService.RESET;
import static Service.UsuarioService.VERDE_ESCURO;
import static Service.UsuarioService.VERMELHO;
import java.util.List;
public class RestauranteService {
    private static RestaurantModel rest1;
    private static RestaurantModel rest2;       
    private static RestaurantModel rest3;
    private static RestaurantModel rest4;
    
    
    

    // adicionando todos os restaurantes e seus cardápios em um repositório chamado ProdutosERestaurant, para facilitar o acesso aos dados dos restaurantes e seus produtos. Dessa forma, o repositório ProdutosERestaurant pode ser utilizado para armazenar e acessar as informações dos restaurantes e seus cardápios de forma centralizada. E como é um repositório estático, ele é compartilhado por todas as instâncias da classe RestaurantService, ou seja, os dados dos restaurantes e seus cardápios são acessíveis a partir de qualquer instância da classe RestaurantService, sem a necessidade de criar uma nova instância para acessar os dados.
    
    
    
    
    
    // assim é sempre inicializado automaticamente, sem precisar chamar o construtor.
    static{
        // Criação dos Restaurantes e seus respectivos cardápios utilizando a classe RestaurantModel e ProdutoModel
         rest1 = new RestaurantModel(VERMELHO + "Mcdonald's" + RESET, "Rua das Laranjeiras, 123", 40028922,null);
         rest1.setcatalogo(List.of(
            new ProdutoModel(BRANCO + "1. " + RESET + " BigMac", 25.0, 10),
            new ProdutoModel(BRANCO + "2. " + RESET + " McQuarteirão", 28.0, 10),
            new ProdutoModel(BRANCO + "3. " + RESET + " McChicken", 22.0, 10),
            new ProdutoModel(BRANCO + "4. " + RESET + " McCheddar", 30.0, 10),
            new ProdutoModel(BRANCO + "5. " + RESET + " Coca Cola 500 ml", 12.0, 10),
            new ProdutoModel(BRANCO + "6. " + RESET + " Fritas Média", 15.0, 10)
        ));

         rest2 = new RestaurantModel(AMARELO + "Pizza Hut" + RESET, "Avenida dos Pizzaiolos, 456", 40028923, null);
         rest2.setcatalogo(List.of(
            new ProdutoModel(BRANCO + "1. " + RESET + " Pizza Margherita", 35.0, 10),
            new ProdutoModel(BRANCO + "2. " + RESET + " Pizza Pepperoni", 40.0, 10),
            new ProdutoModel(BRANCO + "3. " + RESET + " Pizza Vegetariana", 30.0, 10),
            new ProdutoModel(BRANCO + "4. " + RESET + " Pizza Frango com Catupiry", 38.0, 10),
            new ProdutoModel(BRANCO + "5. " + RESET + " Refrigerante 2L", 15.0, 10)
        ));

         rest3 = new RestaurantModel(BRANCO + "Mania de Churrasco" + RESET , "Rua do Churrasco, 789", 40028924, null);
         rest3.setcatalogo(List.of(
            new ProdutoModel(BRANCO + "1. " + RESET + " Espetinho de Frango", 25.0, 10),
            new ProdutoModel(BRANCO + "2. " + RESET + " Espetinho de Carne", 30.0, 10),
            new ProdutoModel(BRANCO + "3. " + RESET + " Espetinho de Linguiça", 20.0, 10),
            new ProdutoModel(BRANCO + "4. " + RESET + " Espetinho de Queijo Coalho", 25.0, 10),
            new ProdutoModel(BRANCO + "5. " + RESET + " Refrigerante 2L", 15.0, 10)
        ));
         rest4 = new RestaurantModel(AZUL_ESCURO + "Burguer King" + RESET, "Avenida dos Burgers, 321", 40028925, null);
         rest4.setcatalogo(List.of(
            new ProdutoModel(BRANCO + "1. " + RESET + " Whopper", 25.0, 10),
            new ProdutoModel(BRANCO + "2. " + RESET + " Big King", 30.0, 10),
            new ProdutoModel(BRANCO + "3. " + RESET + " Chicken King", 22.0, 10),
            new ProdutoModel(BRANCO + "4. " + RESET + " Bacon King", 35.0, 10), 
            new ProdutoModel(BRANCO + "5. " + RESET + " Pepsi 500 ml", 12.0, 10),
            new ProdutoModel(BRANCO + "6. " + RESET + " Fritas Média", 15.0, 10)
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

    public static void exibirCatalogo(RestaurantModel restaurant) {
        
        System.out.println(BRANCO + "\n     === CARDÁPIO DO " + restaurant.getRestaurantName().toUpperCase() + " ===     " + RESET);
        System.out.println( VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        for (ProdutoModel produto : restaurant.getcatalogo()) {
            System.out.printf("    %s  →  R$ %.2f%n", produto.getNome(), produto.getPreco());
        }
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
    }
}