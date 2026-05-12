package Service;
import Models.*;
import Service.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CarrinhoService {
    private UserModel user;
    private ProdutoModel produto;
    private Scanner sc = new Scanner(System.in);
   
    public CarrinhoService(UserModel user, ProdutoModel produto) {
        this.user = user;
        this.produto = produto;
        
    }

    public void adicionarAoCarrinho(ProdutoModel produto, RestaurantModel restaurant){ {
        
         user = UserService.currentUser; // Obtém o usuário atualmente logado
        if (user == null) {
            System.out.println("\n    Nenhum usuário logado. Por favor, faça login para adicionar produtos ao carrinho.");
            return;
        }
        // Verifica se o carrinho do usuário é nulo e inicializa se necessário
        if (user.getCarrinho() == null) {
            user.setCarrinho(new ArrayList<>()); 
        }
        // Adiciona o produto ao carrinho do usuário
        user.getCarrinho().add(new ProdutosERestaurant(List.of(produto), List.of(restaurant)));  // Adiciona o produto ao carrinho do usuário, associando-o ao restaurante correspondente
        System.out.println("\n    Produto adicionado ao carrinho: " + produto.getNome() + " - R$" + produto.getPreco());
        
    //      // não sei se adicionar essa logica é hype, pq dai o usuario vai poder entrar sem logar e adicionar + uma logica pra impedir isso, mas vou deixar aqui pra caso queira implementar depois
    //      if(user == null){
    //            System.out.println("\n    Nenhum usuário logado. Por favor, faça login para adicionar produtos ao carrinho.");
    //            return;
    //        }
    }
    
}
// ver dps
    //public void exibirCarrinho(){
    //    
    //}
  public void finalizarCompra(){
            // aqui você pode implementar a lógica para finalizar a compra, como calcular o total, processar o pagamento, etc.
        // Tela de Pagamento
        System.out.println("\n     === ÁREA DE PAGAMENTO ===     ");
        System.out.println("──────────────────────────────────────────");
        System.out.print("\n Qual é a forma de pagamento? (1 - Cartão de Crédito / 2 - Boleto / 3 - Pix): ");
        // aqui você pode adicionar a lógica para processar a escolha do método de pagamento, como
        switch (sc.nextInt()) {
            case 1:
                System.out.println("\n    Você escolheu pagar com Cartão de Debito.");


                if(user.getMetodoPagamento() == null){
                    System.out.println("\n    Você não possui nem um método de pagamento cadastrado.");
                    System.out.println("\n    Deseja cadastrar um método de pagamento? (1 - Sim / 2 - Não)");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("\n    Qual método de pagamento deseja cadastrar? (1 - Cartão de Debito / 2 - Cartão de Crédito)");
                            switch (sc.nextInt()) {
                                case 1:
                                    MetodosDePagamento metodosDePagamento = new MetodosDePagamento();
                                    metodosDePagamento.cadastroMetodoPagamentoDebito();
                                     System.out.println("\n    Deseja cadastrar outro método de pagamento? (1 - Sim / 2 - Não)");
                                        switch (sc.nextInt()) {
                                            case 1:
                                                System.out.println("\n    Qual método de pagamento deseja cadastrar? (1 - Cartão de Debito / 2 - Cartão de Crédito)");
                                                 switch (sc.nextInt()) {
                                                     case 1:
                                                         metodosDePagamento.cadastroMetodoPagamentoDebito();
                                                         break;
                                                     case 2:
                                                         metodosDePagamento.cadastroMetodoPagamentoCredito();
                                                         break;
                                                     default:
                                                         System.out.println("\n    Opção inválida!");
                                                         break;
                                                 }
                                                 break;
                                            case 2:
                                                System.out.println("\n    Finalizando compra com método de pagamento cadastrado...");
                                                System.out.println("\n    Método de pagamento cadastrado: " + user.getMetodoPagamento());
                                                System.out.println("\n    Valor total da compra: R$ " + user.getCarrinho().stream().flatMap(c -> c.getProdutos().stream()).mapToDouble(ProdutoModel::getPreco).sum());
                                                // stream, flatmap, maptoDouble e sum para calcular o valor total da compra somando o preço de todos os produtos no carrinho do usuário
                                                break;
                                            default:
                                                System.out.println("\n    Opção inválida!");
                                                break;
                                        }
                                    break;
                                case 2:
                                    metodosDePagamento = new MetodosDePagamento();
                                    metodosDePagamento.cadastroMetodoPagamentoCredito();
                                     System.out.println("\n    Deseja cadastrar outro método de pagamento? (1 - Sim / 2 - Não)");
                                        switch (sc.nextInt()) {
                                            case 1:
                                                System.out.println("\n    Qual método de pagamento deseja cadastrar? (1 - Cartão de Debito / 2 - Cartão de Crédito)");
                                                 switch (sc.nextInt()) {
                                                     case 1:
                                                         metodosDePagamento.cadastroMetodoPagamentoDebito();
                                                         break;
                                                     case 2:
                                                         metodosDePagamento.cadastroMetodoPagamentoCredito();
                                                         break;
                                                     default:
                                                         System.out.println("\n    Opção inválida!");
                                                         break;
                                                 }
                                                 break;
                                            case 2:
                                                System.out.println("\n    Finalizando compra com método de pagamento cadastrado...");
                                                System.out.println("\n    Método de pagamento cadastrado: " + user.getMetodoPagamento());
                                                System.out.println("\n    Valor total da compra: R$ " + user.getCarrinho().stream().flatMap(c -> c.getProdutos().stream()).mapToDouble(ProdutoModel::getPreco).sum());
                                                break;
                                            default:
                                                System.out.println("\n    Opção inválida!");
                                                break;
                                        }
                                    break;
                            
                                default:
                                    System.out.println("\n    Opção inválida!");
                                    break;
                            }
                        }}
                            break;
                        case 2:
                            System.out.println("\n   Você escolheu Pagar com Cartão de Credito");
                            if(user.getMetodoPagamento() == null){
                            System.out.println("\n    Você não possui nem um método de pagamento cadastrado.");
                            System.out.println("\n    Deseja cadastrar um método de pagamento? (1 - Sim / 2 - Não)");
                            switch (sc.nextInt()) { 

                                case 1:
                                    System.out.println("\n    Qual método de pagamento deseja cadastrar? (1 - Cartão de Debito / 2 - Cartão de Crédito)");
                                    switch (sc.nextInt()) {
                                        case 1:
                                            MetodosDePagamento metodosDePagamento = new MetodosDePagamento();
                                            metodosDePagamento.cadastroMetodoPagamentoDebito();
                                             System.out.println("\n    Deseja cadastrar outro método de pagamento? (1 - Sim / 2 - Não)");
                                                switch (sc.nextInt()) {
                                                    case 1:
                                                        System.out.println("\n    Qual método de pagamento deseja cadastrar? (1 - Cartão de Debito / 2 - Cartão de Crédito)");
                                                         switch (sc.nextInt()) {
                                                             case 1:
                                                                 metodosDePagamento.cadastroMetodoPagamentoDebito();
                                                                 break;
                                                             case 2:
                                                                 metodosDePagamento.cadastroMetodoPagamentoCredito();
                                                                 break;
                                                             default:
                                                                 System.out.println("\n    Opção inválida!");
                                                                 break;
                                                         }
                                                         break;
                                                    case 2:
                                                        System.out.println("\n    Finalizando compra com método de pagamento cadastrado...");
                                                        System.out.println("\n    Método de pagamento cadastrado: " + user.getMetodoPagamento());
                                                        System.out.println("\n    Valor total da compra: R$ " + user.getCarrinho().stream().flatMap(c -> c.getProdutos().stream()).mapToDouble(ProdutoModel::getPreco).sum());
                                                        break;
                                                    default:
                                                        System.out.println("\n    Opção inválida!");
                                                        break;
                                                }
                                            break;
                                        case 2:
                                            metodosDePagamento = new MetodosDePagamento();
                                            metodosDePagamento.cadastroMetodoPagamentoCredito();
                                             System.out.println("\n    Deseja cadastrar outro método de pagamento? (1 - Sim / 2 - Não)");
                                                switch (sc.nextInt()) {
                                                    case 1:
                                                        System.out.println("\n    Qual método de pagamento deseja cadastrar? (1 - Cartão de Debito / 2 - Cartão de Crédito)");
                                                         switch (sc.nextInt()) {
                                                             case 1:
                                                                 metodosDePagamento.cadastroMetodoPagamentoDebito();
                                                                 break;
                                                             case 2:
                                                                 metodosDePagamento.cadastroMetodoPagamentoCredito();
                                                                 break;
                                                             default:
                                                                 System.out.println("\n    Opção inválida!");
                                                                 break;
                                                         }
                                                         break;
                                                    case 2:
                                                        System.out.println("\n    Finalizando compra com método de pagamento cadastrado...");
                                                        System.out.println("\n    Método de pagamento cadastrado: " + user.getMetodoPagamento());
                                                        System.out.println("\n    Valor total da compra: R$ " + user.getCarrinho().stream().flatMap(c -> c.getProdutos().stream()).mapToDouble(ProdutoModel::getPreco).sum());
                                                        break;
                                                    default:
                                                        System.out.println("\n    Opção inválida!");
                                                        break;
                                                }
                                            break;
                                        default:
                                            System.out.println("\n    Opção inválida!");
                                            break;
                                    } 
                                } 
                            }
                                    break;
                        case 3:
                            System.out.println("\n    Você escolheu pagar com Pix.");
                            // pix não precisa entrar no metodo de pagamento pq o pix é instantaneo.
                            System.out.println("\n     Copie e Cole no seu aplicativo do banco essa chave:");
                            // Fazer um codigo onde gera uma chave pix aleatoria a cada ves que o usuario escolhe pagar com pix
                            
                            // Logica aqui


                            // deixei esse valor padrão mas retire quando adicionar a logica pra gerar a chave pix aleatoria
                            String chavePix = "123e4567-e89b-12d3-a456-426614174000"; // Exemplo de chave Pix
                            System.out.println("\n     Chave Pix: " + chavePix);
                            System.out.println("\n    Finalizando compra com Pix...");
                            System.out.println("\n    Método de pagamento cadastrado: " + user.getMetodoPagamento());
                            System.out.println("\n    Valor total da compra: R$ " + user.getCarrinho().stream().flatMap(c -> c.getProdutos().stream()).mapToDouble(ProdutoModel::getPreco).sum());
                            
                            break;
                        default:
                            System.out.println("\n    Opção inválida!");
                            break;
                        case 4:
                            System.out.println("\n    Você escolheu pagar com VR/VA");
                            // VR/VA não precisa entrar no metodo de pagamento pq o VR/VA é instantaneo.
                            System.out.println("\n    Finalizando compra com VR/VA...");
                            System.out.println("\n    Método de pagamento cadastrado: " + user.getMetodoPagamento());
                            System.out.println("\n    Valor total da compra: R$ " + user.getCarrinho().stream().flatMap(c -> c.getProdutos().stream()).mapToDouble(ProdutoModel::getPreco).sum());
                            break;

                    }
                            }

    }


                            