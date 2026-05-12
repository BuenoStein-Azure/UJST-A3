package Service;
import java.util.Scanner;
import Models.*;
import java.util.List;
import java.util.ArrayList;
public class MetodosDePagamento {
    
    public void cadastroMetodoPagamentoDebito(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n   == Cadastro de Cartão de Débito ==");
        System.out.println("──────────────────────────────────────────");
        // Lógica para cadastrar o método de pagamento de cartão de débito
        System.out.println("\n    Digite o número do cartão de débito: ");
        String numeroCartao = sc.nextLine();
        System.out.println("──────────────────────────────────────────");
            System.out.println("\n    Digite a data de validade do cartão (MM/AA): ");
        String dataValidade = sc.nextLine();
        System.out.println("──────────────────────────────────────────");
        System.out.println("\n    Digite o código de segurança do cartão: ");
        String codigoSeguranca = sc.nextLine();
        System.out.println("──────────────────────────────────────────");
        sc.close();
        // Aqui você pode adicionar a lógica para salvar o cartão de débito, como associá-lo ao usuário logado
        UserModel user = UserService.currentUser; // Obtém o usuário atualmente logado

        List<Object> cartãoFeitoList = new ArrayList<>();
        cartãoFeitoList.add("Cartão de Débito - Número: " + numeroCartao + ", Validade: " + dataValidade + ", Código de Segurança: " + codigoSeguranca);
       
        if (user != null) {
            if(user.getMetodoPagamento() == null){
                user.setMetodoPagamento(cartãoFeitoList);;
            } else {
                user.getMetodoPagamento().add(cartãoFeitoList);
            }
            System.out.println("\n    Cartão de débito cadastrado com sucesso!");
        } else {
            System.out.println("\n    Nenhum usuário logado. Por favor, faça login para cadastrar um método de pagamento.");
        }
        
        System.out.println("\n    Cartão de débito cadastrado com sucesso!");
    }
    public void cadastroMetodoPagamentoCredito(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n   == Cadastro de Cartão de Crédito ==");
        System.out.println("──────────────────────────────────────────");
        // Lógica para cadastrar o método de pagamento de cartão de crédito
        System.out.println("\n    Digite o número do cartão de crédito: ");
        String numeroCartao = sc.nextLine();
        System.out.println("──────────────────────────────────────────");
            System.out.println("\n    Digite a data de validade do cartão (MM/AA): ");
        String dataValidade = sc.nextLine();
        System.out.println("──────────────────────────────────────────");
        System.out.println("\n    Digite o código de segurança do cartão: ");
        String codigoSeguranca = sc.nextLine();
        System.out.println("──────────────────────────────────────────");
        sc.close();
        // Aqui você pode adicionar a lógica para salvar o cartão de crédito, como associá-lo ao usuário logado
        UserModel user = UserService.currentUser; // Obtém o usuário atualmente logado

        List<Object> cartãoFeitoList = new ArrayList<>();
        cartãoFeitoList.add("Cartão de Crédito - Número: " + numeroCartao + ", Validade: " + dataValidade + ", Código de Segurança: " + codigoSeguranca);
       
        if (user != null) {
            if(user.getMetodoPagamento() == null){
                user.setMetodoPagamento(cartãoFeitoList);;
            } else {
                user.getMetodoPagamento().add(cartãoFeitoList);
            }
            System.out.println("\n    Cartão de crédito cadastrado com sucesso!");
        } else {
            System.out.println("\n    Nenhum usuário logado. Por favor, faça login para cadastrar um método de pagamento.");
        }
        
        System.out.println("\n    Cartão de crédito cadastrado com sucesso!");
    }
}
