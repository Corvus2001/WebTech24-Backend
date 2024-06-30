# WebTech2024-Backend

## Project Description

WebTech2024-Backend is a backend application for a task management system. This application provides basic task management functionalities such as creating, updating, deleting, and listing tasks.

## Features

- List tasks
- Create a task
- Update a task
- Delete a task
- Toggle task status (Completed/Pending)
- Filter tasks (All Tasks, Completed, Pending)

## Requirements

- Java 21
- Spring Boot 3.3.0
- PostgreSQL

## Installation

1. **Clone the repository:**

    ```bash
    git clone <repository-url>
    cd WebTech2024-Backend
    ```

2. **Install the necessary dependencies:**

    ```bash
    ./gradlew build
    ```

3. **Configure the database:**

   Open the `src/main/resources/application.properties` file and enter your PostgreSQL database details:

    ```properties
    spring.datasource.url=jdbc:postgresql://<your-database-url>:5432/<your-database-name>
    spring.datasource.username=<your-database-username>
    spring.datasource.password=<your-database-password>
    spring.datasource.driver-class-name=org.postgresql.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

## Running the Application

1. **Start the application:**

    ```bash
    ./gradlew bootRun
    ```

2. **Verify the application is running:**

    Open your browser and go to `http://localhost:8080` to ensure the application is working.

## Usage

### API Endpoints

- **GET /tasks**: List all tasks
- **GET /tasks/{id}**: Get a specific task
- **POST /tasks**: Create a new task
- **PUT /tasks/{id}**: Update an existing task
- **DELETE /tasks/{id}**: Delete a specific task

### Example Requests

**Create a Task:**

```bash
curl -X POST http://localhost:8080/tasks \
-H 'Content-Type: application/json' \
-d '{
  "title": "New Task",
  "description": "Task description",
  "done": false,
  "dueDate": "2024-12-31"
}'
Update a Task:
curl -X PUT http://localhost:8080/tasks/1 \
-H 'Content-Type: application/json' \
-d '{
  "title": "Updated Task",
  "description": "Updated task description",
  "done": true,
  "dueDate": "2024-12-31"
}'

Delete a Task:
curl -X DELETE http://localhost:8080/tasks/1

Run tests:
./gradlew test

Contributing
Fork this repository.
Create a new branch (feature-branch-name).
Commit your changes to your branch.
Create a pull request.
License

