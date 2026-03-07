# Flight Reservation & Check-In Application

A comprehensive microservices-based flight reservation and check-in platform built with modern technologies, featuring scalable backend services, a responsive React frontend, and cloud-native infrastructure.

---

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [System Architecture](#system-architecture)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Database Setup](#database-setup)
- [Deployment](#deployment)
- [CI/CD Pipeline](#cicd-pipeline)
- [API Documentation](#api-documentation)
- [Infrastructure as Code](#infrastructure-as-code)
- [Docker & Containerization](#docker--containerization)
- [Kubernetes Deployment](#kubernetes-deployment)
- [Contributing](#contributing)

---

## 🎯 Project Overview

This is a **full-stack microservices-based flight management system** designed to handle flight reservations, bookings, and check-in operations. The system is built to be scalable, maintainable, and cloud-ready with support for Docker containerization and Kubernetes orchestration.

### Key Objectives:
- Provide users with a seamless flight booking experience
- Enable efficient flight check-in procedures
- Maintain separate microservices for different business concerns
- Support cloud-native deployment patterns
- Implement automated CI/CD pipelines for continuous integration and deployment
- Ensure code quality through automated testing and SonarQube scanning

---

## 🏗️ System Architecture

The application follows a **microservices architecture** with the following components:

```
┌─────────────────────────────────────────────────────────────┐
│                     React Frontend                          │
│              (Vite + Redux + React Router)                  │
└──────────────────────┬──────────────────────────────────────┘
                       │
         ┌─────────────┴─────────────┐
         │                           │
┌────────▼──────────────┐  ┌────────▼──────────────┐
│ Flight Reservation    │  │   Flight Check-In     │
│    Service (Port 8080)│  │   Service (Port 8081) │
│   (Spring Boot 3.3.5) │  │   (Spring Boot 3.3.5) │
└────────┬──────────────┘  └────────┬──────────────┘
         │                           │
         └─────────────┬─────────────┘
                       │
        ┌──────────────┴──────────────┐
        │                             │
   ┌────▼─────┐            ┌─────────▼─────┐
   │ MySQL    │            │ MySQL         │
   │ flightdb │            │ checkin_db    │
   └──────────┘            └───────────────┘

┌──────────────────────────────────────┐
│  Jenkins CI/CD Pipeline              │
│  - Build & Test                      │
│  - SonarQube Analysis                │
│  - Docker Image Build & Push         │
│  - Kubernetes Deployment             │
└──────────────────────────────────────┘

┌──────────────────────────────────────┐
│     Kubernetes Cluster               │
│  - Deployments                       │
│  - Services                          │
│  - Ingress                           │
│  - Horizontal Pod Autoscaling        │
└──────────────────────────────────────┘
```

---

## 🛠️ Technology Stack

### Backend Services
- **Spring Boot 3.3.5** - Enterprise Java framework
- **Java 17** - Latest LTS Java version
- **Maven** - Dependency management and build tool
- **MySQL** - Relational database
- **Spring Data JPA** - ORM framework
- **Spring Security** - Authentication and authorization

### Frontend
- **React 19.0.0** - UI library
- **Vite** - Fast build tool and dev server
- **Redux Toolkit** - State management
- **React Router 7.2.0** - Client-side routing
- **Axios** - HTTP client
- **React Toastify** - Toast notifications
- **Boxicons** - Icon library

### DevOps & Infrastructure
- **Docker** - Containerization
- **Kubernetes** - Container orchestration
- **Jenkins** - CI/CD automation
- **SonarQube** - Code quality analysis
- **Terraform** - Infrastructure as Code
- **AWS** - Cloud platform
  - EKS (Elastic Kubernetes Service)
  - RDS (Relational Database Service)
  - S3 (Simple Storage Service)

### Monitoring & Logging
- **Horizontal Pod Autoscaler (HPA)** - Auto-scaling based on metrics
- **Prometheus** - Metrics collection (can be integrated)
- **ELK Stack** - Log aggregation (can be integrated)

---

## 📁 Project Structure

```
flight-reservation-app-main/
├── FlightReservationApplication/       # Flight Booking Microservice
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/shivam/flightreservationapp/
│   │   │   │   ├── FlightReservationApplication.java
│   │   │   │   ├── controllers/          # REST endpoints
│   │   │   │   ├── services/             # Business logic
│   │   │   │   ├── repositories/         # Database access
│   │   │   │   ├── entities/             # JPA entities
│   │   │   │   ├── dtos/                 # Data transfer objects
│   │   │   │   ├── config/               # Spring configuration
│   │   │   │   └── security/             # Security config
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── k8s/                             # Kubernetes manifests
│   │   ├── deployment.yaml
│   │   ├── service.yaml
│   │   ├── ingress.yaml
│   │   ├── hpa.yaml                     # Horizontal Pod Autoscaler
│   │   └── ns.yaml                      # Namespace
│   ├── pom.xml                          # Maven configuration
│   ├── Dockerfile                       # Docker image definition
│   ├── Jenkinsfile                      # Jenkins pipeline script
│   ├── JenkinsPipeline.md              # Jenkins setup documentation
│   ├── application.properties
│   └── sql.txt                          # Database schema

├── FlightCheckInApplication/            # Flight Check-In Microservice
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/shivam/flightcheckinapp/
│   │   │   │   ├── FlightCheckInApplication.java
│   │   │   │   ├── controllers/
│   │   │   │   ├── services/
│   │   │   │   ├── repositories/
│   │   │   │   ├── entities/
│   │   │   │   ├── dtos/
│   │   │   │   ├── config/
│   │   │   │   └── security/
│   │   │   └── resources/application.properties
│   │   └── test/
│   ├── pom.xml
│   ├── Dockerfile
│   ├── Jenkinsfile
│   ├── JenkinsPipeline.md
│   └── sql.txt

├── frontend/                             # React Frontend Application
│   ├── src/
│   │   ├── Components/                  # React components
│   │   │   ├── Home.jsx                # Landing page
│   │   │   ├── Login.jsx               # User login
│   │   │   ├── Register.jsx            # User registration
│   │   │   ├── Flights.jsx             # Flight listing
│   │   │   ├── FlightSearch.jsx        # Flight search
│   │   │   ├── Booking.jsx             # Booking management
│   │   │   ├── CheckIn.jsx             # Check-in interface
│   │   │   ├── Payment.jsx             # Payment processing
│   │   │   ├── Admin.jsx               # Admin dashboard
│   │   │   ├── Profile.jsx             # User profile
│   │   │   └── ...other components
│   │   ├── Redux-config/               # Redux store setup
│   │   │   ├── store.js
│   │   │   └── UserSlice.js
│   │   ├── api.js                      # API calls
│   │   ├── App.jsx                     # Main app component
│   │   ├── main.jsx                    # Entry point
│   │   └── index.css
│   ├── public/
│   │   ├── Css/                        # Global stylesheets
│   │   └── Images/                     # Static images
│   ├── package.json                    # NPM dependencies
│   ├── vite.config.js                  # Vite configuration
│   ├── eslint.config.js                # ESLint rules
│   ├── Dockerfile                      # Docker image
│   ├── Jenkinsfile
│   └── JenkinsPipeline.md

├── tf/                                  # Terraform Infrastructure Code
│   ├── main.tf                         # Main infrastructure
│   ├── modules/
│   │   ├── eks/                        # AWS EKS configuration
│   │   │   ├── main.tf
│   │   │   ├── variable.tf
│   │   │   └── output.tf
│   │   ├── rds/                        # AWS RDS database configuration
│   │   │   ├── main.tf
│   │   │   ├── variable.tf
│   │   │   └── output.tf
│   │   └── s3/                         # AWS S3 bucket configuration
│   │       ├── main.tf
│   │       ├── variable.tf
│   │       └── output.tf
│   └── README.md

├── BuildCommands.txt                    # Build commands reference
├── sql.txt                              # Combined database scripts
└── Readme.md                            # This file
```

---

## ✨ Features

### User Features
- **Flight Search & Booking** - Search and book flights based on criteria
- **User Registration & Authentication** - Secure user account management
- **Booking Management** - View, modify, or cancel bookings
- **Flight Check-In** - Online check-in with seat selection
- **Payment Processing** - Secure payment gateway integration
- **User Profile Management** - Update personal information
- **Booking History** - View past and current bookings

### Admin Features
- **Flight Management** - Add, edit, and manage flights
- **Admin Dashboard** - Overview of bookings and check-ins
- **User Management** - Manage user accounts and roles
- **Booking Analytics** - View booking statistics

### System Features
- **Microservices Architecture** - Separate services for different concerns
- **Scalability** - Auto-scaling with Kubernetes HPA
- **High Availability** - Multi-pod deployments
- **CI/CD Pipeline** - Automated testing and deployment
- **Code Quality** - SonarQube integration for code analysis
- **Containerization** - Docker support for all services
- **Infrastructure as Code** - Terraform for AWS infrastructure
- **RESTful APIs** - Standard REST endpoints for all services
- **Role-Based Access Control** - Different user roles (User, Admin)

---

## 📋 Prerequisites

- **Java 17** or higher
- **Node.js 18+** and **npm 9+**
- **MySQL 8.0+**
- **Docker** and **Docker Compose** (for containerization)
- **Maven 3.8+**
- **Git**
- **Kubectl** (for Kubernetes deployment)
- **AWS Account** (for cloud deployment)
- **Jenkins** (for CI/CD)
- **SonarQube** (for code quality)

---

## 🚀 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd flight-reservation-app-main
```

### 2. Backend Setup - Flight Reservation Application

```bash
cd FlightReservationApplication

# Set environment variables (Windows PowerShell)
$env:DATASOURCE_URL="jdbc:mysql://localhost:3306/flightdb"
$env:DATASOURCE_USER="root"
$env:DATASOURCE_PASSWORD="root"
$env:FRONTEND_URL="http://localhost:3000"

# Build the application
./mvnw clean package

# Run the application
./mvnw spring-boot:run
```

The service will start on `http://localhost:8080`

### 3. Backend Setup - Flight Check-In Application

```bash
cd FlightCheckInApplication

# Set environment variables (Windows PowerShell)
$env:DATASOURCE_URL="jdbc:mysql://localhost:3306/checkin_db"
$env:DATASOURCE_USER="root"
$env:DATASOURCE_PASSWORD="root"
$env:FRONTEND_URL="http://localhost:3000"
$env:BOOKING_SERVICE_URL="http://localhost:8080/api/bookings"

# Build the application
./mvnw clean package

# Run the application
./mvnw spring-boot:run
```

The service will start on `http://localhost:8081`

### 4. Frontend Setup

```bash
cd frontend

# Install dependencies
npm install

# Start development server
npm run dev
```

The frontend will be available at `http://localhost:5173` (Vite default)

---

## ⚙️ Configuration

### Flight Reservation Application Properties

Create or update `FlightReservationApplication/src/main/resources/application.properties`:

```properties
spring.application.name=flight-reservation-app
spring.datasource.url=jdbc:mysql://localhost:3306/flightdb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
app.frontend.url=http://localhost:3000
app.jwt.secret=your_jwt_secret_key_here
app.jwt.expiration=86400000
```

### Flight Check-In Application Properties

Create or update `FlightCheckInApplication/src/main/resources/application.properties`:

```properties
spring.application.name=flight-checkin-app
spring.datasource.url=jdbc:mysql://localhost:3306/checkin_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8081
app.frontend.url=http://localhost:3000
app.booking.service.url=http://localhost:8080/api/bookings
app.jwt.secret=your_jwt_secret_key_here
app.jwt.expiration=86400000
```

### Frontend Configuration

Update `frontend/.env` or configure in `api.js`:

```javascript
const API_BASE_URL = 'http://localhost:8080/api';
const CHECKIN_API_URL = 'http://localhost:8081/api';
```

---

## 🏃 Running the Application

### Option 1: Run Locally (Development)

**Terminal 1 - Flight Reservation Service:**
```bash
cd FlightReservationApplication
./mvnw spring-boot:run
```

**Terminal 2 - Flight Check-In Service:**
```bash
cd FlightCheckInApplication
./mvnw spring-boot:run
```

**Terminal 3 - Frontend:**
```bash
cd frontend
npm run dev
```

### Option 2: Run with Docker Compose

Create a `docker-compose.yml` in the root directory:

```yaml
version: '3.8'

services:
  mysql-flight:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: flightdb
    ports:
      - "3306:3306"
    volumes:
      - mysql_flight_data:/var/lib/mysql

  mysql-checkin:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: checkin_db
    ports:
      - "3307:3306"
    volumes:
      - mysql_checkin_data:/var/lib/mysql

  flight-reservation-app:
    build:
      context: ./FlightReservationApplication
      dockerfile: Dockerfile
    environment:
      DATASOURCE_URL: jdbc:mysql://mysql-flight:3306/flightdb
      DATASOURCE_USER: root
      DATASOURCE_PASSWORD: root
      FRONTEND_URL: http://localhost:3000
    ports:
      - "8080:8080"
    depends_on:
      - mysql-flight

  flight-checkin-app:
    build:
      context: ./FlightCheckInApplication
      dockerfile: Dockerfile
    environment:
      DATASOURCE_URL: jdbc:mysql://mysql-checkin:3306/checkin_db
      DATASOURCE_USER: root
      DATASOURCE_PASSWORD: root
      FRONTEND_URL: http://localhost:3000
      BOOKING_SERVICE_URL: http://flight-reservation-app:8080/api/bookings
    ports:
      - "8081:8081"
    depends_on:
      - mysql-checkin
      - flight-reservation-app

  frontend:
    build:
      context: ./frontend
      dockerfile: Dockerfile
    ports:
      - "3000:3000"
    depends_on:
      - flight-reservation-app
      - flight-checkin-app

volumes:
  mysql_flight_data:
  mysql_checkin_data:
```

Run with Docker Compose:
```bash
docker-compose up -d
```

---

## 🗄️ Database Setup

### Flight Database (flightdb)

```sql
CREATE DATABASE flightdb;
USE flightdb;

CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    gender VARCHAR(10),
    contactNumber VARCHAR(15),
    age INT
);

CREATE TABLE User_Roles (
    user_id BIGINT NOT NULL,
    roles VARCHAR(50),
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
    totalSeats INT NOT NULL,
    availableSeats INT NOT NULL,
    pricePerSeat DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    flight_id BIGINT NOT NULL,
    bookingDate DATETIME NOT NULL,
    status VARCHAR(50),
    totalPrice DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (flight_id) REFERENCES Flight(id)
);

CREATE TABLE Passenger (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    dateOfBirth DATE,
    seatNumber VARCHAR(10),
    FOREIGN KEY (booking_id) REFERENCES Booking(id) ON DELETE CASCADE
);
```

### Check-In Database (checkin_db)

```sql
CREATE DATABASE checkin_db;
USE checkin_db;

CREATE TABLE CheckIn (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    checkInTime DATETIME NOT NULL,
    gate VARCHAR(10),
    boardingStatus VARCHAR(50)
);

CREATE TABLE BoardingPass (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    checkin_id BIGINT NOT NULL,
    passingNumber VARCHAR(50) NOT NULL UNIQUE,
    seatNumber VARCHAR(10) NOT NULL,
    FOREIGN KEY (checkin_id) REFERENCES CheckIn(id)
);
```

### Import SQL Scripts

```bash
# Flight Database
mysql -u root -p < FlightReservationApplication/sql.txt

# Check-In Database
mysql -u root -p < FlightCheckInApplication/sql.txt
```

---

## 🐳 Docker & Containerization

### Build Docker Images

**Flight Reservation Application:**
```bash
cd FlightReservationApplication
docker build -t flight-reservation-app:latest .
```

**Flight Check-In Application:**
```bash
cd FlightCheckInApplication
docker build -t flight-checkin-app:latest .
```

**Frontend:**
```bash
cd frontend
docker build -t flight-frontend:latest .
```

### Run with Docker

```bash
# Flight Reservation
docker run -d --name flight-reservation-app \
  -e DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/flightdb" \
  -e DATASOURCE_USER="root" \
  -e DATASOURCE_PASSWORD="root" \
  -p 8080:8080 \
  flight-reservation-app:latest

# Flight Check-In
docker run -d --name flight-checkin-app \
  -e DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/checkin_db" \
  -e DATASOURCE_USER="root" \
  -e DATASOURCE_PASSWORD="root" \
  -e BOOKING_SERVICE_URL="http://flight-reservation-app:8080/api/bookings" \
  -p 8081:8081 \
  flight-checkin-app:latest

# Frontend
docker run -d --name flight-frontend \
  -p 3000:3000 \
  flight-frontend:latest
```

---

## ☸️ Kubernetes Deployment

### Prerequisites

- Kubernetes cluster running (EKS recommended)
- `kubectl` configured to access cluster
- Docker images pushed to a registry (ECR, Docker Hub)

### Deploy to Kubernetes

**1. Create Namespace:**
```bash
kubectl apply -f FlightReservationApplication/k8s/ns.yaml
```

**2. Deploy Flight Reservation Service:**
```bash
kubectl apply -f FlightReservationApplication/k8s/deployment.yaml
kubectl apply -f FlightReservationApplication/k8s/service.yaml
kubectl apply -f FlightReservationApplication/k8s/ingress.yaml
kubectl apply -f FlightReservationApplication/k8s/hpa.yaml
```

**3. Deploy Flight Check-In Service:**
```bash
kubectl apply -f FlightCheckInApplication/k8s/deployment.yaml
kubectl apply -f FlightCheckInApplication/k8s/service.yaml
```

**4. Verify Deployments:**
```bash
kubectl get deployments -n flight-system
kubectl get pods -n flight-system
kubectl get services -n flight-system
kubectl get hpa -n flight-system
```

**5. Access the Application:**
- Check Ingress IP: `kubectl get ingress -n flight-system`
- Applications will be accessible via the Ingress endpoint

---

## 🏗️ Infrastructure as Code

### Terraform Setup

The `tf/` directory contains Terraform configurations for AWS infrastructure:

- **EKS Module** - Kubernetes cluster on AWS
- **RDS Module** - Managed MySQL databases
- **S3 Module** - Object storage for logs and backups

### Deploy Infrastructure

```bash
cd tf

# Initialize Terraform
terraform init

# Plan infrastructure
terraform plan

# Apply infrastructure
terraform apply

# Destroy infrastructure (when done)
terraform destroy
```

---

## 🔄 CI/CD Pipeline

### Jenkins Pipeline Overview

The project includes Jenkins Pipelines for automated:
1. **Build** - Compile code and resolve dependencies
2. **Test** - Run unit and integration tests
3. **Code Analysis** - SonarQube quality analysis
4. **Build Docker Image** - Create containerized images
5. **Push to Registry** - Push to Docker Hub/ECR
6. **Deploy to Kubernetes** - Deploy to K8s cluster

### Setup Jenkins

Follow instructions in `FlightReservationApplication/JenkinsPipeline.md`:

1. Install Jenkins
2. Install SonarQube
3. Configure Jenkins plugins
4. Create pipeline jobs
5. Configure webhooks for auto-trigger

### Sample Jenkinsfile Structure

```groovy
pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh './mvnw clean package'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing...'
                sh './mvnw test'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyzing code quality...'
                // SonarQube scan
            }
        }
        
        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t flight-reservation-app:${BUILD_NUMBER} .'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying to Kubernetes...'
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}
```

---

## 📚 API Documentation

### Flight Reservation Service (Port 8080)

**Base URL:** `http://localhost:8080/api`

#### Authentication Endpoints
- `POST /auth/register` - Register new user
- `POST /auth/login` - Login user
- `POST /auth/refresh` - Refresh JWT token

#### Flight Endpoints
- `GET /flights` - Get all flights
- `GET /flights/{id}` - Get flight by ID
- `POST /flights` - Create flight (Admin)
- `PUT /flights/{id}` - Update flight (Admin)
- `DELETE /flights/{id}` - Delete flight (Admin)

#### Booking Endpoints
- `GET /bookings` - Get user's bookings
- `GET /bookings/{id}` - Get booking details
- `POST /bookings` - Create new booking
- `PUT /bookings/{id}` - Update booking
- `DELETE /bookings/{id}` - Cancel booking

#### User Endpoints
- `GET /users/profile` - Get user profile
- `PUT /users/profile` - Update profile
- `GET /users` - Get all users (Admin)

### Flight Check-In Service (Port 8081)

**Base URL:** `http://localhost:8081/api`

#### Check-In Endpoints
- `GET /checkin/{bookingId}` - Get check-in status
- `POST /checkin` - Check-in passenger
- `GET /boarding-pass/{checkInId}` - Get boarding pass

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see LICENSE file for details.

---

## 👨‍💼 Project Author

**Shivam** - Full Stack Developer

---

## 📞 Support & Contact

For issues, questions, or suggestions, please create an issue in the repository or contact the development team.

---

## 🗺️ Roadmap

- [ ] Payment Gateway Integration (Stripe/PayPal)
- [ ] Email Notifications
- [ ] SMS Alerts
- [ ] Mobile App (React Native)
- [ ] Advanced Analytics Dashboard
- [ ] Real-time Notifications (WebSocket)
- [ ] Multi-language Support
- [ ] Two-Factor Authentication
- [ ] Loyalty Program
- [ ] API Rate Limiting

---

## 📊 Architecture Decisions

1. **Microservices Architecture** - Separate concerns for flight reservation and check-in
2. **Spring Boot** - Proven framework for scalable Java applications
3. **React** - Modern UI library for responsive frontend
4. **Kubernetes** - Container orchestration for production deployments
5. **Terraform** - IaC for reproducible infrastructure
6. **Jenkins** - Mature CI/CD platform

---

## 🔐 Security Considerations

- JWT token-based authentication
- Role-based access control (RBAC)
- CORS configuration for cross-origin requests
- SQL injection prevention with parameterized queries
- Password hashing with bcrypt
- HTTPS/TLS in production
- Environment variable management for sensitive credentials

---

**Last Updated:** March 2026  
**Version:** 1.0.0

