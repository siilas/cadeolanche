# language: pt
Funcionalidade: Pedidos feitos pelo app Cade o Lanche? 

  Contexto: O usuário pode fazer a pedidos e colocar adicionais
	e também existem promoções que dependem da combinação de ingredientes


  Cenário: Pedido sem promoção
    Dado que o usuário peça o lanche "X_BURGER"
    Então o recibo deve vir sem promoções

  Cenário: Pedido com promoção light
    Dado que o usuário peça o lanche "X_BURGER"
    E adicione o ingrediente "ALFACE"
    Então o recibo deve vir com a promoção "Light"

  Cenário: Pedido com promoção muita carne
    Dado que o usuário peça o lanche "X_BURGER"
    E adicione o ingrediente "HAMBURGUER"
    E adicione o ingrediente "HAMBURGUER"
    Então o recibo deve vir com a promoção "Muita carne"

  Cenário: Pedido com promoção muito queijo
    Dado que o usuário peça o lanche "X_BURGER"
    E adicione o ingrediente "QUEIJO"
    E adicione o ingrediente "QUEIJO"
    Então o recibo deve vir com a promoção "Muito queijo"
