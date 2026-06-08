package Service;
import static Service.UsuarioService.*;
import Util.AppScanner;

public class AutenticacaoService {


    public boolean login() {
        System.out.println(BRANCO + "\n     === ÁREA DE LOGIN ===     " + RESET);
                System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
                System.out.print(AZUL + "\n  Digite seu nome de usuário: " + RESET);
                String username = AppScanner.get().nextLine();
                System.out.println("------------------------------------------");
                System.out.print(AZUL + "  Digite sua senha: " + RESET);
                String password = AppScanner.get().nextLine();
                System.out.println("------------------------------------------");
                // Verificar as credenciais do usuário
                boolean loginSuccess = false;
                for (int i = 0; i < UsuarioService.userCount; i++) {
                    if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                        UsuarioService.currentUser = users[i]; // Armazena o usuário logado
                        loginSuccess = true;
                        break;
                    }
                }
                if (loginSuccess == true) {
                    System.out.println("\n    Bem-vindo(a), " +  BRANCO + username + RESET + "!");
                    
                } else {
                    System.out.println(VERMELHO + "\n    Acesso negado." + RESET + " Verifique seu nome de usuário e senha.");
                }
                return loginSuccess;
    }    
}
