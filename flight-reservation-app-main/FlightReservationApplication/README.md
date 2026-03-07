# Flight Reservation Service

A microservices-based Spring Boot application for managing flight reservations, bookings, and user accounts. This service handles all flight booking operations, user management, and payment processing.

---

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Configuration](#configuration)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Architecture](#architecture)
- [Testing](#testing)
- [Docker Support](#docker-support)
- [Deployment](#deployment)
- [Troubleshooting](#troubleshooting)

---

## 🎯 Project Overview

This is the **core Flight Reservation microservice** responsible for:
- Flight management and availability
- User registration and authentication
- Flight booking operations
- Booking modifications and cancellations
- User profile management
- Admin functionality for flight management

### Key Characteristics:
- **Spring Boot 3.3.5** - Latest Spring Boot framework
- **Java 17** - Modern Java features
- **RESTful APIs** - Standard REST endpoints
- **JWT Authentication** - Token-based security
- **Maven Build** - Dependency management
- **Docker Ready** - Containerization support
- **Kubernetes Compatible** - Cloud-native deployment

---

## ✨ Features

### User Features
- **User Registration** - Create account with email validation
- **User Authentication** - Secure login with JWT tokens
- **Flight Search** - Search flights by origin, destination, date
- **Flight Booking** - Book flights with passenger information
- **Booking Management** - View, modify, or cancel bookings
- **Profile Management** - Update user profile and preferences
- **Booking History** - View all past and current bookings

### Admin Features
- **Flight Management** - Add, edit, delete flights
- **Flight Schedule** - Manage flight dates and times
- **Pricing Management** - Update ticket prices
- **Seat Management** - Manage seat allocation and availability
- **Booking Analytics** - View booking statistics
- **User Management** - Manage user accounts and roles

### Technical Features
- **JWT Authentication** - Secure token-based auth
- **Role-Based Access Control** - User and Admin roles
- **Exception Handling** - Comprehensive error management
- **Data Validation** - Input validation and sanitization
- **Pagination** - Handle large result sets
- **Filtering & Sorting** - Advanced search capabilities
- **Audit Logging** - Track user actions
- **CORS Support** - Cross-origin resource sharing

---

## 🛠️ Technology Stack

### Core Framework
- **Spring Boot 3.3.5** - Application framework
- **Java 17** - Programming language
- **Spring Data JPA** - ORM framework
- **Spring Security** - Authentication and authorization
- **Spring Web** - REST API support

### Database
- **MySQL 8.0+** - Relational database
- **Hibernate** - ORM implementation
- **MySQL JDBC Driver** - Database connectivity

### Build & Dependency Management
- **Maven 3.8+** - Build tool
- **Spring Boot Starter** - Dependency management

### Security
- **JWT (jjwt)** - JSON Web Token
- **BCrypt** - Password hashing
- **Spring Security** - Framework security

### API Documentation
- **Springdoc OpenAPI** - Swagger/OpenAPI documentation
- **Swagger UI** - Interactive API explorer

### Testing
- **JUnit 5** - Testing framework
- **Mockito** - Mocking library
- **Spring Boot Test** - Testing utilities

### Monitoring & Logging
- **SLF4J** - Logging facade
- **Logback** - Logging implementation

---

## 📁 Project Structure

```
FlightReservationApplication/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/shivam/flightreservationapp/
│   │   │       ├── FlightReservationApplication.java    # Main application class
│   │   │       ├── controllers/                         # REST endpoints
│   │   │       │   ├── AuthController.java
│   │   │       │   ├── FlightController.java
│   │   │       │   ├── BookingController.java
│   │   │       │   └── UserController.java
│   │   │       ├── services/                           # Business logic
│   │   │       │   ├── UserService.java
│   │   │       │   ├── FlightService.java
│   │   │       │   ├── BookingService.java
│   │   │       │   └── AuthenticationService.java
│   │   │       ├── repositories/                       # Data access layer
│   │   │       │   ├── UserRepository.java
│   │   │       │   ├── FlightRepository.java
│   │   │       │   └── BookingRepository.java
│   │   │       ├── entities/                          # JPA entities
│   │   │       │   ├── User.java
│   │   │       │   ├── Flight.java
│   │   │       │   ├── Booking.java
│   │   │       │   └── Passenger.java
│   │   │       ├── dtos/                              # Data Transfer Objects
│   │   │       │   ├── UserDTO.java
│   │   │       │   ├── FlightDTO.java
│   │   │       │   ├── BookingDTO.java
│   │   │       │   ├── LoginRequest.java
│   │   │       │   └── LoginResponse.java
│   │   │       ├── config/                            # Configuration classes
│   │   │       │   ├── JwtConfig.java
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   ├── DatabaseConfig.java
│   │   │       │   └── CorsConfig.java
│   │   │       ├── security/                          # Security utilities
│   │   │       │   ├── JwtProvider.java
│   │   │       │   ├── JwtAuthenticationFilter.java
│   │   │       │   └── CustomUserDetailsService.java
│   │   │       ├── exceptions/                        # Custom exceptions
│   │   │       │   ├── ResourceNotFoundException.java
│   │   │       │   ├── DuplicateEmailException.java
│   │   │       │   └── UnauthorizedAccessException.java
│   │   │       ├── utils/                             # Utility classes
│   │   │       │   ├── ValidationUtil.java
│   │   │       │   └── ResponseUtil.java
│   │   │       └── constants/                         # Application constants
│   │   │           └── Constants.java
│   │   └── resources/
│   │       ├── application.properties                 # Application configuration
│   │       └── application-{profile}.properties       # Profile configs
│   ├── test/
│   │   └── java/
│   │       └── com/shivam/flightreservationapp/
│   │           ├── controllers/
│   │           ├── services/
│   │           └── repositories/
│   ├── k8s/                                          # Kubernetes manifests
│   │   ├── deployment.yaml
│   │   ├── service.yaml
│   │   ├── ingress.yaml
│   │   ├── hpa.yaml
│   │   └── ns.yaml
├── pom.xml                                           # Maven configuration
├── Dockerfile                                        # Docker image
├── Jenkinsfile                                       # Jenkins pipeline
├── JenkinsPipeline.md                               # Jenkins setup guide
├── sql.txt                                          # Database schema
├── application.properties                           # Main config
├── mvnw                                             # Maven wrapper (Unix)
├── mvnw.cmd                                         # Maven wrapper (Windows)
└── README.md                                        # This file
```

---

## 📋 Prerequisites

### Required Software
- **JDK 17+** - Java Development Kit
- **Maven 3.8+** - Build tool
- **MySQL 8.0+** - Database
- **Git** - Version control
- **Docker** (optional) - Containerization

### Optional Tools
- **Postman** - API testing
- **MySQL Workbench** - Database GUI
- **IntelliJ IDEA** - IDE
- **VS Code** - Code editor

---

## 🚀 Installation & Setup

### 1. Clone Repository

```bash
git clone <repository-url>
cd flight-reservation-app-main/FlightReservationApplication
```

### 2. Install Dependencies

```bash
# Using Maven
./mvnw clean install

# Or with Maven installed globally
mvn clean install
```

### 3. Set Up Database

```bash
# Create database
mysql -u root -p < sql.txt

# Or manually
mysql -u root -p
> CREATE DATABASE flightdb;
> USE flightdb;
> -- Create tables (see Database Setup section)
```

### 4. Configure Application

Create/update `application.properties`:

```properties
spring.application.name=flight-reservation-app
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/flightdb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

# JWT Configuration
jwt.secret=your_super_secret_jwt_key_here_make_it_long_256_bits_or_longer
jwt.expiration=86400000

# Application Configuration
app.frontend.url=http://localhost:3000
app.api.base-path=/api
```

---

## ⚙️ Configuration

### Environment Variables (Windows PowerShell)

```powershell
$env:DATASOURCE_URL="jdbc:mysql://localhost:3306/flightdb"
$env:DATASOURCE_USER="root"
$env:DATASOURCE_PASSWORD="root"
$env:FRONTEND_URL="http://localhost:3000"
$env:JWT_SECRET="your_jwt_secret_key"
$env:JWT_EXPIRATION="86400000"
```

### Spring Profiles

Create environment-specific configs:

**application-dev.properties**
```properties
spring.jpa.show-sql=true
logging.level.root=DEBUG
```

**application-prod.properties**
```properties
spring.jpa.show-sql=false
logging.level.root=INFO
spring.datasource.hikari.maximum-pool-size=20
```

---

## 🗄️ Database Setup

### Schema

```sql
CREATE DATABASE flightdb;
USE flightdb;

CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    gender VARCHAR(10),
    contactNumber VARCHAR(15),
    age INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE User_Roles (
    user_id BIGINT NOT NULL,
    roles VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id, roles),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

CREATE TABLE Flight (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    flightNumber VARCHAR(50) NOT NULL UNIQUE,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departureDate DATE NOT NULL,
    departureTime DATETIME NOT NULL,
    arrivalTime DATETIME,
    totalSeats INT NOT NULL DEFAULT 180,
    availableSeats INT NOT NULL DEFAULT 180,
    pricePerSeat DECIMAL(10, 2) NOT NULL,
    airline VARCHAR(100),
    duration INT,
    status VARCHAR(50) DEFAULT 'SCHEDULED',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    flight_id BIGINT NOT NULL,
    bookingDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL DEFAULT 'CONFIRMED',
    totalPrice DECIMAL(10, 2) NOT NULL,
    numberOfPassengers INT NOT NULL,
    pnr VARCHAR(50) UNIQUE,
    paymentStatus VARCHAR(50) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (flight_id) REFERENCES Flight(id),
    INDEX idx_user_id (user_id),
    INDEX idx_flight_id (flight_id),
    INDEX idx_pnr (pnr)
);

CREATE TABLE Passenger (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    dateOfBirth DATE,
    seatNumber VARCHAR(10) NOT NULL,
    passengerType VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES Booking(id) ON DELETE CASCADE,
    INDEX idx_booking_id (booking_id)
);

CREATE INDEX idx_flight_date ON Flight(departureDate);
CREATE INDEX idx_booking_status ON Booking(status);
```

### Import SQL

```bash
mysql -u root -p < sql.txt
```

---

## 🏃 Running the Application

### Development Mode

```bash
# Using Maven
./mvnw spring-boot:run

# With custom port
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8080"
```

Application starts on: `http://localhost:8080`

### Production Build

```bash
# Create JAR file
./mvnw clean package

# Run JAR
java -jar target/flightreservationApplication-0.0.1-SNAPSHOT.jar
```

---

## 📚 API Documentation

### Base URL
`http://localhost:8080/api`

### Authentication Endpoints

**Register User**
```http
POST /auth/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "securePassword123",
  "age": 30,
  "gender": "Male",
  "contactNumber": "9876543210"
}

Response: 201 Created
{
  "id": 1,
  "username": "john_doe",
  "email": "john@example.com",
  "roles": ["USER"]
}
```

**Login**
```http
POST /auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "securePassword123"
}

Response: 200 OK
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "expiresIn": 86400000,
  "user": {
    "id": 1,
    "username": "john_doe",
    "email": "john@example.com"
  }
}
```

### Flight Endpoints

**Get All Flights**
```http
GET /flights?page=0&size=10
Authorization: Bearer <token>

Response: 200 OK
{
  "content": [
    {
      "id": 1,
      "flightNumber": "AI101",
      "origin": "Delhi",
      "destination": "Mumbai",
      "departureDate": "2024-04-15",
      "departureTime": "2024-04-15 10:00:00",
      "totalSeats": 180,
      "availableSeats": 50,
      "pricePerSeat": 5000.00
    }
  ],
  "totalPages": 5,
  "totalElements": 45
}
```

**Search Flights**
```http
GET /flights/search?origin=Delhi&destination=Mumbai&date=2024-04-15
Authorization: Bearer <token>

Response: 200 OK
[
  {
    "id": 1,
    "flightNumber": "AI101",
    "origin": "Delhi",
    "destination": "Mumbai",
    "departureDate": "2024-04-15",
    "departureTime": "2024-04-15 10:00:00",
    "availableSeats": 50,
    "pricePerSeat": 5000.00
  }
]
```

**Get Flight by ID**
```http
GET /flights/1
Authorization: Bearer <token>

Response: 200 OK
{
  "id": 1,
  "flightNumber": "AI101",
  "origin": "Delhi",
  "destination": "Mumbai",
  "departureDate": "2024-04-15",
  "departureTime": "2024-04-15 10:00:00",
  "totalSeats": 180,
  "availableSeats": 50,
  "pricePerSeat": 5000.00
}
```

**Create Flight (Admin)**
```http
POST /flights
Authorization: Bearer <admin_token>
Content-Type: application/json

{
  "flightNumber": "AI102",
  "origin": "Delhi",
  "destination": "Bangalore",
  "departureDate": "2024-04-16",
  "departureTime": "2024-04-16 14:30:00",
  "totalSeats": 180,
  "pricePerSeat": 4500.00,
  "airline": "Air India"
}

Response: 201 Created
{
  "id": 2,
  "flightNumber": "AI102",
  ...
}
```

### Booking Endpoints

**Create Booking**
```http
POST /bookings
Authorization: Bearer <token>
Content-Type: application/json

{
  "flightId": 1,
  "numberOfPassengers": 2,
  "passengers": [
    {
      "firstName": "John",
      "lastName": "Doe",
      "dateOfBirth": "1990-05-15",
      "seatNumber": "1A"
    },
    {
      "firstName": "Jane",
      "lastName": "Doe",
      "dateOfBirth": "1992-03-20",
      "seatNumber": "1B"
    }
  ]
}

Response: 201 Created
{
  "id": 1,
  "pnr": "FLY123456",
  "bookingDate": "2024-03-08 10:00:00",
  "status": "CONFIRMED",
  "totalPrice": 10000.00,
  "passengers": [...]
}
```

**Get User Bookings**
```http
GET /bookings
Authorization: Bearer <token>

Response: 200 OK
[
  {
    "id": 1,
    "pnr": "FLY123456",
    "flightNumber": "AI101",
    "status": "CONFIRMED",
    "totalPrice": 10000.00,
    "bookingDate": "2024-03-08 10:00:00"
  }
]
```

**Get Booking Details**
```http
GET /bookings/1
Authorization: Bearer <token>

Response: 200 OK
{
  "id": 1,
  "pnr": "FLY123456",
  "flight": {...},
  "passengers": [...],
  "totalPrice": 10000.00,
  "status": "CONFIRMED"
}
```

**Cancel Booking**
```http
DELETE /bookings/1
Authorization: Bearer <token>

Response: 200 OK
{
  "message": "Booking cancelled successfully",
  "refundAmount": 10000.00
}
```

---

## 🏗️ Architecture

### Layered Architecture

```
┌─────────────────────────────────┐
│      REST Controllers           │
│  (Handle HTTP Requests)         │
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│      Service Layer              │
│ (Business Logic & Validation)   │
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│    Data Access Layer            │
│    (JPA Repositories)           │
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│      Database                   │
│      (MySQL)                    │
└─────────────────────────────────┘
```

### Request/Response Flow

```
Client Request
     ↓
HTTP Filter (CORS, JWT)
     ↓
Controller - Parse request
     ↓
Service - Business logic
     ↓
Repository - Database query
     ↓
Database - Store/Retrieve data
     ↓
Response - Return JSON
     ↓
Client
```

---

## ✅ Testing

### Unit Testing

```bash
# Run all tests
./mvnw test

# Run specific test
./mvnw test -Dtest=UserServiceTest

# Run with coverage
./mvnw test jacoco:report
```

### Integration Testing

```java
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testLoginSuccess() throws Exception {
        mockMvc.perform(post("/api/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"email\":\"test@example.com\",\"password\":\"password\"}"))
            .andExpect(status().isOk());
    }
}
```

---

## 🐳 Docker Support

### Build Docker Image

```bash
docker build -t flight-reservation-app:latest .
```

### Run Container

```bash
docker run -d \
  --name flight-reservation-app \
  -e DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/flightdb" \
  -e DATASOURCE_USER="root" \
  -e DATASOURCE_PASSWORD="root" \
  -p 8080:8080 \
  flight-reservation-app:latest
```

### Docker Compose

```yaml
services:
  flight-reservation-app:
    build:
      context: ./FlightReservationApplication
      dockerfile: Dockerfile
    environment:
      DATASOURCE_URL: jdbc:mysql://mysql:3306/flightdb
      DATASOURCE_USER: root
      DATASOURCE_PASSWORD: root
    ports:
      - "8080:8080"
    depends_on:
      - mysql
```

---

## 🚀 Deployment

### Kubernetes Deployment

```bash
kubectl apply -f k8s/ns.yaml
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl apply -f k8s/ingress.yaml
kubectl apply -f k8s/hpa.yaml
```

### Verify Deployment

```bash
kubectl get pods -n flight-system
kubectl logs <pod-name> -n flight-system
```

---

## 🔧 Troubleshooting

### Common Issues

**1. Port 8080 already in use:**
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8090"
```

**2. Database connection error:**
- Verify MySQL is running: `mysql -u root -p`
- Check connection URL and credentials
- Ensure flightdb database exists

**3. JWT authentication failure:**
- Verify Authorization header format: `Bearer <token>`
- Check JWT expiration
- Verify JWT secret in application.properties

**4. CORS error in browser:**
- Check CORS configuration in SecurityConfig
- Verify frontend URL matches configuration

---

## 📦 Dependencies

Key dependencies managed by Maven:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- mysql-connector-java
- jjwt (JWT library)
- lombok
- springdoc-openapi-ui (Swagger)

---

## 👨‍💻 Project Creator

This Flight Reservation Service is created and maintained by you as part of the complete flight management system.

---

**Last Updated:** March 2026  
**Version:** 1.0.0
