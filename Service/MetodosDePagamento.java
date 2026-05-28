package Service;
import Models.*;
import Util.AppScanner;

import static Service.UsuarioService.*;
import java.util.ArrayList;
import java.util.List;
public class MetodosDePagamento {
    
    public void cadastroMetodoPagamentoDebito(){
        
        System.out.println(BRANCO + "\n   == Cadastro de Cartão de Débito ==" + RESET);
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        // Lógica para cadastrar o método de pagamento de cartão de débito
        System.out.println("\n    Digite o número do cartão de débito: ");
        String numeroCartao = AppScanner.get().nextLine();
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        System.out.println(VERDE_ESCURO + "\n    Digite a data de validade do cartão (MM/AA): " + RESET);
        String dataValidade = AppScanner.get().nextLine();
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        System.out.println("\n    Digite o código de segurança do cartão: ");
        String codigoSeguranca = AppScanner.get().nextLine();
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        
        // Aqui você pode adicionar a lógica para salvar o cartão de débito, como associá-lo ao usuário logado
        UserModel user = UsuarioService.currentUser; // Obtém o usuário atualmente logado

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
        System.out.println(BRANCO + "\n   == Cadastro de Cartão de Crédito ==" + RESET);
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        // Lógica para cadastrar o método de pagamento de cartão de crédito
        System.out.println("\n    Digite o número do cartão de crédito: ");
        String numeroCartao = AppScanner.get().nextLine();
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
            System.out.println("\n    Digite a data de validade do cartão (MM/AA): ");
        String dataValidade = AppScanner.get().nextLine();
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
        System.out.println("\n    Digite o código de segurança do cartão: ");
        String codigoSeguranca = AppScanner.get().nextLine();
        System.out.println(VERDE_ESCURO + "──────────────────────────────────────────" + RESET);
       
        // Aqui você pode adicionar a lógica para salvar o cartão de crédito, como associá-lo ao usuário logado
        UserModel user = UsuarioService.currentUser; // Obtém o usuário atualmente logado

        List<Object> cartãoFeitoList = new ArrayList<>();
        cartãoFeitoList.add("Cartão de Crédito - Número: " + numeroCartao + ", Validade: " + dataValidade + ", Código de Segurança: " + codigoSeguranca);
       
        if (user != null) {
            if(user.getMetodoPagamento() == null){
                user.setMetodoPagamento(cartãoFeitoList);
            } else {
                user.getMetodoPagamento().add(cartãoFeitoList);
            }
            System.out.println("\n    Cartão de crédito cadastrado com sucesso!");
            
        } else {
            System.out.println("\n    Nenhum usuário logado. Por favor, faça login para cadastrar um método de pagamento.");
        }
        
       
    }
}
