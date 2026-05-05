package Service;
import Models.*;
import Service.*;

import java.util.Scanner;

public class MenuInicialService {
    private MenuOpcaoService menuOS;
    private UserService userS;
    private LoginService loginS;
    public MenuInicialService(MenuOpcaoService menuOS, UserService userS, LoginService loginS) {
        this.menuOS = menuOS;
        this.userS = userS;
        this.loginS = loginS;
    }

    public void exibirMenuEntrada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n      === BEM-VINDO AO NEXTFOOD ===     ");
        System.out.println("──────────────────────────────────────────");
        System.out.println("  O que deseja fazer?");
        System.out.println("  1. Fazer login");
        System.out.println("  2. Criar nova conta");
        System.out.println("  3. Sair");
        do{
            switch (sc.nextInt()) {
                case 1:
    
                    boolean logado = loginS.login();
                    if(logado == true) {
                        System.out.println("\n  Estamos de Redirecionando para o Menu de Opcões..."); 
                        menuOS.exibirMenu();
                        
                        
                    } else {
                        System.out.println("\n  Login falhou. Redirecionando para o menu inicial...");
                        exibirMenuEntrada();
                        
                    }
                        
                case 2:
                    // Tela de Cadastro
                    boolean registrado = userS.registerUser();
                    if(registrado == true) {
                        System.out.println("\n  Estamos te Redirecionando para o menu inicial...");
                        exibirMenuEntrada();
                        userS.listarUsuarios();
                        
    
                    } else {
                        System.out.println("\n  Registro falhou. Redirecionando para o menu inicial...");
                        exibirMenuEntrada();
                        
                    }
                case 3:
                    System.out.println("\n Obrigado por usar nosso app!");
                    
    
                default:
                    System.out.println("\n    Opção inválida. Encerrando o programa.");
                    
            }
        } while (true);
        
        
    }
    
}
