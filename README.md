[![Build Status](https://travis-ci.org/murilodbueno/lanchonete-api.svg?branch=master)](https://travis-ci.org/murilodbueno/lanchonete-api)

# Lanchonete
Api para sistema de lanchonete em Java e Spring Boot.

## Detalhes da API RESTful
A API RESTful da lanchonete contém as seguintes características:

* Projeto criado com Spring Boot e Java 8
* Banco de dados em memória (H2) com JPA e Spring Data JPA
* Testes unitários e de integração com JUnit e Mockito
* Integração contínua com TravisCI
## Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git.

```
git clone https://github.com/murilidbueno/lanchonete-api.git
cd lanchonete-api
mvn spring-boot:run
Acesse os endpoints através da url http://localhost:8080
```
