package Service;
import Models.*;
import Service.*;

import java.util.Scanner;

public class MenuInicialService {

    public static boolean exibirMenuEntrada() {
        Scanner sc = new Scanner(System.in);
        LoginService loginService = new LoginService();
        UserService userService = new UserService();
        System.out.println("\n      === BEM-VINDO AO NEXTFOOD ===     ");
        System.out.println("──────────────────────────────────────────");
        System.out.println("  O que deseja fazer?");
        System.out.println("  1. Fazer login");
        System.out.println("  2. Criar nova conta");
        System.out.println("  3. Sair");
        switch (sc.nextInt()) {
            case 1:

                boolean logado = loginService.login();
                if(logado == true) {
                    System.out.println("\n  Estamos de Redirecionando para o Menu de Opcões..."); 
                    MenuOpcaoService.exibirMenu();
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
