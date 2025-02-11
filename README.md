# Todo List

### Tecnologias presentes na API:

- ``JAVA 23 - Jdk-23``
- `Maven 3.9.9`
- ``Spring Boot - version - (v3.4.2) ``
- ``Database version: 17.2 - PostgreSQL``
- Dependências no ``pom.xml`` 


## Informações da API
- API que cadastra Marinheiros do universo de One piece
- Os atributos que os marinheiros possuem são  
**nome**, **idade**, **cargo** e se ele tem ou não tem Akuma no Mi 
**Akumado**.


- Para testar a funcionabilidade da aplicação eu utilizei o Postman
- Enviando uma requisição ``http:8080/localhost/marinheiros`` e depois o endingpoint para testar (Os endingpoints
  estão no Packge Controller).


- Atributos da aplicação nome, idade, cargo e Akumado.
- Os atributos estão no ``Todolist\src\main\java\Model\Todo.java ``


- Passo a passo recomendado:
    - Rode (de um run no ```ApiOnepiece\src\main\java\ApiOnepieceApplication.java```) a aplicação e verifique se esta conectando com o Bando de Dados.
    - Vá para o Postman e teste essas URL´s:
        - ``POST localhost:8080/marinheiros/create``
        - ``GET localhost:8080/marinheiros/findAll``
        - ``GET localhost:8080/marinheiros/{id}``
        - ``UPDATE localhost:8080/marinheiros/update/{id}``
        - ``DELETE localhost:8080/marinheiros/delete/{id}``

## Clonando o projeto

- Abra a sua pasta de repositório, clique com o botão direito do mouse e selecione a opção "**Git Bash**"
- Execute o comando abaixo:
    - ``git clone https://github.com/Igor-monteiro-barreto/Backend-Onepiece.git``

## Banco de Dados

- Banco de dados escolhido foi o Postgre **Versão 17**
- Usei o Flayway para ter um versionamento melhor no banco de dados

    - Table do arquivo db/Migration
    - ``CREATE TABLE marinheiro(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(77) NOT NULL,
    idade INT NOT NULL,
    cargo VARCHAR(77) NOT NULL,
    Akumado BOOLEAN NOT NULL
);``

### Use Credenciais para acessar o banco de dados em um SGBD
    - Suas credenciais 
    -spring.datasource.url=jdbc:postgresql://localhost:5432/onepiecedb
    -spring.datasource.username=seu_username
    -spring.datasource.password=sua_senha
    -spring.jpa.hibernate.ddl-auto=update

## Esta Incompleta mas logo logo vou terminar...
