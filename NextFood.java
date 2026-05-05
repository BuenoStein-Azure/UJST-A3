import Models.*;
import Service.*;

import java.util.List;
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
       
        
        // Criação dos Restaurantes e seus respectivos cardápios utilizando a classe RestaurantModel e ProdutoModel
        RestaurantModel rest1 = new RestaurantModel("Mcdonald's", "Rua das Laranjeiras, 123", 40028922, null);
        RestaurantModel rest2 = new RestaurantModel("Pizza Hut", "Avenida dos Pizzaiolos, 456", 40028923, null);
        RestaurantModel rest3 = new RestaurantModel("Mania de Churrasco", "Rua do Churrasco, 789", 40028924, null);
        RestaurantModel rest4 = new RestaurantModel("Burguer King", "Avenida dos Burgers, 321", 40028925, null);

        // Adicionando os produtos aos cardápios dos restaurantes utilizando o método setcatalogo() da classe RestaurantModel
        rest1.setcatalogo(List.of(
                new ProdutoModel("BigMac", 25.0),
                new ProdutoModel("McQuarteirão", 28.0),
                new ProdutoModel("McChicken", 22.0),
                new ProdutoModel("McCheddar", 30.0)
        ));

        rest2.setcatalogo(List.of(
            new ProdutoModel("Pizza de Queijo", 24.0),
            new ProdutoModel("Pizza de Portugueza", 25.9),
            new ProdutoModel("Pizza de Calabresa", 25.8),
            new ProdutoModel("Pizza de Churrasco", 26.8)
        ));

        rest3.setcatalogo(List.of(
            new ProdutoModel("Picanha", 45.9),
            new ProdutoModel("Frango", 25.0),
            new ProdutoModel("Queijo Coalho", 22.8),
            new ProdutoModel("Linguiça", 22.8)
        ));

        rest4.setcatalogo(List.of(
            new ProdutoModel("MegaShacker", 25.8),
            new ProdutoModel("Whopper", 30.9),
            new ProdutoModel("Whopper Vegetariano",35.8),
            new ProdutoModel("Rodeio Duplo ", 22.8)
        ));

        
       
        // Tela Entrada
        MenuInicialService.exibirMenuEntrada();

        System.out.print("\n    Escolha uma opção: ");



        // Colocar essa mesma logica mas aplicando a Herança de POO, *RestaurantModel Adiantada para aplicação dessa feature*
        while (null != null) {
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
                /*   
                boolean menuMc = true;
                   
                    while (menuMc) {
                        
                        System.out.println("\n    Você escolheu Mcdonald's!");
                        System.out.println("\n    Carregando menu do Macdonald's...");
                        
                        // pegar menu menu
                        ProdutoModel[] MenuMcc = Menu.getMenuMc();

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
                     */
                    
                case 2:
                    /*
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
                    ProdutoModel produto2 = MenuPZ[escolha2 - 1];

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
                     */
            case 3:
                /*
                System.out.println("\n    Você escolheu Mania de Churrasco!");
                System.out.println("\n    Carregando menu da Mania de Churrasco...");

                //mostrando menu churrasco
                ProdutoModel[] MenuCarne = Menu.getMenuChurrasco();
                for (int i = 0; i < MenuCarne.length; i++) {
                    System.out.println((i + 1) + ". " + MenuCarne[i].nome + " - R$ " + MenuCarne[i].preco);
                }
                System.out.print("Escolha: ");
                int escolha3 = sc.nextInt();
                if (escolha3 < 1 || escolha3 > MenuCarne.length) {
                    System.out.println("Opção inválida");
                    break;
                }
                ProdutoModel produto3 = MenuCarne[escolha3 - 1];

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
                    */

                     case 4:
                        /*
                    System.out.println("\n    Você escolheu Burguer King");
                    System.out.println("\n    Carregando menu de Burguer King...");
                    System.out.println("\n   MENU   ");
                    System.out.println(" 1. MegaShacker ");
                    System.out.println(" 2. Whopper ");
                    System.out.println(" 3. Whopper Vegetariano ");
                    System.out.println(" 4. Rodeio Duplo ");
                    ProdutoModel[] MenuBk = Menu.getMenuChurrasco();
                    for (int i = 0; i < MenuBk.length; i++) {
                        System.out.println((i + 1) + ". " + MenuBk[i].nome + " - R$ " + MenuBk[i].preco);
                    }
                    System.out.print("Escolha: ");
                    int escolha4 = sc.nextInt();
                    if (escolha4 < 1 || escolha4 > MenuBk.length) {
                        System.out.println("Opção inválida");
                        break;
                    }
                    ProdutoModel produto4 = MenuBk[escolha4 - 1];

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
 */
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