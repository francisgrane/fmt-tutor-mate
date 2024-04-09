# FMT Tutor Agenda Restful API

Este projeto é uma API RESTful desenvolvida em Java e Spring Boot para gerenciar agendamentos entre alunos e tutores. 
Utiliza JDK 17 e banco de dados PostgreSQL com o esquema de banco de dados especificado. Esta é uma atividade
desenvolvida dentro do módulo de Backend Java, **Lab365**, SENAI - Florianópolis, SC.

## Autor

Sou a Barbara Calderon, desenvolvedora de software.
- [Github](https://www.github.com/barbaracalderon)
- [Linkedin](https://www.linkedin.com/in/barbaracalderondev)
- [Twitter](https://www.x.com/bederoni)

## Endpoints da API

### /alunos
| Método | Endpoint                                    | Descrição                                                     |
|--------|---------------------------------------------|---------------------------------------------------------------|
| GET    | `/alunos`                                   | Retorna todos os alunos cadastrados.                          |
| GET    | `/alunos/{id}`                              | Retorna o aluno com o ID especificado.                        |
| POST   | `/alunos`                                   | Cria um novo aluno.                                           |
| PUT    | `/alunos/{id}`                              | Atualiza os dados do aluno com o ID especificado.             |
| DELETE | `/alunos/{id}`                              | Remove o aluno com o ID especificado.                         |


### /tutores
| Método | Endpoint                                    | Descrição                                                     |
|--------|---------------------------------------------|---------------------------------------------------------------|
| GET    | `/tutores`                                  | Retorna todos os tutores cadastrados.                         |
| GET    | `/tutores/{id}`                             | Retorna o tutor com o ID especificado.                        |
| POST   | `/tutores`                                  | Cria um novo tutor.                                           |
| PUT    | `/tutores/{id}`                             | Atualiza os dados do tutor com o ID especificado.             |
| DELETE | `/tutores/{id}`                             | Remove o tutor com o ID especificado.                         |


### /agendas
| Método | Endpoint               | Descrição                                                     |
|--------|------------------------|---------------------------------------------------------------|
| GET    | `/agendas`             | Retorna todas as agendas.                                      |
| GET    | `/agendas/{id}`        | Retorna uma agenda pelo ID especificado.                       |
| POST   | `/agendas`             | Cria uma nova agenda.                                         |
| PUT    | `/agendas/{id}`        | Atualiza uma agenda pelo ID especificado.                      |
| DELETE | `/agendas/{id}`        | Deleta uma agenda pelo ID especificado.                        |



### /materiais
| Método | Endpoint              | Descrição                                |
|--------|-----------------------|------------------------------------------|
| GET    | `/materiais`           | Lista todos os materiais disponíveis     |
| GET    | `/materiais/{id}`      | Busca um material pelo ID                |
| POST   | `/materiais`            | Cria um novo material                    |
| PUT    | `/materiais/{id}`       | Atualiza um material existente pelo ID   |
| DELETE | `/materiais/{id}`       | Deleta um material pelo ID               |



### /agendamentos
| Método | Endpoint                                    | Descrição                                                     |
|--------|---------------------------------------------|---------------------------------------------------------------|
| GET    | `/agendamentos/alunos/{alunoId}`           | Retorna os agendamentos pertencentes ao aluno com o ID especificado. |
| GET    | `/agendamentos/tutores/{tutorId}`          | Retorna os agendamentos pertencentes ao tutor com o ID especificado. |
| GET    | `/agendamentos/proximo/aluno/{alunoId}`    | Retorna os próximos agendamentos pertencentes ao aluno com o ID especificado. |
| GET    | `/agendamentos/proximo/tutor/{tutorId}`    | Retorna os próximos agendamentos pertencentes ao tutor com o ID especificado. |

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**: framework para desenvolvimento de aplicações Java
- **Spring Boot Starter Data JPA**: para persistência de dados
- **Spring Boot Starter Web**: para desenvolvimento de aplicativos da web
- **Spring Boot DevTools**: ferramenta para desenvolvimento mais produtivo
- **PostgreSQL**: banco de dados relacional
- **Project Lombok**: para reduzir a verbosidade do código Java
- **Maven**: gerenciador de dependências e construção de projetos

## Executando o Projeto

Antes de executar o projeto, certifique-se de ter o JDK 17 e o PostgreSQL instalados em sua máquina.

1. Clone o repositório do projeto:
    ```bash
    git clone git@github.com:barbaracalderon/fmt-tutor-mate.git
    ```

2. Acesse o diretório do projeto:
    ```bash
    cd fmt-tutor-agenda-api
    ```

3. Configure o banco de dados PostgreSQL:

    - Crie um banco de dados com o nome `fmt_tutor_agenda_db` (sugestão)
    - Insira suas configurações no arquivo `application.properties`:

```properties
# arquivo application.properties
spring.application.name=tutor
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/fmt_tutor_agenda_db
spring.datasource.username=postgres
spring.datasource.password=[digite sua senha]
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Execute o projeto:
    ```bash
    ./mvnw spring-boot:run
    ```

O servidor será iniciado em http://localhost:8080.

## Testando os Endpoints

Você pode testar os endpoints utilizando ferramentas como Postman ou Insomnia. Por exemplo:

- Para listar todos os alunos:
    ```bash
    GET http://localhost:8080/alunos
    ```

- Para criar um novo aluno:
    ```bash
    POST http://localhost:8080/tutores

    Body:
    {
      "nome": "Nome do Tutor",
      "especialidade": "Descrição da sua especialidade"
    }
    ```

Certifique-se de substituir os valores de exemplo pelos valores reais.

### Atividade

Esta foi uma atividade da semana 10, execução própria de uma proposta de projeto.