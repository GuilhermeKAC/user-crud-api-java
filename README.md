# User CRUD API - Java

API CRUD de usuários desenvolvida em Java puro com PostgreSQL, sem frameworks externos.

## Tecnologias

- Java 17
- PostgreSQL
- JDBC (postgresql-42.7.x)

## Estrutura do Projeto

```
src/
├── resources/
│   └── application.properties
└── userapi/
    ├── Application.java
    ├── DatabaseConfig.java
    ├── controller/
    │   └── UserController.java
    ├── model/
    │   └── User.java
    ├── repository/
    │   └── UserRepository.java
    └── service/
        └── UserService.java
```

## Configuração

1. Crie o banco de dados no PostgreSQL:
```sql
CREATE DATABASE user_crud_db;
CREATE USER meuuser WITH PASSWORD '123456';
GRANT ALL PRIVILEGES ON DATABASE user_crud_db TO meuuser;
GRANT CREATE ON SCHEMA public TO meuuser;
```

2. Configure as credenciais em `src/resources/application.properties`:
```properties
db.url=jdbc:postgresql://localhost:5432/user_crud_db
db.user=meuuser
db.password=123456
```

## Como Executar

Compile e execute a classe `userapi.Application`. A tabela `users` é criada automaticamente na primeira execução.

## Operações disponíveis

| Operação | Descrição |
|----------|-----------|
| `createUser` | Cria um novo usuário |
| `getAllUsers` | Lista todos os usuários |
| `getUserById` | Busca usuário por ID |
| `updateUser` | Atualiza dados do usuário |
| `deleteUser` | Remove um usuário |
