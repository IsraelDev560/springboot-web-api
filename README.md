# API REST de Usuários

Esta é uma API RESTful simples para gerenciar usuários. Ela permite criar, visualizar, atualizar e excluir usuários.

## Configuração do Projeto

Este projeto utiliza Spring Boot e Springfox Swagger para documentação da API.

### Dependências Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.2.0</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

```

## Documentação da API
A documentação da API pode ser acessada em /swagger-ui.html. A partir dela, você pode visualizar e interagir com os endpoints da API.

## Endpoints
- GET /users: Retorna a lista de todos os usuários.
- GET /users/login/{login}: Retorna um usuário com base no login.
- GET /users/username/{username}: Retorna um usuário com base no username.
- GET /users/id/{id}: Retorna um usuário com base no ID.
- DELETE /users/{id}: Exclui um usuário com base no ID.
- POST /users/batch: Permite inserir uma lista de usuários de uma só vez.
- PUT /users/{id}: Atualiza um usuário com base no ID.

## Estrutura do Projeto
- dio.web_api.model: Contém as classes de modelo.
- dio.web_api.repository: Contém a camada de repositório para acesso aos dados.
- dio.web_api.controller: Contém os controladores REST que definem os endpoints da API.
- dio.web_api.config: Contém as configurações da aplicação.
- dio.web_api.handler: Contém as configurações de exceções.
## Executando o Projeto
Para executar o projeto localmente, você precisa ter o Java e o Maven instalados. Em seguida, execute o seguinte comando:
```bash
mvn spring-boot:run
```
O aplicativo estará disponível em http://localhost:8080.