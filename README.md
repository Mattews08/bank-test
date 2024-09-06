# Sistema de Empréstimos Bancários

Este é um sistema de empréstimos bancários que permite cadastrar pessoas e listar as modalidades de empréstimo disponíveis com base em condições específicas. O projeto é dividido em duas partes: o **backend** (API em Spring Boot) e o **frontend** (interface em Angular).

## 1. Backend (API)

### Pré-requisitos

- **Java 21**
- **Maven** (para gerenciar dependências)
- **H2 Database** (banco de dados em memória)

### Como Rodar o Backend

1. Clone o repositório:

   ```bash
   git clone https://github.com/Mattews08/bank-test.git
   cd bank-system
   ```

## Compile e execute o projeto:

Caso use o VsCode `mvn spring-boot:run`.

## Endpoints Disponíveis

## 1. Cadastro de Pessoa

- Rota: `/pessoa/cadastrar`

- Método: POST

- Descrição: Cadastra uma nova pessoa.

Exemplo de corpo da requisição (JSON):

```json
{
  "cpf": "12345678901",
  "nome": "João Silva",
  "idade": 35,
  "salario": 4000,
  "localizacao": "São Paulo"
}
```

- Erros possíveis:

* 400: CPF já cadastrado.
* 400: Dados inválidos ou faltantes.

## 2. Listar Empréstimos Disponíveis

    * Rota: /emprestimo/analisar

    * Método: POST

    * Descrição: Retorna as modalidades de empréstimo disponíveis para uma pessoa com base em seu CPF e valor do empréstimo.

    * Exemplo de corpo da requisição (JSON):

```json
{
  "cpf": "12345678901",
  "valor": 5000
}
```

- Resposta de sucesso (200):

```json
{
  "nome": "João Silva",
  "emprestimosDisponiveis": [
    "Empréstimo Pessoal (Taxa: 4%)",
    "Empréstimo com Garantia (Taxa: 3%)"
  ]
}
```

- Erros possíveis

* 404: Pessoa com o CPF não encontrada.

# Frontend - Sistema de Empréstimos Bancários

Este é o frontend do sistema de empréstimos bancários, desenvolvido com **Angular v16**. Ele permite que os usuários cadastrem pessoas e verifiquem os tipos de empréstimos disponíveis com base nas informações fornecidas.

## Funcionalidades

1. **Cadastro de Pessoa**: Permite o cadastro de uma nova pessoa, fornecendo os campos obrigatórios.
2. **Listagem de Empréstimos Disponíveis**: Com base no CPF e no valor do empréstimo, lista as modalidades de empréstimos disponíveis para a pessoa.

## Tecnologias Utilizadas

- Angular v16
- Bootstrap (para estilização)
- ngx-bootstrap (para componentes de interface)

## Requisitos

- **Node.js**: versão 14 ou superior.
- **Angular CLI**: Instale globalmente usando `npm install -g @angular/cli`.

## Instalação

Siga os passos abaixo para rodar o frontend localmente:

1. Entre na pasta:

   ```bash
   cd front-bank
   ```

2. Instale as dependências:

   ```bash
   npm install
   ```

3. Inicie o servidor de desenvolvimento:

   ```bash
   ng serve

   ```

```

```
