# Flight Reservation System - Frontend

A modern, responsive React-based frontend application for the Flight Reservation & Check-In system, built with Vite for fast development and production-grade performance.

---

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Available Scripts](#available-scripts)
- [Components Overview](#components-overview)
- [State Management](#state-management)
- [API Integration](#api-integration)
- [Styling & Design](#styling--design)
- [Deployment](#deployment)
- [Building for Production](#building-for-production)
- [Docker Support](#docker-support)
- [Troubleshooting](#troubleshooting)

---

## 🎯 Project Overview

This is the **user-facing frontend** of the Flight Reservation & Check-In application. It provides an intuitive, responsive interface for customers to search flights, make bookings, manage their reservations, and check in for flights. The application also includes an admin dashboard for managing flights and bookings.

### Key Features:
- **Responsive Design** - Mobile-first, works on all devices
- **Fast Performance** - Built with Vite for instant HMR
- **Modern UI** - Clean, user-friendly interface with Boxicons
- **State Management** - Redux Toolkit for centralized state
- **Real-time Notifications** - Toast notifications for user feedback
- **Routing** - Smooth navigation with React Router v7
- **API Integration** - Axios for efficient API calls

---

## ✨ Features

### User Features
- **Authentication**
  - User registration with email
  - Secure login/logout
  - JWT token management
  - Password reset functionality

- **Flight Search & Discovery**
  - Advanced flight search by origin, destination, and date
  - Real-time flight availability
  - Filter by price, departure time, duration
  - Sort by price, duration, or airline

- **Booking Management**
  - Easy one-click booking
  - Multiple passenger support
  - Seat selection during booking
  - Booking confirmation with details
  - View booking history
  - Cancel/modify bookings

- **Flight Check-In**
  - Online check-in 24 hours before departure
  - Seat selection/change
  - Boarding pass generation and download
  - Real-time check-in status

- **Payment Processing**
  - Secure payment gateway
  - Multiple payment methods
  - Payment confirmation
  - Invoice generation

- **Profile Management**
  - View and edit user profile
  - Update contact information
  - Saved preferences
  - View travel history

### Admin Features
- **Flight Management**
  - Add new flights
  - Edit flight details
  - Manage flight schedules
  - Update pricing

- **Admin Dashboard**
  - Overview of all bookings
  - Check-in statistics
  - Revenue analytics
  - User management

- **User Management**
  - View all users
  - Manage user roles
  - Deactivate/activate accounts

---

## 🛠️ Technology Stack

### Core
- **React 19.0.0** - Modern UI library
- **Vite** - Fast build tool and dev server
- **Node.js 18+** - JavaScript runtime
- **npm 9+** - Package manager

### State Management
- **Redux Toolkit 2.5.1** - Centralized state management
- **React-Redux 9.2.0** - React bindings for Redux

### Routing & Navigation
- **React Router 7.2.0** - Client-side routing

### HTTP & API
- **Axios 1.7.9** - HTTP client for API calls

### UI & Icons
- **Boxicons 2.1.4** - Icon library
- **CSS3** - Modern styling with flexbox and grid

### Notifications
- **React Toastify 11.0.3** - Toast notifications

### Development Tools
- **ESLint** - Code quality and style
- **Vite Config** - Fast dev server with HMR

### Testing
- **Jest** - Unit testing framework (can be added)
- **React Testing Library** - Component testing

---

## 📁 Project Structure

```
frontend/
├── src/
│   ├── Components/                    # React Components
│   │   ├── Home.jsx                  # Landing page
│   │   ├── Header.jsx                # Navigation header
│   │   ├── Footer.jsx                # Footer component
│   │   ├── Login.jsx                 # User login page
│   │   ├── Register.jsx              # User registration page
│   │   ├── Authenticate.jsx          # Auth wrapper
│   │   ├── AdminAuthenticate.jsx     # Admin auth wrapper
│   │   ├── Profile.jsx               # User profile page
│   │   ├── Update.jsx                # Profile update
│   │   ├── Flights.jsx               # Flight listing
│   │   ├── FlightSearch.jsx          # Flight search component
│   │   ├── Booking.jsx               # Booking management
│   │   ├── BookingList.jsx           # View bookings
│   │   ├── CheckIn.jsx               # Check-in interface
│   │   ├── CheckInDashboard.jsx      # Check-in dashboard
│   │   ├── CheckInDone.jsx           # Check-in confirmation
│   │   ├── Payment.jsx               # Payment processing
│   │   ├── Admin.jsx                 # Admin dashboard
│   │   ├── AdminProfile.jsx          # Admin profile
│   │   ├── AddFlight.jsx             # Add flight (Admin)
│   │   ├── AddAdmin.jsx              # Add admin user
│   │   ├── ViewFlightsList.jsx       # View all flights
│   │   ├── ViewadminList.jsx         # View admins
│   │   └── Contact.jsx               # Contact page
│   ├── Redux-config/                  # Redux Store Configuration
│   │   ├── store.js                  # Redux store setup
│   │   └── UserSlice.js              # Redux user slice
│   ├── api.js                        # API endpoints configuration
│   ├── App.jsx                       # Main App component
│   ├── main.jsx                      # Application entry point
│   ├── App.css                       # App styles
│   ├── index.css                     # Global styles
│   ├── reportWebVitals.js            # Performance metrics
│   ├── assets/                       # Images and assets
│   └── image/                        # Image resources
├── public/
│   ├── index.html                    # HTML entry point
│   ├── robots.txt                    # SEO robots file
│   ├── Css/
│   │   └── style.css                 # Global stylesheets
│   └── Images/                       # Static images
├── package.json                      # NPM dependencies
├── package-lock.json                 # Dependency lock file
├── vite.config.js                    # Vite configuration
├── eslint.config.js                  # ESLint configuration
├── .env                              # Environment variables
├── .gitignore                        # Git ignore rules
├── Dockerfile                        # Docker container definition
├── Jenkinsfile                       # Jenkins pipeline
├── JenkinsPipeline.md               # Jenkins setup docs
├── index.html                        # HTML template
└── README.md                         # This file
```

---

## 📋 Prerequisites

- **Node.js 18+** - JavaScript runtime
- **npm 9+** - Package manager
- **Git** - Version control
- **Modern Browser** - Chrome, Firefox, Safari, or Edge

### Backend Services Required
- Flight Reservation Service (Port 8080)
- Flight Check-In Service (Port 8081)

---

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone <repository-url>
cd flight-reservation-app-main/frontend
```

### 2. Install Dependencies

```bash
npm install
```

This will install all dependencies listed in `package.json`:
- React and React DOM
- Vite and build tools
- Redux and state management
- React Router for navigation
- Axios for API calls
- And other required packages

### 3. Verify Installation

```bash
npm -v    # Check npm version
node -v   # Check Node.js version
```

---

## ⚙️ Configuration

### Environment Variables

Create a `.env` file in the frontend directory:

```env
# API Configuration
VITE_API_BASE_URL=http://localhost:8080/api
VITE_CHECKIN_API_URL=http://localhost:8081/api

# Application Settings
VITE_APP_NAME=Flight Reservation System
VITE_APP_VERSION=1.0.0

# Feature Flags
VITE_ENABLE_ANALYTICS=true
VITE_ENABLE_NOTIFICATIONS=true
```

### API Configuration

Update `src/api.js`:

```javascript
const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api';
const CHECKIN_API_URL = import.meta.env.VITE_CHECKIN_API_URL || 'http://localhost:8081/api';

export const API_ENDPOINTS = {
  AUTH: {
    LOGIN: `${API_BASE_URL}/auth/login`,
    REGISTER: `${API_BASE_URL}/auth/register`,
    LOGOUT: `${API_BASE_URL}/auth/logout`,
  },
  FLIGHTS: {
    LIST: `${API_BASE_URL}/flights`,
    SEARCH: `${API_BASE_URL}/flights/search`,
    GET_BY_ID: (id) => `${API_BASE_URL}/flights/${id}`,
  },
  BOOKINGS: {
    LIST: `${API_BASE_URL}/bookings`,
    CREATE: `${API_BASE_URL}/bookings`,
    GET_BY_ID: (id) => `${API_BASE_URL}/bookings/${id}`,
    UPDATE: (id) => `${API_BASE_URL}/bookings/${id}`,
    CANCEL: (id) => `${API_BASE_URL}/bookings/${id}/cancel`,
  },
  CHECKIN: {
    STATUS: (bookingId) => `${CHECKIN_API_URL}/checkin/${bookingId}`,
    CHECK_IN: `${CHECKIN_API_URL}/checkin`,
    BOARDING_PASS: (checkInId) => `${CHECKIN_API_URL}/boarding-pass/${checkInId}`,
  },
};
```

---

## 🏃 Running the Application

### Development Mode

```bash
npm run dev
```

The application will start on `http://localhost:5173` (default Vite port).

Features in development mode:
- **HMR (Hot Module Replacement)** - Auto-refresh on code changes
- **Source Maps** - Easy debugging
- **Fast Refresh** - Preserves component state

### Preview Production Build

```bash
npm run build
npm run preview
```

---

## 📝 Available Scripts

```bash
# Start development server with HMR
npm run dev

# Build for production
npm run build

# Preview production build
npm run preview

# Run ESLint for code quality
npm run lint

# Fix ESLint issues
npm run lint --fix
```

---

## 🧩 Components Overview

### Core Components

#### Home.jsx
- Landing page with flight search widget
- Featured flights display
- Call-to-action buttons

#### Header.jsx & Footer.jsx
- Navigation bar with user menu
- Links to all major sections
- Authentication status display

#### FlightSearch.jsx
```jsx
// Search flights by origin, destination, date
<FlightSearch 
  onSearch={handleSearch}
  flights={filteredFlights}
/>
```

#### Booking.jsx
- Flight details display
- Passenger information form
- Seat selection
- Price breakdown

#### CheckIn.jsx
- Booking verification
- Seat selection/change
- Boarding pass generation
- Download/print options

#### Admin.jsx
- Admin dashboard
- Statistics and analytics
- User management
- Flight management

#### Payment.jsx
- Payment form
- Multiple payment methods
- Payment confirmation

---

## 📊 State Management

### Redux Store Structure

```javascript
// store.js
import { configureStore } from '@reduxjs/toolkit';
import UserSlice from './UserSlice';

export const store = configureStore({
  reducer: {
    user: UserSlice,
  },
});

export default store;
```

### UserSlice.js

```javascript
// Redux slice for user state
// Actions:
// - setUser(userData)
// - logout()
// - updateProfile(profileData)
// - setBookings(bookingsArray)
// - setFlights(flightsArray)
```

### Usage in Components

```javascript
import { useSelector, useDispatch } from 'react-redux';

function MyComponent() {
  const dispatch = useDispatch();
  const user = useSelector(state => state.user.user);
  const bookings = useSelector(state => state.user.bookings);
  
  // Use user and bookings data
}
```

---

## 🔌 API Integration

### Using Axios

```javascript
import axios from 'axios';
import { API_ENDPOINTS } from './api';

// Create API instance
const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Add authorization token to requests
apiClient.interceptors.request.use(config => {
  const token = localStorage.getItem('authToken');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// Example API call
const searchFlights = async (searchParams) => {
  try {
    const response = await apiClient.get(API_ENDPOINTS.FLIGHTS.SEARCH, {
      params: searchParams,
    });
    return response.data;
  } catch (error) {
    console.error('Error searching flights:', error);
    throw error;
  }
};
```

### Handling Responses

```javascript
// Successful response
if (response.status === 200) {
  const data = response.data;
  // Handle data
}

// Error handling
catch (error) {
  if (error.response?.status === 401) {
    // Unauthorized - redirect to login
  } else if (error.response?.status === 400) {
    // Bad request - show validation errors
  } else {
    // Server error
  }
}
```

---

## 🎨 Styling & Design

### CSS Organization

```
public/
├── Css/
│   └── style.css          # Global styles

src/
├── App.css                # App component styles
├── index.css              # Global index styles
└── Components/
    ├── Home.css          # Component-specific styles
    ├── Login.css
    └── ...
```

### Using Boxicons

```jsx
import { BiSearch, BiUser, BiLogOut } from 'boxicons-react';

function Header() {
  return (
    <div>
      <BiSearch size="24" />
      <BiUser size="24" />
      <BiLogOut size="24" />
    </div>
  );
}
```

### Responsive Design with CSS

```css
/* Mobile First */
.container {
  padding: 1rem;
}

/* Tablet */
@media (min-width: 768px) {
  .container {
    padding: 2rem;
  }
}

/* Desktop */
@media (min-width: 1024px) {
  .container {
    max-width: 1200px;
  }
}
```

---

## 🐳 Docker Support

### Build Docker Image

```bash
# Build production image
docker build -t flight-frontend:latest .
```

### Run Container

```bash
docker run -d \
  --name flight-frontend \
  -p 3000:3000 \
  -e VITE_API_BASE_URL=http://localhost:8080/api \
  flight-frontend:latest
```

### Docker Compose

```yaml
frontend:
  build:
    context: ./frontend
    dockerfile: Dockerfile
  ports:
    - "3000:3000"
  environment:
    - VITE_API_BASE_URL=http://flight-reservation-app:8080/api
    - VITE_CHECKIN_API_URL=http://flight-checkin-app:8081/api
  depends_on:
    - flight-reservation-app
    - flight-checkin-app
```

---

## 🚀 Building for Production

### Build Optimized Bundle

```bash
npm run build
```

This creates:
- `dist/` folder with optimized production files
- Minified JavaScript and CSS
- Hashed filenames for cache busting
- Source maps for debugging (optional)

### Deployment Steps

1. Build the application: `npm run build`
2. Upload `dist/` folder to your server
3. Configure web server (Nginx, Apache) to serve SPA
4. Set up environment variables on production server

---

## 🔧 Troubleshooting

### Common Issues

**1. Port 5173 already in use:**
```bash
npm run dev -- --port 3000
```

**2. Cannot connect to backend API:**
- Verify backend services are running
- Check `VITE_API_BASE_URL` in `.env`
- Check CORS configuration on backend
- Open browser DevTools → Network tab to see requests

**3. Redux state not updating:**
```javascript
// Make sure to dispatch actions
import { setUser } from './Redux-config/UserSlice';
dispatch(setUser(userData));
```

**4. ESLint errors:**
```bash
npm run lint --fix
```

---

## 📦 Dependencies

### Production Dependencies
```json
{
  "@reduxjs/toolkit": "^2.5.1",
  "axios": "^1.7.9",
  "boxicons": "^2.1.4",
  "react": "^19.0.0",
  "react-dom": "^19.0.0",
  "react-redux": "^9.2.0",
  "react-router-dom": "^7.2.0",
  "react-toastify": "^11.0.3"
}
```

### Development Dependencies
```json
{
  "@vitejs/plugin-react": "^4.0.0",
  "eslint": "^8.0.0",
  "vite": "^4.0.0"
}
```

---

## 🔐 Security Best Practices

- Store authentication tokens securely in localStorage or cookies
- Validate all user inputs before submission
- Use HTTPS in production
- Implement CORS properly on backend
- Never commit sensitive credentials in `.env` file
- Use `.env.example` template for configuration
- Sanitize HTML content to prevent XSS attacks
- Implement CSRF protection for forms

---

## 📚 Additional Resources

- [Vite Documentation](https://vitejs.dev/)
- [React Documentation](https://react.dev/)
- [Redux Toolkit Guide](https://redux-toolkit.js.org/)
- [React Router Documentation](https://reactrouter.com/)
- [Axios Documentation](https://axios-http.com/)

---

## 🤝 Contributing

1. Create a feature branch: `git checkout -b feature/new-feature`
2. Make your changes
3. Run ESLint: `npm run lint --fix`
4. Commit: `git commit -m 'Add new feature'`
5. Push: `git push origin feature/new-feature`
6. Create a Pull Request

---

**Last Updated:** March 2026  
**Version:** 1.0.0
