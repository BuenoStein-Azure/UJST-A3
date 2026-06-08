package Service;
import static Service.UsuarioService.*;
import java.util.Random;

public class GeradorPixService {

    // gera uma chave Pix aleatória toda vez que o usuário escolhe pagar com Pix
    public void gerarChavePix() {
       
        // gera uma chave Pix de um jeito 
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String chavePix = "";
        Random gerador = new Random();
        for (int i = 0; i < 25; i++) {
            int index = gerador.nextInt(letras.length());
            chavePix += letras.charAt(index);
        }

        System.out.println("\n    Chave Pix gerada com sucesso!");
        System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);
        System.out.println("\n    Copie e cole no seu aplicativo do banco:");
        System.out.println("\n    Chave Pix: " + chavePix);
        System.out.println(VERDE_ESCURO + "------------------------------------------" + RESET);

        // inicio da função (vi um video daora disso e apliquei a logica)
        boolean pago = false;
            System.out.print("\n    Aguardando confirmação do pagamento Pix");
            try {
            for (int i = 0; i < 3; i++) {
                
                    Thread.sleep(600); 
                    System.out.print(".");
                    if (i == 2) {
                        pago = true;
                    }
                } 
                    
                } catch (Exception e) { //
                    e.printStackTrace();
                }   
                System.out.println(VERDE_ESCURO + "\n    Pagamento Pix finalizado com sucesso!" + RESET);
            }
             
        }
         
        

    

