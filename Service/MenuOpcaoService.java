package Service;
import java.util.Scanner;

public class MenuOpcaoService {

    private RestauranteService restaurantService;
    public MenuOpcaoService(RestauranteService restaurantService) {
        this.restaurantService = restaurantService;
    }
    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("\n    Oque deseja fazer?");
        System.out.println("    1. Fazer um pedido");
        System.out.println("    2. Ver meus pedidos");
        System.out.println("    3. Voltar ao menu principal");
        System.out.print("    Escolha uma opção: ");

        switch (sc.nextInt()) {
            case 1:
                MenuRestauranteService menuRestauranteService = new MenuRestauranteService(new RestauranteService());
                menuRestauranteService.Menu();
                break;
            
            case 2:

                break;

            case 3: 
            
                break;
            default:
                break;
        }
        sc.close();    
    }
    
}