# Documentação

## Executando a aplicação

A execução se da de duas forma, via `gradle` ou via `docker`, onde em ambas a aplicação ficará exposta em http://localhost:8080

### Docker

- Build:
  docker build -t password-validator-api .

- Run:
  docker run -p 8080:8080 password-validator-api

### Gradle

- Run:
  ./gradlew clean quarkusDev

Obs: É nescessário a instalação do Java 17.

## Testando a API

A documentação da aplicação do endpoint está exposta no swagger, de forma a ser possivel a chamada do mesmo via swagger.

- Swagger: http://localhost:8080/q/swagger-ui

Testando o endpoint utilizando curl:

- `curl -X POST http://localhost:8080/password/validation --data "senha"`
