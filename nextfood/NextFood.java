package nextfood;
import models.UserModel;
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


        //banco de dados simulado para armazenar as informações dos usuários cadastrados
        UserModel[] users = new UserModel[100]; // Array para armazenar até 100 usuários
        int userCount = 0; // Contador para o número de usuários cadastrados

        UserModel user1 = new UserModel("Igor", "buceta6969", "bucetinhagames@gmail.com", "4002-8922");
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
            System.out.println("    - " + users[i].getUsername() + " (Senha: " + users[i].getPassword() + "," + "(Email: " + users[i].getEmail() + ", Telefone: " + users[i].getPhone() + ")");
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

                    // TODO: Adicionar a lógica para acessar o sistema após o login bem-sucedido


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
                users[userCount] = new UserModel(newUsername, newPassword, newEmail, newPassword);
                userCount++;
                System.out.println("\n    Conta criada com sucesso! Faça login para acessar o sistema.");

                // TODO: adicionar logica para enviar para o menu novamente após a criação do Usuario


                break;

            default:
                System.out.println("\n    Opção inválida. Encerrando o programa.");
                break;
        }

        // Colocar essa mesma logica mas aplicando a Herança de POO, *RestaurantModel Adiantada para aplicação dessa feature*
        while (true) {
            //Inicialização do menu de pedidos e restaurantes.
            System.out.println("\n             === MENU DE PEDIDOS ===     ");
            System.out.print("\n  1. Mcdonald's");
            System.out.print("\n  2. Pizza Hut");
            System.out.print("\n  3. Mania de Churrasco");
            System.out.print("\n  4. Burguer King ");
            System.out.print("\n  Digite a opção do restaurante: ");
            //Estrutura de controle para escolher o restaurante e carregar o menu correspondente.
            int escolhaRest = sc.nextInt();
            switch (escolhaRest) {
                case 1:
                    boolean menuMc = true;
                    while (menuMc) {
                        System.out.println("\n    Você escolheu Macdonald's!");
                        System.out.println("\n    Carregando menu do Macdonald's...");
                        // pegar menu menu
                        Produto[] MenuMcc = Menu.getMenuMc();

                        // mostrar menu
                        for (int i = 0; i < MenuMcc.length; i++) {
                            System.out.println((i + 1) + ". " + MenuMcc[i].nome + " - R$ " + MenuMcc[i].preco);
                        }

                        //  usuário escolhe
                        System.out.println("     Qual vai ser a opção: ");
                        int escolha1 = sc.nextInt();
                        if (escolha1 < 1 || escolha1 > MenuMcc.length) {
                            System.out.println("Opção inválida");
                            continue;
                        }
                        Produto produto1 = MenuMcc[escolha1 - 1];

                        System.out.print("Quantidade: ");
                        int qtd1 = sc.nextInt();

                        double total1 = produto1.preco * qtd1;
                        sc.nextLine();
                            // colocar desconto de 10%
                        System.out.print("Cupom: ");
                        String cupom1 = sc.nextLine();
                        if (cupom1.equalsIgnoreCase("DESCONTO10")) {
                            total1 = total1 * 0.9;
                            System.out.println("Cupom aplicado! ");
                        }
                        System.out.print("Método pagamento (1-Débito / 2-Crédito / 3-Pix): ");
                        int metodo1 = sc.nextInt();
1
                        Pagamento pagamento = new Pagamento();
                        double totalFinal = pagamento.processarPagamento(total1, metodo1);

                        System.out.println("Total final: R$ " + totalFinal);
                        System.out.println("\n1 - Comprar mais ");
                        System.out.println("\n2 - Voltar Menu ");
                        int op = sc.nextInt();
                        if (op == 2) {
                            menuMc = false;
                        }
                    }
                    break;
                case 2:

                    System.out.println("\n    Você escolheu Pizza Hut!");
                    System.out.println("\n    Carregando menu da Pizza Hut...");
                    //mostrando menu pizza
                    Produto[] MenuPZ = Menu.getMenuPizza();
                    for (int i = 0; i < MenuPZ.length; i++) {
                        System.out.println((i + 1) + ". " + MenuPZ[i].nome + " - R$ " + MenuPZ[i].preco);
                    }
                    System.out.print("Escolha: ");
                    int escolha2 = sc.nextInt();
                    if (escolha2 < 1 || escolha2 > MenuPZ.length) {
                        System.out.println("Opção inválida");
                        break;
                    }
                    Produto produto2 = MenuPZ[escolha2 - 1];

                    System.out.print("Quantidade: ");
                    int qtd2 = sc.nextInt();

                    double total2 = produto2.preco * qtd2;
                    System.out.print("Cupom: ");
                    String cupom2 = sc.nextLine();
                    if (cupom2.equalsIgnoreCase("DESCONTO10")) {
                        total2 = total2 * 0.9;
                        System.out.println("Cupom aplicado! ");
                    }
                    System.out.print("Método pagamento (1-Débito / 2-Crédito / 3-Pix): ");
                    int metodo2 = sc.nextInt();

                    Pagamento pagamento = new Pagamento();
                    double totalFinal = pagamento.processarPagamento(total2, metodo2);

                    System.out.println("Total final: R$ " + totalFinal);
                    break;
            case 3:
                System.out.println("\n    Você escolheu Mania de Churrasco!");
                System.out.println("\n    Carregando menu da Mania de Churrasco...");

                //mostrando menu churrasco
                Produto[] MenuCarne = Menu.getMenuChurrasco();
                for (int i = 0; i < MenuCarne.length; i++) {
                    System.out.println((i + 1) + ". " + MenuCarne[i].nome + " - R$ " + MenuCarne[i].preco);
                }
                System.out.print("Escolha: ");
                int escolha3 = sc.nextInt();
                if (escolha3 < 1 || escolha3 > MenuCarne.length) {
                    System.out.println("Opção inválida");
                    break;
                }
                Produto produto3 = MenuCarne[escolha3 - 1];

                System.out.print("Quantidade: ");
                int qtd3 = sc.nextInt();

                double total3 = produto3.preco * qtd3;
                System.out.print("Cupom: ");
                String cupom3 = sc.nextLine();
                if (cupom3.equalsIgnoreCase("DESCONTO10")) {
                    total3 = total3 * 0.9;
                    System.out.println("Cupom aplicado! ");

                    System.out.print("Método pagamento (1-Débito / 2-Crédito / 3-Pix): ");
                    int metodo3 = sc.nextInt();

                    Pagamento pagamento3 = new Pagamento();
                    double totalFinal2 = pagamento3.processarPagamento(total3, metodo3);

                    System.out.println("Total final: R$ " + totalFinal2);
                    break;
                }
                     case 4:
                    System.out.println("\n    Você escolheu Burguer King");
                    System.out.println("\n    Carregando menu de Burguer King...");
                    System.out.println("\n   MENU   ");
                    System.out.println(" 1. MegaShacker ");
                    System.out.println(" 2. Whopper ");
                    System.out.println(" 3. Whopper Vegetariano ");
                    System.out.println(" 4. Rodeio Duplo ");
                    Produto[] MenuBk = Menu.getMenuChurrasco();
                    for (int i = 0; i < MenuBk.length; i++) {
                        System.out.println((i + 1) + ". " + MenuBk[i].nome + " - R$ " + MenuBk[i].preco);
                    }
                    System.out.print("Escolha: ");
                    int escolha4 = sc.nextInt();
                    if (escolha4 < 1 || escolha4 > MenuBk.length) {
                        System.out.println("Opção inválida");
                        break;
                    }
                    Produto produto4 = MenuBk[escolha4 - 1];

                    System.out.print("Quantidade: ");
                    int qtd4 = sc.nextInt();

                    double total4 = produto4.preco * qtd4;
                    System.out.print("Cupom: ");

                    String cupom4 = sc.nextLine();
                    if (cupom4.equalsIgnoreCase("DESCONTO10")) {
                        total4 = total4 * 0.9;
                        System.out.println("Cupom aplicado! ");
                    }

                        System.out.print("Método pagamento (1-Débito / 2-Crédito / 3-Pix): ");
                        int metodo4 = sc.nextInt();

                        Pagamento pagamento3 = new Pagamento();
                        double totalFinal2 = pagamento3.processarPagamento(total4, metodo4);

                        System.out.println("Total final: R$ " + totalFinal2);
                        break;
                        default:
                            System.out.println("\n    Opção inválida. Digite uma opção valida.");
                            break;

                    }


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