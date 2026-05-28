package Service;
import Models.*;
import static Service.UsuarioService.*;
import java.util.List;
import Util.AppScanner;

public class MenuRestauranteService {
    private RestauranteService restaurantService; 
    public MenuRestauranteService(RestauranteService restaurantService) {
        this.restaurantService = restaurantService;
    }        
        public void Menu(){
            boolean continuarPedindo = true;
            while (continuarPedindo) {
            System.out.println(BRANCO + "\n             === RESTAURANTES DISPONÍVEIS ===     " + RESET);
            System.out.println(VERDE_ESCURO + "────────────────────────────────────────────────────" + RESET);
            System.out.println(BRANCO + "    1." + VERMELHO + " McDonald's" + RESET);
            System.out.println(BRANCO + "    2." + AMARELO + " Pizza Hut" + RESET);
            System.out.println(BRANCO + "    3." + RESET + " Mania de Churrasco");
            System.out.println(BRANCO + "    4." + AZUL_ESCURO + " Burger King" + RESET);
            System.out.println(BRANCO + "    0." + RESET + " Finalizar compra");
            System.out.print("    Escolha o restaurante: ");

            // REFAZENDO LOGICA INTEIRA PQ TINHA MUITO CODIGO DUPLICADO, tava dando agonia de tanto codigo repetido, entao decidi refazer a logica inteira, agora tem muito menos codigo e é mais facil de ler.
            int opcaoRestaurante = AppScanner.get().nextInt();
            
            if(opcaoRestaurante == 0){
                CarrinhoService carrinhoService = new CarrinhoService(UsuarioService.currentUser);
                carrinhoService.finalizarCompra();
                continuarPedindo = false;
                break;
            }

            RestaurantModel restaurantSelecinado = null;
            switch (opcaoRestaurante) {
                case 1:
                    restaurantSelecinado = RestauranteService.getRest1(); break;
                case 2:
                    restaurantSelecinado = RestauranteService.getRest2(); break;
                case 3:
                    restaurantSelecinado = RestauranteService.getRest3(); break;
                case 4:
                    restaurantSelecinado = RestauranteService.getRest4(); break;
                default:
                    System.out.println("\n    Opção inválida.");
                    continue; 
            }
            
            // Loop que vai continuar até o usuario quiser sair
            boolean continuarNesteRestaurante = true;
            while(continuarNesteRestaurante){
                RestauranteService.exibirCatalogo(restaurantSelecinado);
                System.out.print("\n  Digite a opção do produto que deseja adicionar ao carrinho (0 para voltar): ");
                int opcaoProduto = AppScanner.get().nextInt();;

                // Verifica se o usuario quer voltar para a escolha do restaurante
                if(opcaoProduto == 0){
                    continuarNesteRestaurante = false;
                    continue; 
                }
                
                // verifica se a opção do produto é válida
                List<ProdutoModel> catalogo = restaurantSelecinado.getcatalogo();
                if(opcaoProduto < 1 || opcaoProduto > catalogo.size()){
                    System.out.println("\n  Opção invalida! Escolha um produto entre 1 e " + catalogo.size());
                    continue; 
                }

                ProdutoModel produtoSelecionado = catalogo.get(opcaoProduto - 1);
                
                // pergunta quantidade
                System.out.print("\n  Digite a quantidade que deseja adicionar ao carrinho: ");
                int quantidade = AppScanner.get().nextInt();
                if(quantidade < 1){
                    System.out.println("\n  Quantidade inválida! Digite um número maior que 0.");
                    continue; 
                }
                // adiciona o produto ao carrinho do usuario
                CarrinhoService carrinhoService = new CarrinhoService(UsuarioService.currentUser);
                carrinhoService.adicionarAoCarrinho(produtoSelecionado, restaurantSelecinado, quantidade);

                
                System.out.println("\n    O que deseja fazer agora?");
                System.out.println(BRANCO + "    1 -" + RESET + " Escolher mais produtos desse restaurante");
                System.out.println(BRANCO + "    2 -" + RESET + " Escolher outro restaurante");
                System.out.println(BRANCO + "    3 -" + RESET + " Finalizar compra");
                System.out.print("    Escolha: ");

                int escolha = AppScanner.get().nextInt();
                switch (escolha) {
                    case 1:
                        break; // simplesmente continua o loop interno (fica no mesmo restaurante)
                    case 2:
                        continuarNesteRestaurante = false; // volta para a escolha do restaurante
                        break;
                    case 3:
                        carrinhoService.finalizarCompra(); // finaliza a compra
                        continuarNesteRestaurante = false; // volta para a escolha do restaurante
                        continuarPedindo = false; // sai do loop principal
                        break;
                    default:
                        System.out.println("\n    Opção inválida. Voltando para o menu de restaurantes.");
                        continuarNesteRestaurante = false; // volta para a escolha do restaurante
                        break;
                }
            }
        }
        
    }
}