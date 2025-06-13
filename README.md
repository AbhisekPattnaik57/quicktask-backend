# QuickTask - Backend

The Spring Boot backend for QuickTask, a full-stack task management application.

## 🔧 Features

- RESTful API for managing tasks
- Create, Read, Update, Delete operations
- Toggle task completion
- Integrated with MySQL
- CORS enabled for frontend access

## ⚙️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## API Endpoints

| Method | Endpoint             | Description            |
|--------|----------------------|------------------------|
| GET    | `/api/tasks`         | Get all tasks          |
| POST   | `/api/tasks`         | Create a task          |
| GET    | `/api/tasks/{id}`    | Get a specific task    |
| PUT    | `/api/tasks/{id}`    | Update a task          |
| PUT    | `/api/tasks/{id}/toggle` | Toggle complete/incomplete |
| DELETE | `/api/tasks/{id}`    | Delete a task          |

---

**Developed by Abhisek Pattnaik**
