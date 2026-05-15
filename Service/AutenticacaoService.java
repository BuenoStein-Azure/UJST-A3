package Service;
import static Service.UsuarioService.users;

import java.util.Scanner;
import Models.*;
import Service.*;


public class AutenticacaoService {
    static final String RESET   = "\033[0m";
    static final String VERDE_ESCURO = "\033[1;32m";
    static final String AZUL    = "\033[36m";
    static final String BRANCO = "\033[97m";
    

    Scanner sc = new Scanner(System.in);
    public boolean login() {
        System.out.println("\n     === ÁREA DE LOGIN ===     ");
                System.out.println("──────────────────────────────────────────");
                System.out.print(AZUL + "\n  Digite seu nome de usuário: " + RESET);
                String username = sc.nextLine();
                System.out.println("──────────────────────────────────────────");
                System.out.print(AZUL + "  Digite sua senha: " + RESET);
                String password = sc.nextLine();
                System.out.println("──────────────────────────────────────────");
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
                    System.out.println("\n    Bem-vindo(a), " + username + "!");
                    

                } else {
                    System.out.println("\n    Acesso negado. Verifique seu nome de usuário e senha.");
                }
                return loginSuccess;
    }
    
    
}
