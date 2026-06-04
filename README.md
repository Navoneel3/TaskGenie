 TaskGenie

TaskGenie is a modern full-stack task management application that helps users efficiently organize and track their daily tasks. The application features a responsive frontend for seamless user interaction and a robust Spring Boot backend that exposes RESTful APIs for task management operations.

Built using Spring Boot, PostgreSQL, Docker, and modern frontend technologies, TaskGenie demonstrates end-to-end application development, API integration, database management, and containerized deployment.

Features
Frontend
Responsive and user-friendly interface
Create tasks instantly
Update task details
Delete tasks
View all tasks in real time
API integration with backend services
Clean and modern UI
Backend
RESTful API architecture
Create, Read, Update, Delete (CRUD) operations
Implemented Task Priority
DTO and Mapper pattern implementation
Centralized exception handling
PostgreSQL database integration
Dockerized deployment

---
 Tech Stack

 Backend

* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate

 Database

* PostgreSQL
 DevOps

* Docker
* Docker Compose
 Build Tool

* Maven

---

Project Structure

```text
src/main/java
│
├── controller       # REST API Endpoints
├── service          # Business Logic Layer
├── repository       # Database Access Layer
├── domain           # Entity Models
├── mapper           # DTO ↔ Entity Conversion
├── exception        # Custom Exceptions & Handlers
└── TaskAppApplication.java
```

---

 Architecture

```text
Client
   │
   ▼
Controller Layer
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
PostgreSQL Database
```

The application follows a layered architecture to ensure maintainability, scalability, and separation of concerns.

---

 API Endpoints

 Create Task

```http
POST /api/v1/tasks
```

Get All Tasks

```http
GET /api/v1/tasks
```
 Update Task

```http
PUT /api/v1/tasks/{id}
```

 Delete Task

```http
DELETE /api/v1/tasks/{id}
```

---

 Running Locally

### Prerequisites

* Java 25+
* Maven
* Docker
* PostgreSQL

 Clone Repository

```bash
git clone https://github.com/your-username/taskgenie.git
cd taskgenie
```

Build Application

```bash
mvn clean install
```

Run Application

```bash
mvn spring-boot:run
Docker Setup


 Run Container

```bash
docker run -p 8080:8080 taskgenie
```
 Using Docker Compose

```bash
docker-compose up
```

---

 Database Configuration
Configure your PostgreSQL credentials inside:
```properties
application.properties
```



Error Handling
TaskGenie includes centralized exception handling for:
* Resource Not Found
* Invalid Requests
* Validation Errors
* Internal Server Errors

This ensures consistent API responses across the application.

---
 Future Enhancements

* User Authentication & Authorization (JWT)
* Task Categories
* Due Date Management
* Search & Filtering
* Pagination & Sorting
* Swagger/OpenAPI Documentation
* Unit & Integration Testing
* CI/CD Pipeline
