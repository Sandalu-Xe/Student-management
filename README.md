# Student Management API

A comprehensive Spring Boot 3+ RESTful API for managing student records with CRUD operations,
validation, exception handling, and advanced features.

## Features

✅ Spring Boot 3+ with Spring Data JPA
✅ MySQL/PostgreSQL/H2 Database support
✅ Complete CRUD operations
✅ Bean validation (JSR 380)
✅ Global exception handling
✅ Pagination & sorting
✅ Search by name or course
✅ Swagger UI integration
✅ Docker containerization
✅ Proper HTTP status codes

## Technology Stack

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- MySQL 8.0 / PostgreSQL 13 / H2
- Maven
- Docker & Docker Compose
- Swagger/OpenAPI 3.0

## Project Structure

```
src/main/java/com/student/api/
├── StudentManagementApplication.java
├── controller/
│   └── StudentController.java
├── service/
│   ├── StudentService.java
│   └── impl/
│       └── StudentServiceImpl.java
├── repository/
│   └── StudentRepository.java
├── entity/
│   └── Student.java
├── dto/
│   ├── StudentDTO.java
│   └── ErrorResponse.java
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
└── config/
    └── OpenApiConfig.java
```

## Setup Instructions

### 1. Clone Repository
```bash
git https://github.com/Sandalu-Xe/Student-management.git
cd student-management-api
```

### 2. Database Setup

#### MySQL
```sql
CREATE DATABASE student_db;
```

#### PostgreSQL
```sql
CREATE DATABASE student_db;
```

### 3. Configure Application

Edit `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/student_db
    username: root
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 4. Run Application

#### Using Maven
```bash
./mvnw spring-boot:run
```

#### Using Docker
```bash
docker-compose up -d
```

### 5. Access API

- API Base URL: http://localhost:8080/api/students
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console (if using H2)

## API Endpoints

| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | /api/students | Get all students (paginated) | 200 |
| GET | /api/students/{id} | Get student by ID | 200, 404 |
| POST | /api/students | Create new student | 201, 400 |
| PUT | /api/students/{id} | Update student | 200, 404 |
| DELETE | /api/students/{id} | Delete student | 204, 404 |
| GET | /api/students/search | Search students | 200 |

## Request/Response Examples

### Create Student
**Request:**
```json
POST /api/students
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "course": "Computer Science",
  "age": 21
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "course": "Computer Science",
  "age": 21,
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

### Get All Students
**Request:**
```
GET /api/students?page=0&size=10&sort=name,asc
```

**Response (200 OK):**
```json
{
  "content": [...],
  "pageable": {...},
  "totalPages": 5,
  "totalElements": 50,
  "last": false,
  "size": 10,
  "number": 0,
  "numberOfElements": 10,
  "first": true,
  "empty": false
}
```

## Error Responses

### Validation Error (400 Bad Request)
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Validation failed for object='student'",
  "validationErrors": [
    {
      "field": "email",
      "message": "Email should be valid"
    }
  ]
}
```

### Not Found Error (404 Not Found)
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Student not found with id: 999"
}
```

## Docker Commands

```bash
# Build and run
docker-compose up -d

# View logs
docker-compose logs -f student-api

# Stop services
docker-compose down

# Rebuild after changes
docker-compose up --build
```

## Testing with Postman

1. Import the collection from `postman/Student API.postman_collection.json`
2. Set base URL variable: `{{baseUrl}} = http://localhost:8080`
3. Run the requests

## Screenshots

### Postman Testing
![Postman GET Request]<img width="308" height="298" alt="image" src="https://github.com/user-attachments/assets/66ab9b4a-2a08-4f44-8504-a0608a99d007" />
<img width="452" height="230" alt="image" src="https://github.com/user-attachments/assets/7870b242-29fc-41e2-af2d-805d20578022" />
<img width="402" height="167" alt="image" src="https://github.com/user-attachments/assets/f45baa33-acbf-46b6-8807-d505689dd469" />
<img width="452" height="289" alt="image" src="https://github.com/user-attachments/assets/5ce344b4-9fc1-4409-b4d8-3b97f71df9d1" />




![Postman POST Request]
<img width="318" height="235" alt="image" src="https://github.com/user-attachments/assets/83af02e7-859b-4d00-a20b-9ef6bc4de48e" />


### Swagger UI
![Swagger UI]
<img width="826" height="580" alt="image" src="https://github.com/user-attachments/assets/03d5fda0-4d2f-4b49-bd65-9347c92b8e7b" />

<img width="817" height="484" alt="image" src="https://github.com/user-attachments/assets/a95465af-7a71-48b2-9f2a-4046addf7edd" />
<img width="831" height="540" alt="image" src="https://github.com/user-attachments/assets/6f67eaa8-a41a-4dec-8064-e71c88555618" />
<img width="633" height="448" alt="image" src="https://github.com/user-attachments/assets/e5d05fb9-9b73-4a60-bace-86ecccdb5525" />
<img width="651" height="497" alt="image" src="https://github.com/user-attachments/assets/235128e7-c9ac-4554-9fa7-a0f95fb97f99" />







## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License.

## Author

Your Name - @sandalu_Xe


## Acknowledgments

- Spring Boot team
- Spring Data JPA team
- All contributors
