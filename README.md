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
  
  ```sql 
  CREATE TABLE marinheiro(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(77) NOT NULL,
    idade INT NOT NULL,
    cargo ENUM('Almirante', 'Vice_Almirante', 'Capitão', 'Recruta',
     'Almirante_de_Frota', 'vice_capitão',
     'Contra_Almirante', 'Aprendiz_de_Marinheiro', 'Tenente') NOT NULL,
    Akumado BOOLEAN NOT NULL);
  ````

### Use Credenciais para acessar o banco de dados em um SGBD
    - Suas credenciais 
    -spring.datasource.url=jdbc:postgresql://localhost:5432/onepiecedb
    -spring.datasource.username=seu_username
    -spring.datasource.password=sua_senha
    -spring.jpa.hibernate.ddl-auto=update

## Testando aplicação com Postmam ou Insomaniac

- body da requisição **POST**
```json
{
"nome": "Zé",
"idade": 55,
"cargo": "Recruta",
"Akumado": true
}
```
- endereço ``localhost:8080/marinheiros/create``

- Teste para encontrar por ID:
- ``localhost:8080/marinheiros/1``
- Testar o delete 
- ``localhost:8080/marinheiros/delete/1``
- Testar o findAll
- ``localhost:8080/marinheiros/findAll``
- Testar o update 
- ``localhost:8080/marinheiros/update/2``
```json
{
  "nome": "Monkey D.Garp",
  "idade": 76,
  "cargo": "Almirante",
  "Akumado": false
}
```

## Esta Incompleta mas logo logo vou terminar...
