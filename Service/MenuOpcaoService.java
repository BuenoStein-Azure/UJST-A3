package Service;
import Models.*;
import Service.*;
import java.util.Scanner;

public class MenuOpcaoService {
    
    public static void exibirMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n    Oque deseja fazer?");
        System.out.println("    1. Fazer um pedido");
        System.out.println("    2. Ver meus pedidos");
        System.out.println("    3. Voltar ao menu principal");
        System.out.print("    Escolha uma opção: ");

        switch (sc.nextInt()) {
            case 1:
                MenuRestauranteService.Menu();
                break;
            
            case 2:

                break;

            case 3: 
            
                break;
            default:
                break;
        }
        
    }
}
