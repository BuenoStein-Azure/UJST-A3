package nextfood;

public class Menu {

    public static Produto[] getMenuMc() {
        return new Produto[]{
                new Produto("BigMac", 25.0),
                new Produto("McQuarteirão", 28.0),
                new Produto("McChicken", 22.0),
                new Produto("McCheddar", 30.0),
        };
    }

    public static Produto[] getMenuPizza() {
        return new Produto[]{
        new Produto("Pizza de Queijo", 24.0),
                new Produto("Pizza de Portugueza", 25.9),
                new Produto("Pizza de Calabresa", 25.8),
                new Produto("Pizza de Churrasco", 26.8),
    };
}
    public static Produto[] getMenuChurrasco() {
       return new Produto[]{
        new Produto("Picanha", 45.9),
                new Produto("Frango", 25.0),
                new Produto("Queijo Coalho", 22.8),
                new Produto("Linguiça", 22.8),
    };
}
    public static Produto [] getMenuBk(){
        return new Produto[]{
                new Produto("MegaShacker", 25.8),
                new Produto("Whopper", 30.9),
                new Produto("Whopper Vegetariano",35.8),
                new Produto("Rodeio Duplo ", 22.8)

        };
    }
}
