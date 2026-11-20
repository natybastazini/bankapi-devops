# BankAPI — Código-base para o laboratório GitHub Actions

Projeto Java 21 / Spring Boot 3.4.5 / Maven com API de clientes e contas correntes, autenticação JWT didática, H2, serviços e testes unitários com JUnit 5 e Mockito.

## Como executar os testes

```bash
mvn clean test
```

## Desafio dos alunos

1. Publique o projeto em um repositório GitHub chamado `bankapi-devops`.
2. Crie `.github/workflows/ci.yml` por conta própria. **Este projeto não contém workflow pronto.**
3. Configure push e pull_request na main, Java 21, Maven build e testes.
4. Crie uma branch `feature/validacao-conta` e acrescente testes para depósito zero/negativo.
5. Abra um Pull Request e verifique a pipeline.
6. Introduza um defeito **somente na branch**, registre a falha e corrija-o antes do merge.
7. Configure cache Maven e publicação do JAR como artefato.
8. Responda no README as questões teóricas propostas no enunciado.

**Atenção:** a autenticação e chave JWT de exemplo são exclusivamente didáticas; não use credenciais ou segredos reais no repositório.
