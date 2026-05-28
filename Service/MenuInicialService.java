package Service;
import static Service.UsuarioService.BRANCO;
import static Service.UsuarioService.RESET;
import static Service.UsuarioService.VERDE_ESCURO;
import Util.AppScanner;

public class MenuInicialService {

    public boolean exibirMenuEntrada() {
        
        AutenticacaoService loginService = new AutenticacaoService();
        UsuarioService userService = new UsuarioService();

        System.out.println(BRANCO + "\n      === BEM-VINDO AO NEXTFOOD ===     " + RESET);
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        System.out.println("  O que deseja fazer?");
        System.out.println(BRANCO + "  1." + RESET + " Fazer login");
        System.out.println(BRANCO + "  2." + RESET + " Criar nova conta");
        System.out.println(BRANCO + "  3." + RESET + " Sair");
        switch (AppScanner.get().nextInt()) {
            case 1:
                AppScanner.get().nextLine(); // limpa o \n sobrando
                boolean logado = loginService.login();
                if(logado == true) {
                    System.out.println("\n  Estamos de Redirecionando para o Menu de Opcões..."); 
                    MenuOpcaoService menuOpcaoService = new MenuOpcaoService();
                    menuOpcaoService.exibirMenu();
                    return true;
                    
                } else {
                    System.out.println("\n  Login falhou. Redirecionando para o menu inicial...");
                    return  exibirMenuEntrada();
                }
                    
            case 2:
                // Tela de Cadastro
                boolean registrado = userService.registerUser();
                if(registrado == true) {
                    System.out.println("\n  Estamos te Redirecionando para o menu inicial...");
                    exibirMenuEntrada();
                    userService.listarUsuarios();
                    return true;

                } else {
                    System.out.println("\n  Registro falhou. Redirecionando para o menu inicial...");
                    return exibirMenuEntrada();
                }
            case 3:
                System.out.println("\n Obrigado por usar nosso app!");
                return false;

            default:
                System.out.println("\n    Opção inválida. Encerrando o programa.");
                return false;       
        }  
    }
}