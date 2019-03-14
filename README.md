# Cadê o Lanche?

Olá! No Cadê o Lanche? você pode fazer o seu pedido de forma simples e rápida. 

# Tecnologias e frameworks

O projeto foi feito utilizando as seguintes tecnologias e frameworks:

- [Java 11](http://www.java.com)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Docker](http://docker.com)
- [Hystrix](https://github.com/Netflix/Hystrix)
- [Cucumber](https://cucumber.io)
- [Feign](https://github.com/OpenFeign/feign)
- [Swagger](https://swagger.io)
- [Reactor](https://projectreactor.io)
- [Thymeleaf](https://www.thymeleaf.org)
- [Bootstrap](https://getbootstrap.com)

E alguns dos padrões de projeto e arquiteturais utilizados:

- [Circuit Breaker](https://pt.wikipedia.org/wiki/Circuit_breaker)
- [REST](https://pt.wikipedia.org/wiki/REST)
- [MVC](https://pt.wikipedia.org/wiki/MVC)

# O Projeto

O Projeto segue a seguintes regras: 

> "Somos uma startup do ramo de alimentos e precisamos de uma aplicação web para gerir nosso negócio. Nossa especialidade é a venda  de lanches, de modo que alguns lanches são opções de cardápio e outros podem conter ingredientes personalizados"

O valor de cada opção do cardápio é dado pela soma dos ingredientes que compõe o lanche. Além destas opções, o cliente pode personalizar seu lanche e escolher os ingredientes que desejar. Nesse caso, o preço do lanche também será calculado pela soma dos ingredientes.

Existe uma exceção à regra para o cálculo de preço, quando o lanche pertencer à uma promoção. A seguir, apresentamos a lista de promoções e suas respectivas regras de negócio:

| PROMOÇÃO | REGRA DE NEGÓCIO |
| -------- | ---------------- |
| Light | Se o lanche tem alface e não tem bacon, ganha 10% de desconto. |
| Muita carne | A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante... |
| Muito queijo | A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante... |
| Inflação | Os valores dos ingredientes são alterados com frequência e não gastaríamos que isso influenciasse nos testes automatizados. |

# Cardápio

## Lanches

| LANCHE | INGREDIENTES |
| ------ | ------------ |
| X-Bacon | Bacon, hambúrguer de carne e queijo |
| X-Burger | Hambúrguer de carne e queijo |
| X-Egg | Ovo, hambúrguer de carne e queijo |
| X-Egg Bacon | Ovo, bacon, hambúrguer de carne e queijo |

## Adicionais

| INGREDIENTE | VALOR |
| ----------- | ----- |
| Alface | R$ 0.40 |
| Bacon | R$ 2,00 |
| Hambúrguer de carne | R$ 3,00 |
| Ovo | R$ 0,80 |
| Queijo | R$ 1,50 |

# Instalação

Depois de baixar o projeto, rode o script (somente para Linux por enquanto) para verificar o Java, Docker e Docker Compose:


```sh
sh verification.sh
```

Deposi disso, basta executar o seguinte comando na pasta raiz do projeto para que o Maven baixe as dependências e faça o build:

```sh
./mvnw clean install
```

E para executar e rodar o projeto execute o seguinte comando:

```sh
docker-compose up
```

Depois basta abrir o browser e acessar o seguinte endereço:

```sh
http://localhost:8081 (Frontend)
http://localhost:8082 (Backend)
```

# Arquitetura e design do projeto

A proposta do projeto é ser simples e de fácil uso, para que o usuário possa fazer o pedido de forma amigável. Para isso foram utilizados o Thymeleaf (engine de templates) e o Bootstrap (componentes de interface e front-end), ambos pela facilidade de uso.

Para o back-end foi escolhido o Spring Boot, pela maturidade do framework e todas as ferramentas, facilidades e integração com outros frameworks e tecnologias que o mesmo oferece. A API foi desenvolvida de forma reativa e também utilizando o Hystrix (circuit breaker) para que seja tolerante a falha. E o BDD (Cucumber) foi utilizado na parte de testes para validação das regras de negócio.

A programação reativa na API foi escolhida pensando no crescimento da mesma, pois caso a consumo seja grande, a programação reativa vai nos ajudar nisso com threads não blocantes e fluxos assíncronos.

# URLs do projeto

Segue lista com todas as URLs do projeto:

## Frontend

| URL | Descrição |
| --- | --------- |
| / | Página inicial do projeto |
| /pedido/novo | Novos pedidos |
| /pedido/salvar | Salva o pedido e exibe o recibo |

## Backend

| URL | Descrição |
| --- | --------- |
| /cardapios | Retorna o cardápio |
| /pedidos | Salva o pedido e retorna o recibo |
| /swagger-ui.html | Documentação dos serviços |

# Melhorias

- Melhorar os casos de teste e aumentar a cobertura dos mesmos
- Melhorar o fallback, talvez utilizando um cache/banco de dados
- Utilizar banco de dados para guardar os pedidos
- Utilizar fila para os pedidos
- Melhorar o script de verificação e criar uma versão para Windows

**Até mais e vida longa e próspera! :)**
