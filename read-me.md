# Desafio Técnico Backend

## Descrição do Projeto

#### O projeto é um desafio técnico para a vaga de desenvolvedor backend, onde foi necessário desenvolver uma API para validar ums lista de CPF.

## Tecnologias e Ferramentas
* Java 18
* Docker: Para subir o banco de dados MySQL
* Spring Boot: Para desenvolver a API
* Postman: Para testar a API

## Como rodar a aplicação:
* Instale o Docker case ainda não possua.
* Se ainda não possuir o imagem, acesse: [Dockerfile](src%2Fmain%2Fresources%2FDockerfile) para gerar o build.
* Na sequência execute o arquivo [docker-compose.yml](src%2Fmain%2Fresources%2Fdocker-compose.yml) para subir o banco de dados MySQL.

## Como testar a aplicação:
* Faça um reload no POM.XML para baixar as dependências do projeto.
* Importe no Postman: [Codengage Test.postman_collection.json](src%2Fmain%2Fresources%2FRequests%20Postman%2FCodengage%20Test.postman_collection.json)
* Execute o projeto
* Execute as requisições com os CPFs que deseja validar.