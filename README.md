NoteAPI

Este é um projeto simples de API de Notas desenvolvido com Spring Boot. Ele permite que você crie, leia, atualize e exclua notas (CRUD) e valida os dados recebidos nas requisições.

Tecnologias Usadas

- Java 17
- Spring Boot 
- Spring Data JPA (para interação com o banco de dados)
- PostgreSQL (Banco de Dados Relacional)
- Lombok (para simplificação de código)
- Jakarta Persistence (JPA)
- Spring Web (para APIs RESTful)
- Spring Boot DevTools (para desenvolvimento)
- Spring Validation (para validação de dados nas requisições)

Funcionalidades

- (POST /notes): Cria uma nova nota.
- (GET /notes): Retorna uma lista de todas as notas.
- (GET /notes/{id}): Retorna uma nota específica com base no ID.
- (PUT /notes/{id}): Atualiza o título e o conteúdo de uma nota existente.
- (DELETE /notes/{id}): Exclui uma nota pelo ID.
