📊 Fluxogramas NextFood — Apresentação A3
Cada seção abaixo pertence a uma pessoa. Cole o bloco no Mermaid Live Editor para visualizar e imprimir o fluxograma.

👤 Pessoa 1 — Visão Geral do Sistema
Arquivo: NextFood.java
Responsabilidade: Apresentar o sistema como um todo, mostrando como os módulos se conectam do início ao fim.

flowchart TD
    A([🚀 Início — NextFood.main]) --> B[Exibir Banner ASCII]
    B --> C[MenuInicialService]
    C --> D{Opção do usuário}
    D -->|1 - Login| E[AutenticacaoService]
    D -->|2 - Cadastro| F[UsuarioService]
    D -->|3 - Sair| Z([🔴 Encerrar])
    E -->|Login OK| G[MenuOpcaoService]
    E -->|Login falhou| C
    F -->|Cadastro OK| C
    F -->|Falhou| C
    G --> H{O que fazer?}
    H -->|1 - Fazer pedido| I[MenuRestauranteService]
    H -->|2 - Ver pedidos feitos| J[CarrinhoService.exibirPedidosFeitos]
    H -->|3 - Ver carrinho| K[CarrinhoService.exibirCarrinho]
    H -->|4 - Voltar| C
    I --> L[Fluxo de Pedido]
    L --> M[CarrinhoService.finalizarCompra]
    M --> Z2([✅ Pedido Finalizado])
👤 Pessoa 2 — Cadastro de Usuário
Arquivo: UsuarioService.java + UserModel.java
Responsabilidade: Explicar como um novo usuário é criado e armazenado na memória do sistema.

flowchart TD
    A([Início - opção 2 no MenuInicial]) --> B[UsuarioService.registerUser]
    B --> C[Solicita username]
    C --> D[Solicita telefone]
    D --> E[Solicita e-mail]
    E --> F[Solicita senha]
    F --> G{userCount < 100?}
    G -->|Sim| H[Cria UserModel]
    H --> I[Salva em users array]
    I --> J[Define currentUser]
    J --> K[Retorna true]
    K --> L[Redireciona para MenuInicial]
    G -->|Não| M[Exibe erro: limite atingido]
    M --> N[Retorna false]
    N --> L

    subgraph UserModel
        UM1[username]
        UM2[password]
        UM3[email]
        UM4[phoneNumber]
        UM5[carrinho: List]
        UM6[metodoPagamento: List]
        UM7[historicoPedidos: List]
    end
👤 Pessoa 3 — Login
Arquivo: AutenticacaoService.java
Responsabilidade: Explicar como o sistema autentica um usuário já cadastrado.

flowchart TD
    A([Início - opção 1 no MenuInicial]) --> B[AutenticacaoService.login]
    B --> C[Solicita username]
    C --> D[Solicita senha]
    D --> E[Loop nos usuários cadastrados]
    E --> F{username e password batem?}
    F -->|Sim| G[Define UsuarioService.currentUser]
    G --> H[Retorna true]
    H --> I[MenuInicialService redireciona]
    I --> J[MenuOpcaoService]
    F -->|Não — próximo| E
    E -->|Nenhum encontrado| K[Retorna false]
    K --> L[Exibe: Acesso negado]
    L --> M[Volta ao MenuInicial]
👤 Pessoa 4 — Restaurantes e Catálogo
Arquivo: RestauranteService.java + RestaurantModel.java + ProdutoModel.java
Responsabilidade: Mostrar como os restaurantes e seus produtos são estruturados e exibidos.

flowchart TD
    A([Bloco static do RestauranteService]) --> B[Cria rest1: McDonald's]
    A --> C[Cria rest2: Pizza Hut]
    A --> D[Cria rest3: Mania de Churrasco]
    A --> E[Cria rest4: Burger King]

    B --> B1[setcatalogo: BigMac, McQuarteirão...]
    C --> C1[setcatalogo: Margherita, Pepperoni...]
    D --> D1[setcatalogo: Frango, Carne, Linguiça...]
    E --> E1[setcatalogo: Whopper, Big King...]

    B1 & C1 & D1 & E1 --> F[Catálogos prontos em memória]
    F --> G[MenuRestauranteService chama exibirCatalogo]
    G --> H[Loop nos ProdutoModel do restaurante]
    H --> I[Imprime: nome - preço - quantidade]

    subgraph ProdutoModel
        P1[nome: String]
        P2[preco: double]
        P3[quantidade: int]
    end
👤 Pessoa 5 — Seleção de Produtos e Adição ao Carrinho
Arquivo: MenuRestauranteService.java
Responsabilidade: Explicar o loop de navegação entre restaurantes e a seleção de produtos com quantidade.

flowchart TD
    A([MenuRestauranteService.Menu]) --> B[Loop: exibe lista de restaurantes]
    B --> C{Opção do usuário}
    C -->|0 - Finalizar| FIM[CarrinhoService.finalizarCompra]
    C -->|1 a 4| D[Seleciona RestaurantModel]
    D --> E[Loop interno: exibirCatalogo]
    E --> F{Opção de produto}
    F -->|0 - Voltar| B
    F -->|1..N| G[Solicita quantidade]
    G --> H[CarrinhoService.adicionarAoCarrinho\nproduto + restaurante + quantidade]
    H --> I{O que fazer agora?}
    I -->|1 - Mais desse restaurante| E
    I -->|2 - Outro restaurante| B
    I -->|3 - Finalizar compra| FIM
    FIM --> Z([✅ Fim do fluxo de pedido])
👤 Pessoa 6 — Carrinho e Histórico de Pedidos
Arquivo: CarrinhoService.java + UserModel.java
Responsabilidade: Explicar como o carrinho armazena os itens e como o histórico é salvo após o pagamento.

flowchart TD
    A([adicionarAoCarrinho]) --> B{Usuário logado?}
    B -->|Não| ERR[Exibe erro e retorna]
    B -->|Sim| C{Carrinho é null?}
    C -->|Sim| D[Inicializa ArrayList]
    C -->|Não| E
    D --> E[Loop: adiciona N vezes ProdutosERestaurant]
    E --> F[Imprime confirmação com quantidade e preço]

    G([exibirCarrinho]) --> H{Carrinho vazio?}
    H -->|Sim| I[Exibe: carrinho vazio]
    H -->|Não| J[imprimirItensDaLista]
    J --> K[Loop nos itens: nome + restaurante + preço]
    K --> L[Imprime total]

    M([exibirPedidosFeitos]) --> N{historicoPedidos vazio?}
    N -->|Sim| O[Exibe: nenhum pedido feito]
    N -->|Não| P[Loop em cada pedido numerado]
    P --> Q[imprimirItensDaLista de cada pedido]
👤 Pessoa 7 — Pagamento
Arquivo: CarrinhoService.java + PagamentoService.java + GeradorPixService.java
Responsabilidade: Detalhar o fluxo de escolha do método de pagamento e confirmação do pedido.

flowchart TD
    A([finalizarCompra]) --> B[exibirCarrinho]
    B --> C{Carrinho vazio?}
    C -->|Sim| ERR[Exibe erro e retorna]
    C -->|Não| D[Exibe opções de pagamento]
    D --> E{Método escolhido}

    E -->|1 - Débito| F[processarCartao débito]
    E -->|2 - Crédito| G[processarCartao crédito]
    E -->|3 - Pix| H[GeradorPixService.gerarChavePix]
    E -->|4 - VR/VA| I[Aprovação automática]

    F --> F1{Tem cartão cadastrado?}
    F1 -->|Não| F2[PagamentoService.cadastroDebito]
    F1 -->|Sim| CONF
    F2 --> CONF
    G --> G1{Tem cartão cadastrado?}
    G1 -->|Não| G2[PagamentoService.cadastroCredito]
    G1 -->|Sim| CONF
    G2 --> CONF
    H --> CONF([confirmarEFecharPedido])
    I --> CONF

    CONF --> J[Calcula total via stream]
    J --> K[adicionarPedidoAoHistorico]
    K --> L[Imprime total e mensagem de sucesso]
    L --> M[Limpa o carrinho]
    M --> Z([✅ Pedido Finalizado])
👤 Pessoa 8 — Estrutura de Dados (Models)
Arquivos: UserModel.java + ProdutoModel.java + RestaurantModel.java + ProdutosERestaurant.java
Responsabilidade: Explicar a estrutura de dados do projeto — o que cada model guarda e como eles se relacionam.

flowchart TD
    subgraph UserModel
        U1[username: String]
        U2[password: String]
        U3[email: String]
        U4[phoneNumber: double]
        U5[carrinho: List de ProdutosERestaurant]
        U6[metodoPagamento: List de Object]
        U7[historicoPedidos: List de List de ProdutosERestaurant]
    end

    subgraph ProdutosERestaurant
        PR1[produtos: List de ProdutoModel]
        PR2[restaurantes: List de RestaurantModel]
    end

    subgraph ProdutoModel
        P1[nome: String]
        P2[preco: double]
        P3[quantidade: int]
    end

    subgraph RestaurantModel
        R1[restaurantName: String]
        R2[locate: String]
        R3[phoneRestaurantNumber: int]
        R4[catalogo: List de ProdutoModel]
    end

    U5 --> PR1
    U5 --> PR2
    U7 --> PR1
    PR1 --> P1
    PR2 --> R1
    R4 --> P1
💡 Como renderizar: Acesse mermaid.live, cole o bloco de código do seu fluxograma e exporte como PNG ou SVG para a apresentação.