package Service;
import Service.*;
import Models.*;


import java.util.Scanner;


public class MenuRestauranteService {
    private RestaurantService restaurantService; 
    public MenuRestauranteService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    
        
        public void Menu(){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n             === RESTAURANTES DISPONIVEIS ===     ");
            System.out.print("\n  1. Mcdonald's");
            System.out.print("\n  2. Pizza Hut");
            System.out.print("\n  3. Mania de Churrasco");
            System.out.print("\n  4. Burguer King ");
            System.out.print("\n  Digite a opção do restaurante: ");
        switch(sc.nextInt()){
            case 1:
                System.out.println("\n    Você escolheu Mcdonald's!");
                System.out.println("\n    Carregando menu do Macdonald's...");
                restaurantService.exibirCatalogoMcDonald();
                int opcaoProduto = sc.nextInt();
                switch (opcaoProduto) {
                    
                        
                        case 1:
                         System.out.println("\n    Você escolheu o BigMac!");    
                        System.out.println("\n    Oque deseja fazer agora? (1 - Escolher mais produtos desse restaurante / 2 - Escolher outro restaurante / 3 - Finalizar compra)");
                            switch (sc.nextInt()) {
                                case 1:
                                    System.out.println("\n    Voltando para o catalogo...");
                        
                                    ProdutoModel produto = restaurantService.getRest1().getcatalogo().get(opcaoProduto - 1);
                                    CarrinhoService carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest1());
                                    restaurantService.exibirCatalogoMcDonald();
                                    break;
                                case 2:
                                    System.out.println("\n    Voltando para o menu de restaurantes...");
                                    Menu();
                                     produto = restaurantService.getRest1().getcatalogo().get(opcaoProduto - 1);
                                     carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    break;
                                case 3:
                                    produto = restaurantService.getRest1().getcatalogo().get(opcaoProduto - 1);
                                    carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest1());
                                    carrinhoService.finalizarCompra();
                                    break;
                            
                                default:
                                    System.out.println("\n    Opção inválida!");
                                    break;

                            }
                        break;
                default:
                System.out.println("\n    Opção inválida!");
                break;
                }
                break;
            case 2:
                System.out.println("\n    Você escolheu Pizza Hut!");
                System.out.println("\n    Carregando menu da Pizza Hut...");
                restaurantService.exibirCatalogoPizzaHut();
                opcaoProduto = sc.nextInt();
                switch (opcaoProduto) {
                    case 1:
                         System.out.println("\n    Você escolheu a Pizza Margherita!");    
                        System.out.println("\n    Deseja Escolher mais produtos desse restaurante? (1 - Sim / 2 - Não)");
                            switch (sc.nextInt()) {
                                case 1:
                                    System.out.println("\n    Voltando para o catalogo...");
                        
                                    ProdutoModel produto = restaurantService.getRest2().getcatalogo().get(opcaoProduto - 1);
                                    CarrinhoService carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest2());
                                    restaurantService.exibirCatalogoPizzaHut();
                                    break;
                                case 2:
                                    produto = restaurantService.getRest2().getcatalogo().get(opcaoProduto - 1);
                                    carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest2());
                                    carrinhoService.finalizarCompra();
                                    break;
                            
                                default:
                                    System.out.println("\n    Opção inválida!");
                                    break;

                            }
                        break;
                default:
                System.out.println("\n    Opção inválida!");
                break;
                }
                break;
            case 3:
                System.out.println("\n    Você escolheu Burger King!");
                System.out.println("\n    Carregando menu do Burger King...");
                restaurantService.exibirCatalogoBurgerKing();
                opcaoProduto = sc.nextInt();
                switch (opcaoProduto) {
                    case 1:
                         System.out.println("\n    Você escolheu o Whopper!");    
                        System.out.println("\n    Deseja Escolher mais produtos desse restaurante? (1 - Sim / 2 - Não)");
                            switch (sc.nextInt()) {
                                case 1:
                                    System.out.println("\n    Voltando para o catalogo...");
                        
                                    ProdutoModel produto = restaurantService.getRest4().getcatalogo().get(opcaoProduto - 1);
                                    CarrinhoService carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest4());
                                    restaurantService.exibirCatalogoBurgerKing();
                                    break;
                                case 2:
                                    produto = restaurantService.getRest4().getcatalogo().get(opcaoProduto - 1);
                                    carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest4());
                                    carrinhoService.finalizarCompra();
                                    break;
                            
                                default:
                                    System.out.println("\n    Opção inválida!");
                                    break;

                            }
                        break;
            
            case 4:
                System.out.println("\n    Você escolheu Mania de Churrasco!");
                System.out.println("\n    Carregando menu do Mania de Churrasco...");
                restaurantService.exibirCatalogoManiaChurrasco();
                 opcaoProduto = sc.nextInt();
                switch (opcaoProduto) {
                    case 1:
                         System.out.println("\n    Você escolheu o Espeto de Frango!");    
                        System.out.println("\n    Deseja Escolher mais produtos desse restaurante? (1 - Sim / 2 - Não)");
                            switch (sc.nextInt()) {
                                case 1:
                                    System.out.println("\n    Voltando para o catalogo...");
                        
                                    ProdutoModel produto = restaurantService.getRest3().getcatalogo().get(opcaoProduto - 1);
                                    CarrinhoService carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest3());
                                    restaurantService.exibirCatalogoManiaChurrasco();
                                    break;
                                case 2:
                                    produto = restaurantService.getRest3().getcatalogo().get(opcaoProduto - 1);
                                    carrinhoService = new CarrinhoService(UserService.currentUser, produto);
                                    carrinhoService.adicionarAoCarrinho(produto, restaurantService.getRest3());
                                    carrinhoService.finalizarCompra();
                                    break;
                            
                                default:
                                    System.out.println("\n    Opção inválida!");
                                    break;

                            }
            break;
            case 5:
                System.out.println("\n    Você escolheu Sair!");
                System.out.println("\n    Redirecionando para o menu de restaurantes...");
                Menu();
                
            default:
            System.out.println("\n    Opção inválida!");
            break;



        
    }
}
}}}
 