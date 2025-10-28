# IEAP Microservices Project

## Overview

**IEAP (Integrated Enterprise Automation Platform)** is a modular microservices-based system built using **Spring Boot**, **Spring Cloud**, and **MySQL**.
It currently includes two core services:

* **Employee Service (HR)** — manages user authentication and employee data.
* **Finance Service** — manages expenses and financial records.

Each service is independently deployable and communicates using REST APIs.
Future plans include adding **Sales Service**, **Kafka event communication**, **API Gateway**, and **centralized logging**.

---

##  Microservices Architecture

```
ieap-microservices/
│
├── employee-service/
│   ├── src/
│   ├── pom.xml
│   
│
├── finance-service/
│   ├── src/
│   ├── pom.xml
│   
│
└── pom.xml  (optional parent)
```

---

##  Technologies Used

| Layer         | Technology                      |
| ------------- | ------------------------------- |
| Backend       | Spring Boot 3.4.3               |
| Security      | Spring Security + JWT           |
| Communication | REST (future: Kafka / RabbitMQ) |
| Database      | MySQL                           |
| API Docs      | Swagger / OpenAPI               |
| Caching       | Redis (planned)                 |
| Gateway       | Spring Cloud Gateway (planned)  |
| Logging       | ELK Stack / Loki (planned)      |

---

##  Features

* JWT-based Authentication and Authorization
*  Role-based Access (HR, Finance)
* Expense Management APIs
* MySQL Persistence with JPA/Hibernate
* Swagger UI Documentation
*  Future Support: Kafka Events & Redis Caching

---

## Setup Instructions

### 1️ Clone the Repository

```bash
git clone https://github.com/<your-username>/ieap-microservices.git
cd ieap-microservices
```

### 2️ Database Setup

Create two MySQL databases:

```sql
CREATE DATABASE employeemock_db;
CREATE DATABASE financemock_db;
```

### 3️ Update Configuration

Edit each service’s `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeemock_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 4️ Build the Services

```bash
mvn clean install
```

### 5️ Run Each Microservice

```bash
# Employee Service (port 8080)
cd employee-service
mvn spring-boot:run

# Finance Service (port 8081)
cd ../finance-service
mvn spring-boot:run
```

---

##  API Endpoints

###  Employee Service (HR)

| Endpoint             | Method | Description             |
| -------------------- | ------ | ----------------------- |
| `/api/auth/register` | POST   | Register new user       |
| `/api/auth/login`    | POST   | Login and get JWT token |
| `/api/employees`     | GET    | (Future) List employees |

**Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

###  Finance Service

| Endpoint                     | Method | Description       |
| ---------------------------- | ------ | ----------------- |
| `/api/expenses`              | POST   | Add new expense   |
| `/api/expenses`              | GET    | List all expenses |
| `/api/expenses/{id}/approve` | PUT    | Approve expense   |

**Swagger UI:** [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---

##  Postman Testing

### Example Request: Add Expense

```
POST http://localhost:8081/api/expenses
Content-Type: application/json
{
  "category": "Travel",
  "amount": 2500,
  "expenseDate": "2025-10-28",
  "description": "Client visit"
}
```

 **Response**

```json
{
  "id": 1,
  "category": "Travel",
  "amount": 2500,
  "expenseDate": "2025-10-28",
  "description": "Client visit",
  "approved": false
}
```

---

##  Future Enhancements

*  Add **Sales Service**
*  Integrate **Spring Cloud Gateway**
*  Implement **Centralized Authentication**
*  Add **Kafka / RabbitMQ** for event communication
*  Enable **Redis caching**
*  Connect to **ELK Stack** for logging and monitoring

---

##  Contributors

| Name       | Role                                   |
| ---------- | -------------------------------------- |
| **Akash** | Backend Developer (Spring Boot, MySQL) |

---

##  License

This project is open-source and free to use for learning and development purposes.
