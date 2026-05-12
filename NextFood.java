
import Service.*;



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
        
       
        // Tela Entrada
        MenuInicialService menuInicialService = new MenuInicialService();
        menuInicialService.exibirMenuEntrada();

    }}
