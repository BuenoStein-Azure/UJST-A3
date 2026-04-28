import java.util.Scanner;

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
        
        // Tela de login
        System.out.println("\n     === ÁREA DE LOGIN ===     ");
        System.out.println("──────────────────────────────────────────");
        System.out.print(AZUL + "\n  Digite seu nome de usuário: " + RESET);
        String username = sc.nextLine();
        System.out.println("──────────────────────────────────────────");
        System.out.print(AZUL + "  Digite sua senha: " + RESET);
        String password = sc.nextLine();
        System.out.println("──────────────────────────────────────────");

        if (username.equals("gabriel") && password.equals("1234")) { //caso o usuario e senha estejam corretos, ele tem acesso ao sistema.
            System.out.println("\n    Bem-vindo(a), " + username + "!");
            System.out.print("\n    Acessando o sistema...");
            System.out.print("\n    Carregando menu...");
            System.out.print("\n    Menu carregado com sucesso!");
            System.out.println("         ");

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

            //se a senha estiver incorreta, o sistema nega o acesso e exibe uma mensagem de erro.
        } else {
            System.out.println("\n    Acesso negado. Verifique seu nome de usuário e senha.");
        }
    }
}