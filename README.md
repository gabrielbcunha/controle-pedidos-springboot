# Controle de Pedidos API
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

Uma API RESTful robusta desenvolvida em Spring Boot para o gerenciamento de Clientes, Produtos e Pedidos. Este projeto foi construído aplicando boas práticas de Engenharia de Software, padrões arquiteturais de mercado e conceitos de Domain-Driven Design (DDD).

## Tecnologias Utilizadas

* **Java** (Versão 21)
* **Spring Boot** (Web, Data JPA, Validation)
* **Hibernate** (ORM)
* **Banco de Dados** (MySQL)
* **MapStruct** (Mapeamento de Objetos)
* **Lombok** (Produtividade e Clean Code)

## Destaques e Arquitetura

* **Modelo de Domínio Rico (DDD):** Entidades inteligentes que encapsulam suas próprias regras de negócio (cálculos de subtotal e total).
* **Padrão DTO (Data Transfer Object):** Isolamento completo entre a camada de persistência (Banco de Dados) e a camada de apresentação (Controllers), com validações rigorosas em tempo de requisição.
* **Aggregate Root:** Gerenciamento do ciclo de vida dos `ItensPedido` delegados de forma coesa à entidade raiz `Pedido`, com uso eficiente de operações em cascata no JPA.
* **Segurança de Atualizações (PATCH):** Lógica customizada para atualizações parciais, impedindo perda de dados por sobrescrita nula.
* **Precisão Financeira:** Uso padronizado de `BigDecimal` para garantia de integridade em valores monetários.

## Funcionalidades e Endpoints

A API possui rotas completas de CRUD (Create, Read, Update, Delete) para todos os recursos principais.

### Clientes (`/clientes`)
* `POST /clientes` - Cadastra um novo cliente.
* `GET /clientes` - Lista todos os clientes.
* `GET /clientes/{id}` - Busca um cliente específico.
* `PATCH /clientes/{id}` - Atualiza parcialmente os dados do cliente.
* `DELETE /clientes/{id}` - Remove um cliente.

Exemplo de POST
```json
{
    "nome": "Gabriel",
    "numeroContato": "11900000001"
}
```
### Produtos (`/produto`)
* `POST /produto` - Cadastra um novo produto.
* `GET /produto` - Lista o catálogo de produtos.
* `GET /produto/{id}` - Busca os detalhes de um produto.
* `PATCH /produto/{id}` - Altera preço ou nome de um produto.
* `DELETE /produto/{id}` - Remove um produto do catálogo.

Exemplo de POST
```json
{
    "nome": "Bolo",
    "preco": 25.35
}
```
### Pedidos (`/pedidos`)
* `POST /pedidos` - Cria um novo pedido com múltiplos itens de uma só vez, processando automaticamente os totais.
* `GET /pedidos` - Lista o histórico de pedidos.
* `GET /pedidos/{id}` - Busca um pedido detalhado com seus itens.
* `PATCH /pedidos/{id}` - Atualiza o carrinho (adiciona/remove itens recalcula o total dinamicamente).
* `DELETE /pedidos/{id}` - Cancela/Remove um pedido do sistema.

Exemplo de POST
```json
{
  "clienteId": 1,
  "itens": [
    {
      "produtoId": 1,
      "quantidade": 5
    },
    {
      "produtoId": 2,
      "quantidade": 3
    }
  ]
}
```

## Como rodar o projeto localmente

1. Clone este repositório: `git clone https://github.com/gabrielbcunha/controle-pedidos-springboot.git`
2. Importe o projeto na sua IDE de preferência (IntelliJ, Eclipse, VS Code).
3. Abra o projeto e configure o application.properties para conexão com banco de dados.
4. Atualize as dependências do Maven.
5. Execute `Clean` e `Build` no projeto para que o **MapStruct** gere as classes de mapeamento.
6. Rode a classe principal `ControlePedidosSpringbootApplication.java`.

A API estará disponível em `http://localhost:8080`.
