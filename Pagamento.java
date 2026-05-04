
public class Pagamento {

    public double processarPagamento(double total, int metodoPagamento) {

        System.out.println("\nForma de pagamento:");

        double taxa = 0;

        switch (metodoPagamento) {
            case 1:
                System.out.println("Pagamento no DÉBITO selecionado.");
                break;

            case 2:
                System.out.println("Pagamento no CRÉDITO selecionado.");
                taxa = 0.10;
                break;

            case 3:
                System.out.println("Pagamento via PIX selecionado.");
                break;

            default:
                System.out.println("Opção inválida de pagamento.");
                break;
        }

        return total + (total * taxa);
    }
}
