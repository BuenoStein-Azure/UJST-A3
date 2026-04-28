import java.util.Scanner;

import usermodel.ModelUser;

public class NextFood {
    //Cores ANSI para estilizar a saída no console
    static final String RESET   = "\033[0m";
    static final String VERDE_ESCURO = "\033[1;32m";
    static final String AZUL    = "\033[36m";
    static final String BRANCO = "\033[97m";
    

    

    

    // Banner da aplicação
    static void exibirBanner() {
    System.out.println(VERDE_ESCURO);
    System.out.println("  ███╗   ██╗███████╗██╗  ██╗████████╗███████╗ ██████╗  ██████╗ ██████╗ ");
    System.out.println("  ████╗  ██║██╔════╝╚██╗██╔╝╚══██╔══╝██╔════╝██╔═══██╗██╔═══██╗██╔══██╗");
    System.out.println("  ██╔██╗ ██║█████╗   ╚███╔╝    ██║   █████╗  ██║   ██║██║   ██║██║  ██║");
    System.out.println("  ██║╚██╗██║██╔══╝   ██╔██╗    ██║   ██╔══╝  ██║   ██║██║   ██║██║  ██║");
    System.out.println("  ██║ ╚████║███████╗██╔╝ ██╗   ██║   ██║     ╚██████╔╝╚██████╔╝██████╔╝");
    System.out.println("  ╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝      ╚═════╝  ╚═════╝ ╚═════╝ ");
    System.out.println(RESET);
    System.out.println(BRANCO + "                                       Peça rápido. Receba rápido. ");
    System.out.println(RESET);
    System.out.println();
    }
    public static void main(String[] args) {
        exibirBanner();
        Scanner sc = new Scanner(System.in);
       
        
        //banco de dados simulado para armazenar as informações dos usuários cadastrados
        ModelUser[] users = new ModelUser[100]; // Array para armazenar até 100 usuários
        int userCount = 0; // Contador para o número de usuários cadastrados
        
        ModelUser user1 = new ModelUser("Igor", "buceta6969", "bucetinhagames@gmail.com", "4002-8922");
        users[userCount] = user1;
        userCount++;
        
        // Tela Inicial
        System.out.println("\n      === BEM-VINDO AO NEXTFOOD ===     ");
        System.out.println("──────────────────────────────────────────");   
        System.out.println("  O que deseja fazer?");    
        System.out.println("  1. Fazer login");
        System.out.println("  2. Criar nova conta");
        System.out.println("  3. Sair");
        
        
        // Ver usarios no Banco de dados
        System.out.println("\n    Usuários cadastrados no sistema:");
        for (int i = 0; i < userCount; i++) {
            System.out.println("    - " + users[i].getUsername() +" (Senha: " + users[i].getPassword() + ","+ "(Email: " + users[i].getEmail() + ", Telefone: " + users[i].getPhoneNumber() + ")");
        }

             

        switch (sc.nextInt()) {
            case 1:
        // Tela de login verficada mas com erro de leitura do nome de usuário e senha, pois o nextInt() não consome a nova linha deixada no (), causando um comportamento inesperado. Para corrigir isso, é necessário adicionar um sc.nextLine() adicional após a leitura do número inteiro para consumir a nova linha.

        System.out.println("\n     === ÁREA DE LOGIN ===     ");
                System.out.println("──────────────────────────────────────────");
                System.out.print(AZUL + "\n  Digite seu nome de usuário: " + RESET);
                String username = sc.nextLine();
                username = sc.nextLine(); // Consumir a nova linha deixada pelo nextInt()
                System.out.print(AZUL + "  Digite sua senha: " + RESET);
                String password = sc.nextLine();
                System.out.println("──────────────────────────────────────────");
                // Verificar as credenciais do usuário
                boolean loginSuccess = false;
                for (int i = 0; i < userCount; i++) {
                    if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                        loginSuccess = true;
                        return;
                    }
                }
                if (loginSuccess == true) {
                    System.out.println("\n    Bem-vindo(a), " + username + "!");
                    // Aqui você pode adicionar a lógica para acessar o sistema após o login bem-sucedido
                } else {
                    System.out.println("\n    Acesso negado. Verifique seu nome de usuário e senha.");
                }
                break;
                
            case 2:
        // Tela de Cadastro
                System.out.println("\n     === ÁREA DE CADASTRO ===     ");
                System.out.println("──────────────────────────────────────────");
                System.out.print(AZUL + "\n  Digite seu nome de usuário: " + RESET);
                String newUsername = sc.nextLine();
                System.out.println("──────────────────────────────────────────");
                System.out.print(AZUL + "  Digite seu número de telefone: " + RESET);   
                int newPhoneNumber = sc.nextInt();
                System.out.println("──────────────────────────────────────────");
                System.out.print(AZUL + "  Digite seu email: " + RESET);
                String newEmail = sc.nextLine();
                System.out.println("──────────────────────────────────────────");
                System.out.print(AZUL + "  Digite sua senha: " + RESET);
                String newPassword = sc.nextLine();
                System.out.println("──────────────────────────────────────────");
                // Criar um novo usuário e armazenar no array
                users[userCount] = new ModelUser(newUsername, newPassword, newEmail, newPassword);
                userCount++;
                    System.out.println("\n    Conta criada com sucesso! Faça login para acessar o sistema.");
                break;

            default:
                System.out.println("\n    Opção inválida. Encerrando o programa.");
                break;
        }       


                    //Inicialização do menu de pedidos e restaurantes. 
                    System.out.println("\n             === MENU DE PEDIDOS ===     ");
                    System.out.print("\n  1. Macdonald's");
                    System.out.print("\n  2. Pizza Hut");
                    System.out.print("\n  3. Mania de Churrasco");
                    System.out.print("\n  Digite o número do restaurante que deseja pedir: ");
                    int escolhaRest = sc.nextInt();
        
                    //Estrutura de controle para escolher o restaurante e carregar o menu correspondente.
                    switch (escolhaRest) {
                        case 1:
                            System.out.println("\n    Você escolheu Macdonald's!");
                            System.out.println("\n    Carregando menu do Macdonald's...");
                            
                            break;
        
                        case 2:
                            System.out.println("\n    Você escolheu Pizza Hut!");
                            System.out.println("\n    Carregando menu da Pizza Hut...");
                            break;
        
                        case 3:
                            System.out.println("\n    Você escolheu Mania de Churrasco!");
                            System.out.println("\n    Carregando menu da Mania de Churrasco...");
                            break;
        
                        default:
                            System.out.println("\n    Opção inválida. Digite uma opção valida.");
                    } 
        
                }
            
            
}



     
/*
        if (username.equals("gabriel") && password.equals("1234")) { //caso o usuario e senha estejam corretos, ele tem acesso ao sistema.
            System.out.println("\n    Bem-vindo(a), " + username + "!");
            System.out.print("\n    Acessando o sistema...");
            System.out.print("\n    Carregando menu...");
            System.out.print("\n    Menu carregado com sucesso!");
            System.out.println("         ");
*/
