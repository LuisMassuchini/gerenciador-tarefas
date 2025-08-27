# API de Gerenciamento de Tarefas

![Status da Build](https://github.com/LuisMassuchini/gerenciador-tarefas/actions/workflows/maven-ci.yml/badge.svg)

## Sobre o Projeto

Este projeto é uma API RESTful para gerenciamento de tarefas, desenvolvida como parte de uma jornada de aprendizado intensiva para aprimorar e consolidar habilidades como desenvolvedor back-end Java. A aplicação permite realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) para tarefas, seguindo as melhores práticas de desenvolvimento de software.

O principal objetivo foi construir um projeto do zero, passando por todas as etapas do ciclo de vida de desenvolvimento de software, desde a concepção e versionamento de código até a configuração de um pipeline de integração contínua.

## Jornada de Aprendizado e Habilidades Adquiridas

Este repositório representa mais do que um projeto; é um registro prático da aquisição e aplicação das seguintes competências:

* **Fundamentos de Back-end com Java e Spring Boot:**
    * Desenvolvimento de uma aplicação robusta seguindo a arquitetura em camadas (`Controller`, `Service`, `Repository`).
    * Gerenciamento de dependências com Maven.
    * Injeção de dependências para desacoplamento de código.

* **Criação de APIs RESTful:**
    * Design e implementação de uma API REST completa com as operações CRUD (`POST`, `GET`, `PUT`, `DELETE`).
    * Uso correto dos verbos HTTP, status codes e do padrão de transferência de dados JSON.

* **Persistência de Dados com Bancos Relacionais (MySQL):**
    * Modelagem de dados e mapeamento objeto-relacional (ORM) com Spring Data JPA (`@Entity`).
    * Configuração e conexão de uma aplicação Spring Boot com um banco de dados MySQL externo.

* **Versionamento de Código Profissional (Git & GitHub):**
    * Utilização de um fluxo de trabalho com `branches` para desenvolvimento de novas funcionalidades.
    * Criação de `commits` atômicos e semânticos para manter um histórico limpo e organizado.

* **Qualidade de Código e Testes Automatizados (JUnit & Mockito):**
    * Escrita de testes de unidade para a camada de serviço, garantindo o funcionamento correto da lógica de negócio.
    * Uso de `Mockito` para criar "mocks" e testar componentes de forma isolada.

* **Automação e Integração Contínua (CI com GitHub Actions):**
    * Configuração de um pipeline de CI do zero que compila o código e executa os testes automatizados a cada `push`, garantindo que novas alterações não quebrem o código existente.

* **Ambientes de Teste Isolados:**
    * Configuração de um banco de dados em memória (H2) com escopo de teste (`<scope>test</scope>`) e um `application.properties` específico para o ambiente de teste, garantindo que os testes não dependam de infraestrutura externa.

* **Containerização e Preparo para Nuvem (Docker):**
    * Compreensão teórica e escrita de um `Dockerfile` para "empacotar" a aplicação Java, preparando-a para ser executada em qualquer ambiente de nuvem de forma padronizada.

## Tecnologias Utilizadas

* ☕ **Java 21**
* 🌱 **Spring Boot**
* 💾 **Spring Data JPA**
* 🗃️ **MySQL**
* 🧪 **JUnit 5 & Mockito**
* 🗄️ **H2 Database** (para testes)
* 🐘 **Maven**
* 🐙 **Git & GitHub**
* 🤖 **GitHub Actions (CI)**
* 🐳 **Docker**

## Como Executar o Projeto

**Pré-requisitos:**
* Java 21 (JDK)
* Maven 3.8+
* Git
* Um servidor MySQL em execução.

**Passos:**
1.  Clone o repositório:
    ```bash
    git clone [https://github.com/](https://github.com/)LuisMassuchini/gerenciador-tarefas.git
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd <NOME_DO_REPOSITORIO>
    ```
3.  Configure o banco de dados:
    * Crie um banco de dados (schema) chamado `tarefas_db` no seu servidor MySQL.
    * No arquivo `src/main/resources/application.properties`, altere as propriedades `spring.datasource.username` e `spring.datasource.password` com suas credenciais do MySQL.
4.  Execute a aplicação:
    ```bash
    mvn spring-boot:run
    ```
A API estará disponível em `http://localhost:8080`.

## Endpoints da API

| Verbo  | Endpoint               | Descrição                          | Exemplo de Body (JSON)                                            |
| :----- | :--------------------- | :--------------------------------- | :---------------------------------------------------------------- |
| `POST` | `/tarefas`             | Cria uma nova tarefa.              | `{"titulo": "Nova Tarefa", "descricao": "Descrição da tarefa"}`     |
| `GET`  | `/tarefas`             | Lista todas as tarefas.            | N/A                                                               |
| `GET`  | `/tarefas/{id}`        | Busca uma tarefa pelo seu ID.      | N/A                                                               |
| `PUT`  | `/tarefas/{id}`        | Atualiza uma tarefa existente.     | `{"titulo": "Tarefa Atualizada", "status": "EM_ANDAMENTO"}`         |
| `DELETE`| `/tarefas/{id}`        | Deleta uma tarefa pelo seu ID.     | N/A                                                               |