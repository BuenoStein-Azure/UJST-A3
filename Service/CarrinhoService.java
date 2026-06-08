package Service;
import Models.*;
import static Service.UsuarioService.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Util.AppScanner;

public class CarrinhoService {
    private UserModel user;
    private double descontoCupom = 0.0; // Percentual de desconto aplicado pelo cupom (ex: 0.10 = 10%)
    private double taxaEntrega = 5.0;
   
    public CarrinhoService(UserModel user) {
        this.user = user;
    }

    public void adicionarAoCarrinho( ProdutoModel produto, RestaurantModel restaurant, int quantidade){ {
        
         user = UsuarioService.currentUser; // Obtém o usuário atualmente logado
        if (user == null) {
            System.out.println("\n    Nenhum usuário logado. Por favor, faça login para adicionar produtos ao carrinho.");
            return;
        }
        // Verifica se o carrinho do usuário é nulo e inicializa se necessário
        if (user.getCarrinho() == null) {
            user.setCarrinho(new ArrayList<>()); 
        }
         // adiciona o produto X vezes para que o cálculo de total via stream continue funcionando
         for (int i = 0; i < quantidade; i++) {
            user.getCarrinho().add(new ProdutosERestaurant(List.of(produto), List.of(restaurant)));
        }
        System.out.printf(VERDE_ESCURO + "%n    [OK] %dx %s adicionado(s) ao carrinho!" + RESET + " (R$ %.2f cada)%n",
                quantidade, produto.getNome(), produto.getPreco());
        

    //      // não sei se adicionar essa logica é hype, pq dai o usuario vai poder entrar sem logar e adicionar + uma logica pra impedir isso, mas vou deixar aqui pra caso queira implementar depois
    //      if(user == null){
    //            System.out.println("\n    Nenhum usuário logado. Por favor, faça login para adicionar produtos ao carrinho.");
    //            return;
    //        }
    
    }
}
 public void exibirCarrinho() {
        user = UsuarioService.currentUser;
        if (user == null || user.getCarrinho() == null || user.getCarrinho().isEmpty()) {
            System.out.println("\n    Seu carrinho está vazio.");
            return; // Verifica se o carrinho do usuário é nulo ou vazio e exibe mensagem apropriada
        }
 
         System.out.println(BRANCO + "\n     === CARRINHO ATUAL ===     " + RESET);
        System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
        imprimirItensDaLista(user.getCarrinho());

    }

        public void exibirPedidosFeitos() {
        // Verifica se o histórico de pedidos do usuário é nulo ou vazio e exibe mensagem apropriada
        List<List<ProdutosERestaurant>> historico = user != null ? user.getHistoricoPedidos() : null;
        
        if(historico == null || historico.isEmpty()){
            System.out.println("\n Você ainda não finalizou nenhum pedido nesta sessão.");
            MenuInicialService mIS = new MenuInicialService();
            mIS.exibirMenuEntrada();
            return;
        }

        System.out.println(BRANCO + "\n     === HISTÓRICO DE PEDIDOS ===     " + RESET);
        System.out.println(VERDE_ESCURO + "==============================================" + RESET);
 
        for (int p = 0; p < historico.size(); p++) {
            System.out.printf("%n  Pedido #%d%n", p + 1);
            System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
            imprimirItensDaLista(historico.get(p));
        }
 
        System.out.println(VERDE_ESCURO + "===============================================" + RESET);
    }
    
// ver dps
    //public void exibirCarrinho(){
    //    
    //}
  public void finalizarCompra(){
            // aqui você pode implementar a lógica para finalizar a compra, como calcular o total, processar o pagamento, etc.
        // Tela de Pagamento

        exibirCarrinho();

        //
         if (user == null || user.getCarrinho() == null || user.getCarrinho().isEmpty()) {
            System.out.println("\n    Adicione produtos antes de finalizar a compra.");
            return;
        }

        // Pergunta se o usuário tem cupom de desconto antes de exibir as formas de pagamento
        aplicarCupom();

        System.out.println(BRANCO + "\n     === ÁREA DE PAGAMENTO ===     " + RESET);
        System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
        System.out.print("\n    Forma de pagamento:\n"
                + "    1 - Cartão de Débito\n"
                + "    2 - Cartão de Crédito\n"
                + "    3 - Pix\n"
                + "    4 - VR / VA\n"
                + "    Escolha: ");
    
        switch (AppScanner.get().nextInt()) {
            case 1:
                System.out.println("\n    Você escolheu pagar com Cartão de Debito.");
                processarCartao("débito");
                confirmarEFecharPedido(); 
                new MenuOpcaoService().exibirMenu();
                break;

             case 2:
                System.out.println("\n    Você escolheu pagar com Cartão de Crédito.");
                processarCartao("crédito");
                confirmarEFecharPedido();
                new MenuOpcaoService().exibirMenu();

                break;
                        
            case 3:
                System.out.println("\n    Você escolheu pagar com Pix.");
                GeradorPixService geradorPixService = new GeradorPixService();
                geradorPixService.gerarChavePix();
                confirmarEFecharPedido();
                new MenuOpcaoService().exibirMenu();
            
                break;
                        
            case 4:
                System.out.println("\n    Você escolheu pagar com VR/VA");
                // VR/VA não precisa entrar no metodo de pagamento pq o VR/VA é instantaneo.
                System.out.println("\n    Finalizando compra com VR/VA...");
                confirmarEFecharPedido();
                new MenuOpcaoService().exibirMenu();

                break;

                    }
            }

    private void processarCartao(String tipo) {
        if (user.getMetodoPagamento() == null) {
            System.out.println("\n    Você não possui cartão cadastrado.");
            System.out.print("    Deseja cadastrar agora? (1 - Sim / 2 - Não): ");
            if (AppScanner.get().nextInt() == 1) {
                MetodosDePagamento mp = new MetodosDePagamento();
                if (tipo.equals("débito")) {
                    mp.cadastroMetodoPagamentoDebito();
                    
                } else {
                    mp.cadastroMetodoPagamentoCredito();
                    
                }
            } else {
                System.out.println(VERMELHO + "\n    Pagamento cancelado." + RESET);
                return;
            }
        } else {
            System.out.println("\n Você possui os seguintes cartões cadastrados: ");
            for (Object cartao : user.getMetodoPagamento()) {
                System.out.println("    - " + cartao);
            }
            System.out.println("\n    Deseja finalizar a compra com um desses cartões? (1 - Sim / 2 - Não): ");
            if (AppScanner.get().nextInt() == 1) {
                System.out.println("\n Escolha o cartão que deseja usar para finalizar a compra: ");
                ArrayList<Object> cartoes = new ArrayList<>(user.getMetodoPagamento());
                for (int i = 0; i < cartoes.size(); i++) {
                    System.out.println((i + 1) + " - " + cartoes.get(i));
                }
                System.out.print("    Opção: ");
                int opcao = AppScanner.get().nextInt();
                if (opcao >= 1 && opcao <= cartoes.size()) {
                    System.out.println("\n    Finalizando compra com cartão de " + tipo + "...");
                    
                } else {
                    System.out.println("\n    Opção inválida.");
                    return;
                }
            } else {
                System.out.println(VERMELHO + "\n    Pagamento cancelado." + RESET);
                System.out.println("\n    Redirecionando para a tela de pagamento...");
                finalizarCompra();
                return;
               
            }
            
        }
    }

    private double obterTaxaEntrega() {
        return user != null ? user.getTaxaEntrega() : taxaEntrega;
    }

    private void imprimirItensDaLista(List<ProdutosERestaurant> lista) {
    double subtotal = 0;

    for (int i = 0; i < lista.size(); i++) {
        ProdutoModel p        = lista.get(i).getProdutos().get(0);
        String restaurante    = lista.get(i).getRestaurantes().get(0).getRestaurantName();

        System.out.printf("    %d. %s [%s]  R$ %.2f%n", i + 1, p.getNome(), restaurante, p.getPreco());
        subtotal += p.getPreco();
        }

    double taxa = obterTaxaEntrega();
    double total = subtotal + taxa;

    System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
    System.out.printf("    Taxa de Entrega: R$ %.2f%n", taxa);
    System.out.printf("    Total: R$ %.2f%n", total);
    System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
    }


    private void confirmarEFecharPedido() {
        double subtotal = user.getCarrinho().stream()
                .flatMap(c -> c.getProdutos().stream())
                .mapToDouble(ProdutoModel::getPreco)
                .sum();
        double taxa = obterTaxaEntrega();

        // Aplica o desconto do cupom caso tenha sido informado
        if (descontoCupom > 0) {
            double valorDesconto = subtotal * descontoCupom;
            double totalComDesconto = subtotal - valorDesconto + taxa;
            System.out.printf(AMARELO + "    Cupom aplicado! Desconto de %.0f%%: -R$ %.2f" + RESET + "%n", descontoCupom * 100, valorDesconto);
            System.out.printf(VERDE_ESCURO + "    [OK] Pagamento confirmado!%n" + RESET);
            System.out.printf("    Valor total cobrado: R$ %.2f%n", totalComDesconto);
        } else {
            double total = subtotal + taxa;
            System.out.printf(VERDE_ESCURO + "    [OK] Pagamento confirmado!%n" + RESET);
            System.out.printf("    Valor total cobrado: R$ %.2f%n", total);
        }

        System.out.println("\n    Obrigado pela preferencia! Seu pedido esta a caminho.");
        System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
    
        // salva o pedido no histórico antes de limpar
        if (user.getHistoricoPedidos() == null) {
            user.adicionarPedidoAoHistorico(new ArrayList<>());
        }
        user.getHistoricoPedidos().add(new ArrayList<>(user.getCarrinho()));
    
        // limpa o carrinho após o pagamento
        user.setCarrinho(new ArrayList<>());
    }

    // Pergunta ao usuário se possui cupom de desconto e valida o código informado
    private void aplicarCupom() {
        descontoCupom = 0.0; // Reseta o desconto a cada compra
        System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
        System.out.print("\n    Possui cupom de desconto? (1 - Sim / 2 - Não): ");
        if (AppScanner.get().nextInt() == 1) {
            AppScanner.get().nextLine(); // Consome o '\n' deixado pelo nextInt()
            System.out.print("    Digite o cupom: ");
            String cupom = AppScanner.get().nextLine().trim();
            if (cupom.equalsIgnoreCase("macion10")) {
                descontoCupom = 0.10; // 10% de desconto
                System.out.println(AMARELO + "\n    [OK] Cupom \"macion10\" aplicado! Voce ganhou 10% de desconto." + RESET);
            } else {
                System.out.println(VERMELHO + "\n    Cupom inválido. Nenhum desconto será aplicado." + RESET);
            }
        }
    }
}
