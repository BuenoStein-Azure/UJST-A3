## 🟢 NextFood

Este repositório contém o desenvolvimento do projeto **NextFood**, elaborado como parte da **Avaliação A3** da disciplina de programação. O objetivo é aplicar os conceitos de Programação Orientada a Objetos (POO), Conventional Commits e gerenciamento de dados em memória em um sistema de Delivery via terminal.

## 🛠️ Ferramentas

**Linguagem**

<p align="left">
  <img src="https://skillicons.dev/icons?i=java" height="40" />
</p>

**Ferramentas de desenvolvimento**

<p align="left">
  <img src="https://skillicons.dev/icons?i=git,github" height="40" />
  &nbsp;
  <img src="https://skillicons.dev/icons?i=vscode" height="40" />
</p>

## 👤 Equipe

| NOME   | RA |
|------------|------|
| Gabriel Teixeira Ricca  | 8261113738 |
| Igor de Souza Bueno  | 8261107854 |
| Ryan Gomes dos Santos  | 8261102012 |
| Daniel Magalhães Pereira Dos Santos  | 8261104325 |
| Gabriel Ramos do Nascimento | 826176212 |
| Arthur Leite da Silva | 826113097 |
| Henrique Alberto Midega

## Diagrama de Classes

```mermaid
classDiagram
    direction TB

    class NextFood {
        +main(String[] args)$
        +exibirBanner()$
    }

    class UserModel {
        -String username
        -String password
        -String email
        -double phoneNumber
        -List~ProdutosERestaurant~ carrinho
        -List~Object~ metodoPagamento
        -List~List~ProdutosERestaurant~~ historicoPedidos
        +getUsername() String
        +setUsername(String username)
        +getPassword() String
        +setPassword(String password)
        +getEmail() String
        +setEmail(String email)
        +getPhoneNumber() double
        +setPhoneNumber(double phoneNumber)
        +getCarrinho() List
        +setCarrinho(List carrinho)
        +getMetodoPagamento() List
        +setMetodoPagamento(List metodoPagamento)
        +getHistoricoPedidos() List
        +adicionarPedidoAoHistorico(List pedido)
    }

    class ProdutoModel {
        -String nome
        -double preco
        -int quantidade
        +getNome() String
        +setNome(String nome)
        +getPreco() double
        +setPreco(double preco)
        +getQuantidade() int
        +setQuantidade(int quantidade)
    }

    class RestaurantModel {
        -String restaurantName
        -String locate
        -int phoneRestaurantNumber
        -List~ProdutoModel~ catalogo
        +getRestaurantName() String
        +getLocate() String
        +getphoneRestaurantNumber() int
        +getcatalogo() List
        +setRestaurantName(String restaurantName)
        +setlocate(String locate)
        +setphoneRestaurantNumber(int phoneRestaurantNumber)
        +setcatalogo(List catalogo)
    }

    class ProdutosERestaurant {
        -List~ProdutoModel~ produtos
        -List~RestaurantModel~ restaurantes
        +getProdutos() List
        +setProdutos(List produtos)
        +getRestaurantes() List
        +setRestaurantes(List restaurantes)
    }

    class UsuarioService {
        +int MAX_USERS$
        +UserModel[] users$
        +int userCount$
        +UserModel currentUser$
        +registerUser() boolean
        +listarUsuarios()
    }

    class AutenticacaoService {
        +login() boolean
    }

    class MenuInicialService {
        +exibirMenuEntrada() boolean
    }

    class MenuOpcaoService {
        -RestauranteService restaurantService
        +exibirMenu()
    }

    class MenuRestauranteService {
        -RestauranteService restaurantService
        +Menu()
    }

    class RestauranteService {
        -RestaurantModel rest1$
        -RestaurantModel rest2$
        -RestaurantModel rest3$
        -RestaurantModel rest4$
        +getRest1() RestaurantModel$
        +getRest2() RestaurantModel$
        +getRest3() RestaurantModel$
        +getRest4() RestaurantModel$
        +getRestCatalogoList() List$
        +exibirCatalogo(RestaurantModel restaurant)$
    }

        class CarrinhoService {
        -UserModel user
        -Scanner sc
        +adicionarAoCarrinho(ProdutoModel produto, RestaurantModel restaurant, int quantidade)
        +exibirCarrinho()
        +exibirPedidosFeitos()
        +finalizarCompra()
        -processarCartao(String tipo)
        -imprimirItensDaLista(List lista)
        -confirmarEFecharPedido()
    }

    class GeradorPixService {
        +gerarChavePix()
    }

    class MetodosDePagamento {
        +cadastroMetodoPagamentoDebito()
        +cadastroMetodoPagamentoCredito()
    }

    %% Composição / Agregação de dados
    UserModel "1" o-- "0..*" ProdutosERestaurant : carrinho / historicoPedidos
    ProdutosERestaurant "1" *-- "1..*" ProdutoModel : produtos
    ProdutosERestaurant "1" *-- "1..*" RestaurantModel : restaurantes
    RestaurantModel "1" *-- "0..*" ProdutoModel : catalogo
    UsuarioService "1" *-- "0..100" UserModel : users[]

    %% Dependências entre serviços
    NextFood ..> MenuInicialService : instancia
    MenuInicialService ..> AutenticacaoService : instancia
    MenuInicialService ..> UsuarioService : instancia
    MenuInicialService ..> MenuOpcaoService : instancia
    MenuOpcaoService ..> MenuRestauranteService : instancia
    MenuOpcaoService ..> CarrinhoService : instancia
    MenuOpcaoService --> RestauranteService : usa
    MenuRestauranteService --> RestauranteService : usa
    MenuRestauranteService ..> CarrinhoService : instancia
    CarrinhoService ..> GeradorPixService : instancia
    CarrinhoService ..> MetodosDePagamento : instancia
    CarrinhoService ..> UsuarioService : lê currentUser
    AutenticacaoService ..> UsuarioService : lê users[]}
```
