package Service;

import java.util.Scanner;

import Models.UserModel;
public class UserService {
            //Cores ANSI para estilizar a saída no console
    static final String RESET   = "\033[0m";
    static final String VERDE_ESCURO = "\033[1;32m";
    static final String AZUL    = "\033[36m";
    static final String BRANCO = "\033[97m";
    
        public static final int MAX_USERS = 100;
        public static UserModel[] users = new UserModel[MAX_USERS];
        public static int userCount = 0;   
        
        Scanner sc = new Scanner(System.in);

        public boolean registerUser() {
            // Tela de Cadastro
            
            System.out.println("\n     === ÁREA DE CADASTRO ===     ");
            System.out.println("──────────────────────────────────────────");
            System.out.print(AZUL + "\n  Digite seu nome de usuário: " + RESET);
            String username = sc.nextLine();
            System.out.println("──────────────────────────────────────────");
            System.out.print(AZUL + "  Digite seu número de telefone: " + RESET);
            Double phoneNumber = sc.nextDouble();
            System.out.println("──────────────────────────────────────────");
            System.out.print(AZUL + "  Digite seu email: " + RESET);
            String email2 = sc.nextLine();
            String email = sc.nextLine();
            System.out.println("──────────────────────────────────────────");
            System.out.print(AZUL + "  Digite sua senha: " + RESET);
            String password = sc.nextLine();
            System.out.println("──────────────────────────────────────────");

            boolean registerUser = false;
            if (userCount < MAX_USERS) {
                users[userCount] = new UserModel(username, password, email, phoneNumber);
                userCount++;
                System.out.println("\n    Usuário registrado com sucesso!");
                return registerUser = true;
                
            } else {
                System.out.println("\n    Limite máximo de usuários atingido. Não é possível registrar mais usuários.");
            }
            return registerUser;
        }    
        public void listarUsuarios() {
            System.out.println("\n    Lista de Usuários Registrados:");
            for (int i = 0; i < userCount; i++) {
                System.out.println("    " + users[i].getUsername() + " - " + users[i].getEmail() + " - " + users[i].getPhoneNumber());
            }
        }
         
}
