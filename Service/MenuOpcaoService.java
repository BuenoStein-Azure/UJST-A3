package Service;
import static Service.UsuarioService.BRANCO;
import static Service.UsuarioService.RESET;
import java.util.Scanner;

public class MenuOpcaoService {

    private RestauranteService restaurantService;
    public MenuOpcaoService(RestauranteService restaurantService) {
        this.restaurantService = restaurantService;
    }
    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("\n    Oque deseja fazer?");
        System.out.println(BRANCO + "    1." + RESET + " Fazer um pedido");
        System.out.println(BRANCO + "    2." + RESET + " Ver meus pedidos");
        System.out.println(BRANCO + "    3." + RESET + " Voltar ao menu principal");
        System.out.print("    Escolha uma opção: ");

        switch (sc.nextInt()) {
            case 1:
                MenuRestauranteService menuRestauranteService = new MenuRestauranteService(new RestauranteService());
                menuRestauranteService.Menu();
                break;
    
            case 2:       
                CarrinhoService carrinhoService = new CarrinhoService(UsuarioService.currentUser);
                carrinhoService.exibirPedidosFeitos();
                break;
            case 3: 
                MenuInicialService menuInicialService = new MenuInicialService();
                menuInicialService.exibirMenuEntrada();
                break;
            default:
                break;
        }
        sc.close();    
    }
}