package Service;
import Service.*;
import Models.*;


import java.util.Scanner;


public class MenuRestauranteService {
      
    private ProdutoService produtoS;
    public MenuRestauranteService(ProdutoService produtoS) {
        this.produtoS = produtoS;
    }
        public void Menu(){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n             === RESTAURANTES DISPONIVEIS ===     ");
            System.out.print("\n  1. Mcdonald's");
            System.out.print("\n  2. Pizza Hut");
            System.out.print("\n  3. Mania de Churrasco");
            System.out.print("\n  4. Burguer King ");
            System.out.print("\n  Digite a opção do restaurante: ");
        switch(sc.nextInt()){
            case 1:
                System.out.println("\n    Você escolheu Mcdonald's!");
                System.out.println("\n    Carregando menu do Macdonald's...");
                produtoS.exibirCatalogoMcDonald();
                // falta a logica de escolha do apartir do catalogo
                break;
                default:
                    break;
        }
        
    }
}
