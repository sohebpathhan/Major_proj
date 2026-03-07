# Flight Check-In Service

A microservices-based Spring Boot application for handling flight check-ins, boarding passes, and seat management. This service manages the online check-in process for passengers and coordinates with the Flight Reservation Service.

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
- [Service Integration](#service-integration)
- [Testing](#testing)
- [Docker Support](#docker-support)
- [Deployment](#deployment)
- [Troubleshooting](#troubleshooting)

---

## 🎯 Project Overview

This is the **Flight Check-In microservice** that handles:
- Online passenger check-in
- Boarding pass generation
- Seat selection and modification
- Check-in status tracking
- Integration with Flight Reservation Service
- Passenger manifest management

### Key Characteristics:
- **Spring Boot 3.3.5** - Latest Spring Boot framework
- **Java 17** - Modern Java features
- **RESTful APIs** - Standard REST endpoints
- **JWT Authentication** - Token-based security
- **Service-to-Service Communication** - Integrates with Reservation Service
- **Docker Ready** - Containerization support
- **Kubernetes Compatible** - Cloud-native deployment

---

## ✨ Features

### Passenger Features
- **Online Check-In** - Check-in up to 24 hours before departure
- **Seat Selection** - Choose or change seat during check-in
- **Boarding Pass** - Generate boarding pass with barcode
- **Check-In Status** - Track check-in status
- **Booking Verification** - Verify booking before check-in
- **Boarding Pass Download** - Download and print boarding pass

### Admin Features
- **Passenger Manifest** - View all checked-in passengers
- **Check-In Statistics** - Monitor check-in progress
- **Seat Availability** - View available seats in real-time
- **Gate Assignment** - Assign boarding gates
- **Boarding Management** - Manage boarding process

### Technical Features
- **JWT Authentication** - Secure token-based auth
- **Service Integration** - Communicate with Reservation Service
- **Concurrent Operations** - Handle multiple check-ins simultaneously
- **Transaction Management** - ACID compliance for check-ins
- **Audit Logging** - Track check-in history
- **Error Handling** - Comprehensive exception management

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
- **Spring Security** - Framework security

### Inter-Service Communication
- **RestTemplate/WebClient** - Call Reservation Service
- **Feign Client** (optional) - Declarative HTTP client

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
FlightCheckInApplication/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/shivam/flightcheckinapp/
│   │   │       ├── FlightCheckInApplication.java      # Main application class
│   │   │       ├── controllers/                       # REST endpoints
│   │   │       │   ├── CheckInController.java
│   │   │       │   ├── BoardingPassController.java
│   │   │       │   └── ManifestController.java
│   │   │       ├── services/                         # Business logic
│   │   │       │   ├── CheckInService.java
│   │   │       │   ├── BoardingPassService.java
│   │   │       │   ├── PassengerService.java
│   │   │       │   └── ReservationServiceClient.java
│   │   │       ├── repositories/                     # Data access layer
│   │   │       │   ├── CheckInRepository.java
│   │   │       │   ├── BoardingPassRepository.java
│   │   │       │   └── PassengerRepository.java
│   │   │       ├── entities/                        # JPA entities
│   │   │       │   ├── CheckIn.java
│   │   │       │   ├── BoardingPass.java
│   │   │       │   └── Passenger.java
│   │   │       ├── dtos/                            # Data Transfer Objects
│   │   │       │   ├── CheckInRequest.java
│   │   │       │   ├── CheckInResponse.java
│   │   │       │   ├── BoardingPassDTO.java
│   │   │       │   └── ManifestDTO.java
│   │   │       ├── config/                          # Configuration classes
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   ├── JwtConfig.java
│   │   │       │   ├── RestClientConfig.java
│   │   │       │   └── CorsConfig.java
│   │   │       ├── security/                        # Security utilities
│   │   │       │   ├── JwtProvider.java
│   │   │       │   ├── JwtAuthenticationFilter.java
│   │   │       │   └── CustomUserDetailsService.java
│   │   │       ├── exceptions/                      # Custom exceptions
│   │   │       │   ├── CheckInException.java
│   │   │       │   ├── InvalidBookingException.java
│   │   │       │   └── SeatUnavailableException.java
│   │   │       ├── utils/                           # Utility classes
│   │   │       │   ├── BarcodeGenerator.java
│   │   │       │   └── PassNumerGenerator.java
│   │   │       ├── feign/                           # Feign clients
│   │   │       │   └── ReservationServiceFeignClient.java
│   │   │       └── constants/                       # Application constants
│   │   │           └── Constants.java
│   │   └── resources/
│   │       ├── application.properties               # Application configuration
│   │       └── application-{profile}.properties    # Profile configs
│   ├── test/
│   │   └── java/
│   │       └── com/shivam/flightcheckinapp/
│   │           ├── controllers/
│   │           ├── services/
│   │           └── repositories/
│   ├── k8s/                                        # Kubernetes manifests
│   │   ├── deployment.yaml
│   │   ├── service.yaml
│   │   ├── ingress.yaml
│   │   ├── hpa.yaml
│   │   └── configmap.yaml
├── pom.xml                                         # Maven configuration
├── Dockerfile                                      # Docker image
├── Jenkinsfile                                     # Jenkins pipeline
├── JenkinsPipeline.md                             # Jenkins setup guide
├── sql.txt                                        # Database schema
├── application.properties                         # Main config
├── mvnw                                           # Maven wrapper (Unix)
├── mvnw.cmd                                       # Maven wrapper (Windows)
└── README.md                                      # This file
```

---

## 📋 Prerequisites

### Required Software
- **JDK 17+** - Java Development Kit
- **Maven 3.8+** - Build tool
- **MySQL 8.0+** - Database
- **Git** - Version control
- **Docker** (optional) - Containerization

### External Services
- **Flight Reservation Service** (Port 8080) - Booking verification
- **Flight Reservation Database** - Access to booking data

---

## 🚀 Installation & Setup

### 1. Clone Repository

```bash
git clone <repository-url>
cd flight-reservation-app-main/FlightCheckInApplication
```

### 2. Install Dependencies

```bash
# Using Maven wrapper
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
> CREATE DATABASE checkin_db;
> USE checkin_db;
> -- Create tables (see Database Setup section)
```

### 4. Configure Application

Create/update `application.properties`:

```properties
spring.application.name=flight-checkin-app
server.port=8081

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/checkin_db
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# JWT Configuration
jwt.secret=your_super_secret_jwt_key_here_make_it_long_256_bits_or_longer
jwt.expiration=86400000

# External Service URLs
service.reservation.url=http://localhost:8080
service.reservation.api=/api

# Application Configuration
app.frontend.url=http://localhost:3000
app.checkin.window.hours=24
```

---

## ⚙️ Configuration

### Environment Variables (Windows PowerShell)

```powershell
$env:DATASOURCE_URL="jdbc:mysql://localhost:3306/checkin_db"
$env:DATASOURCE_USER="root"
$env:DATASOURCE_PASSWORD="root"
$env:FRONTEND_URL="http://localhost:3000"
$env:BOOKING_SERVICE_URL="http://localhost:8080/api/bookings"
$env:JWT_SECRET="your_jwt_secret_key"
```

### Feign Client Configuration

For service-to-service communication with Reservation Service:

**application.properties**
```properties
# Feign client for Reservation Service
feign.client.config.reservation-service.connect-timeout=5000
feign.client.config.reservation-service.read-timeout=10000
feign.hystrix.enabled=false
```

**ReservationServiceFeignClient.java**
```java
@FeignClient(
    name = "reservation-service",
    url = "${service.reservation.url}"
)
public interface ReservationServiceFeignClient {
    
    @GetMapping("/api/bookings/{bookingId}")
    BookingDTO getBooking(@PathVariable Long bookingId);
    
    @GetMapping("/api/flights/{flightId}")
    FlightDTO getFlight(@PathVariable Long flightId);
}
```

---

## 🗄️ Database Setup

### Schema

```sql
CREATE DATABASE checkin_db;
USE checkin_db;

CREATE TABLE CheckIn (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    flight_id BIGINT,
    passenger_name VARCHAR(100),
    checkInTime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    checkInStatus VARCHAR(50) NOT NULL DEFAULT 'CHECKED_IN',
    gate VARCHAR(10),
    boardingGroup VARCHAR(10),
    boardingStatus VARCHAR(50) DEFAULT 'NOT_BOARDED',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_booking_id (booking_id),
    INDEX idx_flight_id (flight_id),
    INDEX idx_status (checkInStatus)
);

CREATE TABLE BoardingPass (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    checkin_id BIGINT NOT NULL,
    bookingReference VARCHAR(50) NOT NULL,
    passNumber VARCHAR(50) NOT NULL UNIQUE,
    passengerName VARCHAR(100) NOT NULL,
    flightNumber VARCHAR(50) NOT NULL,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departureDate DATE NOT NULL,
    departureTime DATETIME NOT NULL,
    seatNumber VARCHAR(10) NOT NULL,
    boardingTime DATETIME,
    boardingStatus VARCHAR(50) DEFAULT 'NOT_BOARDED',
    barcode VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (checkin_id) REFERENCES CheckIn(id) ON DELETE CASCADE,
    UNIQUE KEY unique_pass_number (passNumber),
    INDEX idx_boarding_ref (bookingReference),
    INDEX idx_flight_date (departureDate)
);

CREATE TABLE Passenger (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    checkin_id BIGINT NOT NULL,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    email VARCHAR(255),
    seatNumber VARCHAR(10) NOT NULL,
    mealPreference VARCHAR(50),
    specialRequirements VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (checkin_id) REFERENCES CheckIn(id) ON DELETE CASCADE,
    INDEX idx_checkin_id (checkin_id)
);

CREATE TABLE CheckInAudit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    action VARCHAR(100) NOT NULL,
    details TEXT,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_booking_id (booking_id),
    INDEX idx_created_at (created_at)
);
```

### Import SQL

```bash
mysql -u root -p < sql.txt
```

---

## 🏃 Running the Application

### Development Mode

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# With custom port
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

Application starts on: `http://localhost:8081`

### Production Build

```bash
# Create JAR file
./mvnw clean package

# Run JAR
java -jar target/flightCkeckinApplication-0.0.1-SNAPSHOT.jar
```

---

## 📚 API Documentation

### Base URL
`http://localhost:8081/api`

### Check-In Endpoints

**Check-In Passenger**
```http
POST /checkin
Authorization: Bearer <token>
Content-Type: application/json

{
  "bookingId": 1,
  "seatNumber": "12A",
  "mealPreference": "Vegetarian",
  "specialRequirements": "Wheelchair assistance"
}

Response: 201 Created
{
  "checkinId": 1,
  "bookingId": 1,
  "checkInTime": "2024-03-08 10:30:00",
  "status": "SUCCESS",
  "boardingPass": {
    "passNumber": "BP123456789",
    "flightNumber": "AI101",
    "seatNumber": "12A",
    "departureTime": "2024-04-15 10:00:00"
  }
}
```

**Get Check-In Status**
```http
GET /checkin/{bookingId}
Authorization: Bearer <token>

Response: 200 OK
{
  "bookingId": 1,
  "checkInStatus": "CHECKED_IN",
  "checkInTime": "2024-03-08 10:30:00",
  "gate": "A15",
  "boardingGroup": "3",
  "boardingStatus": "NOT_BOARDED"
}
```

**Get Check-In by ID**
```http
GET /checkin/{checkinId}/details
Authorization: Bearer <token>

Response: 200 OK
{
  "id": 1,
  "bookingId": 1,
  "status": "CHECKED_IN",
  "passengers": [
    {
      "firstName": "John",
      "lastName": "Doe",
      "seatNumber": "12A"
    }
  ],
  "boardingPass": {...}
}
```

### Boarding Pass Endpoints

**Get Boarding Pass**
```http
GET /boarding-pass/{checkinId}
Authorization: Bearer <token>

Response: 200 OK
{
  "id": 1,
  "passNumber": "BP123456789",
  "passengerName": "John Doe",
  "flightNumber": "AI101",
  "seatNumber": "12A",
  "departureTime": "2024-04-15 10:00:00",
  "boardingTime": "2024-04-15 09:30:00",
  "barcode": "base64_encoded_barcode",
  "qrCode": "base64_encoded_qrcode"
}
```

**Download Boarding Pass (PDF)**
```http
GET /boarding-pass/{checkinId}/download
Authorization: Bearer <token>

Response: 200 OK
Content-Type: application/pdf
// Binary PDF content
```

### Passenger Manifest Endpoints

**Get Flight Manifest**
```http
GET /manifest/{flightId}
Authorization: Bearer <admin_token>

Response: 200 OK
{
  "flightNumber": "AI101",
  "departureDate": "2024-04-15",
  "totalPassengers": 150,
  "checkedInPassengers": 120,
  "passengers": [
    {
      "checkinId": 1,
      "passengerName": "John Doe",
      "seatNumber": "12A",
      "checkInStatus": "CHECKED_IN"
    }
  ]
}
```

**Get Check-In Summary**
```http
GET /checkin/summary
Authorization: Bearer <admin_token>

Response: 200 OK
{
  "totalCheckIns": 500,
  "successfulCheckIns": 480,
  "failedCheckIns": 20,
  "averageCheckInTime": "3.5 minutes",
  "recentCheckIns": [...]
}
```

---

## 🔗 Service Integration

### Reservation Service Communication

```java
@Service
public class CheckInService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    private String reservationServiceUrl;
    
    public BookingDTO getBookingDetails(Long bookingId) {
        String url = reservationServiceUrl + "/api/bookings/" + bookingId;
        try {
            ResponseEntity<BookingDTO> response = restTemplate.getForEntity(url, BookingDTO.class);
            return response.getBody();
        } catch (RestClientException e) {
            throw new ExternalServiceException("Failed to fetch booking details", e);
        }
    }
    
    public void updateBookingCheckInStatus(Long bookingId, String status) {
        String url = reservationServiceUrl + "/api/bookings/" + bookingId + "/checkin-status";
        HttpEntity<String> request = new HttpEntity<>(status);
        restTemplate.postForEntity(url, request, String.class);
    }
}
```

### Error Handling

```java
@ExceptionHandler(RestClientException.class)
public ResponseEntity<?> handleServiceUnavailable(RestClientException e) {
    return ResponseEntity
        .status(HttpStatus.SERVICE_UNAVAILABLE)
        .body(new ErrorResponse("Reservation service is unavailable"));
}
```

---

## ✅ Testing

### Unit Testing

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=CheckInServiceTest

# Run with coverage report
./mvnw test jacoco:report
```

### Sample Test

```java
@SpringBootTest
@AutoConfigureMockMvc
public class CheckInControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CheckInService checkInService;
    
    @Test
    public void testCheckInSuccess() throws Exception {
        // Arrange
        CheckInRequest request = new CheckInRequest();
        request.setBookingId(1L);
        request.setSeatNumber("12A");
        
        // Act & Assert
        mockMvc.perform(post("/api/checkin")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(request))
            .header("Authorization", "Bearer token"))
            .andExpect(status().isCreated());
    }
}
```

---

## 🐳 Docker Support

### Build Docker Image

```bash
docker build -t flight-checkin-app:latest .
```

### Run Container

```bash
docker run -d \
  --name flight-checkin-app \
  -e DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/checkin_db" \
  -e DATASOURCE_USER="root" \
  -e DATASOURCE_PASSWORD="root" \
  -e BOOKING_SERVICE_URL="http://host.docker.internal:8080/api/bookings" \
  -p 8081:8081 \
  flight-checkin-app:latest
```

### Docker Network

```bash
# Create network
docker network create flight-network

# Run with network
docker run -d \
  --network flight-network \
  --name flight-checkin-app \
  -e BOOKING_SERVICE_URL="http://flight-reservation-app:8080/api/bookings" \
  -p 8081:8081 \
  flight-checkin-app:latest
```

---

## 🚀 Deployment

### Kubernetes Deployment

```bash
# Deploy to Kubernetes
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl apply -f k8s/ingress.yaml
kubectl apply -f k8s/configmap.yaml

# Verify
kubectl get pods
```

### Configuration as ConfigMap

```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: checkin-config
data:
  BOOKING_SERVICE_URL: "http://flight-reservation-app:8080/api"
  CHECKIN_WINDOW_HOURS: "24"
```

---

## 🔧 Troubleshooting

### Common Issues

**1. Cannot connect to Reservation Service:**
- Verify Reservation Service is running on port 8080
- Check network connectivity
- Verify service URL configuration
- Check firewall rules

**2. Database connection failure:**
- Ensure MySQL is running
- Verify credentials in application.properties
- Check if checkin_db database exists
- Verify network connectivity to database

**3. JWT Token validation failed:**
- Ensure JWT secret matches between services
- Check token expiration
- Verify Authorization header format: `Bearer <token>`

**4. Seat selection conflicts:**
- Implement proper locking mechanism
- Use database transactions
- Test concurrent check-ins

### Debug Logging

```properties
logging.level.com.shivam.flightcheckinapp=DEBUG
logging.level.org.springframework.web=DEBUG
logging.level.org.springframework.security=DEBUG
```

---

## 📦 Dependencies

Key dependencies in pom.xml:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- mysql-connector-java
- jjwt (JWT library)
- spring-cloud-starter-openfeign
- lombok
- itextpdf (PDF generation)

---

## 🔐 Security Considerations

- Validate booking ownership before check-in
- Implement rate limiting on check-in requests
- Use HTTPS in production
- Encrypt sensitive passenger data
- Implement audit logging for all check-ins
- Use secure JWT secrets

---

## 👨‍💻 Project Creator

This Flight Check-In Service is created and maintained by you as part of the complete flight management system.

---

**Last Updated:** March 2026  
**Version:** 1.0.0
