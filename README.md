# BankAPI

API de clientes e contas correntes. Projeto Java 21 / Spring Boot 3.4.5 / Maven,
com autenticação JWT didática, banco H2 e testes unitários com JUnit 5 e Mockito.

## Pré-requisitos
- Java 21
- Maven 3.9+ (ou o Maven embutido no IntelliJ)
- Git

## Como executar

### Clonar o repositório
```bash
git clone https://github.com/natybastazini/bankapi-devops.git
cd bankapi-devops
```

### Executar os testes
```bash
mvn clean test
```

### Executar a aplicação
```bash
mvn spring-boot:run
```

A API sobe em http://localhost:8080