# Casa Fácil Imóveis 

[![Build Status](https://travis-ci.org/WenderGalan/casa-facil-imoveis.svg?branch=master)](https://travis-ci.org/WenderGalan/casa-facil-imoveis)

O projeto consiste em construir uma aplicação de compra/venda de imóveis parecido com alguns sites já existentes. 

O projeto está divido da seguinte maneira, o front-end foi desenvolvido pelo [Matheus Pimentel](https://github.com/MatheusPimentel) e o back-end por [Wender Galan](https://github.com/WenderGalan).

## Tecnologias Utilizadas:

 - ### Back-end: [Spring boot](https://spring.io/projects/spring-boot) (dependências):
    - JPA Data: Gerenciamento das entidades da aplicação
    - Spring Security: Segurança dos web-services (Foi usado apenas para criptografia de senhas)
    - Spring Email: Usado para o envio de e-mails dentro da aplicação
    - Spring Web
    - Spring DevTools
    - [FlyWay](https://flywaydb.org/): Faz o gerenciamento de versões do banco de dados.
    - Postgres
    - Spring test (Teste de unidade)
    - [Swagger](https://swagger.io/): Faz o gerenciamento de todas as requisões (controllers) de dentro da aplicação facilitando a visualização das mesmas.
    
- ### Front-end: [Vue JS](https://vuejs.org/) (dependências):
     - Bootstrap
     - Arrumar as dependências (Matheus)
    
- ### Database: [Postgres](https://www.postgresql.org/)
    - Observações: A aplicação está com o banco de dados em deploy no Heroku, a principio da para deixar lá para poder utilizar a API sem necessidade de banco local, mas devido não ter custos o serviço é um pouco lento.
    
- ### Integração contínua: [Travis CI](https://travis-ci.org/)

- ### Links para teste da aplicação:
