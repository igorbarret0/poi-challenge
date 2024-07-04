<h1 align="center">
  Criptografia Desafio
</h1>

Solução do desafio [pontos de interesse](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md) 
## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

## Como Executar

- Clonar repositório git
```
git clone git@github.com:igorbarret0/poi-challenge.git
```

- Construir o projeto:
```
./mvnw clean package
```


A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/)

-  INTEREST POINT
```
    POST /points-of-interests - Criar ponto de interesse 

{
    "name": "name",
    "x": 10,
    "y": 7
}

```

```
    GET /points-of-interests - Obter todos os pontos de interesse
```

```
    GET /points-of-interests/near-me?x=20&y=10&dmax=10 - Obter os pontos de interesses próximos
```

