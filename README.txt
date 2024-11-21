# Capstone Project - Bus Booking System

This project is a **Bus Booking System** built with **Spring Boot**, which allows users to book bus tickets, search for buses, view their bookings, and provide feedback. Admin users can manage buses, view all bookings, and handle other administrative tasks. The system also integrates email functionality with **PDF attachments** for booking confirmation.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Getting Started](#getting-started)
5. [Running the Application Locally](#running-the-application-locally)
6. [API Endpoints](#api-endpoints)
7. [Swagger UI Documentation](#swagger-ui-documentation)
8. [Email and PDF Integration](#email-and-pdf-integration)
9. [Deployment](#deployment)
10. [Contributing](#contributing)
11. [License](#license)

---

## Project Overview

The **Bus Booking System** allows users to:

- Register an account and log in to their personalized dashboard.
- Search for buses based on the source, destination, and travel date.
- Book bus tickets and view their booking details.
- Cancel bookings and view all past bookings.
- Provide feedback on buses and services.

Admins have the ability to manage bus listings, view all user bookings, and perform administrative tasks.

---

## Features

### User Features:

- **User Registration & Login**: 
  - Users can register and create an account using their email and password.
  - After registration, users can log in to their dashboard.
  
- **Search for Buses**: 
  - Users can search for buses based on the source, destination, and travel date.
  - The search results will display available buses matching the search criteria.

- **Book a Ticket**: 
  - Once a bus is selected, users can book tickets by providing details like the number of passengers.
  - Users are redirected to the payment page after successful booking.

- **View Bookings**: 
  - Users can view a list of their past bookings.
  - Each booking shows the bus details, travel date, and number of passengers.

- **Cancel Booking**: 
  - Users can cancel an existing booking.

- **Provide Feedback**: 
  - Users can provide feedback on the bus service they used.

### Admin Features:

- **Manage Buses**: 
  - Admins can view, add, update, or delete buses from the system.
  
- **View All Bookings**: 
  - Admins can view the details of all user bookings.
  
- **Manage Users**: 
  - Admins can view user details and manage their accounts.

### Email and PDF Integration:

- **Booking Confirmation**: 
  - After a successful booking, users receive a confirmation email with a PDF attachment of their booking details.
  
- **PDF Ticket Generation**: 
  - A PDF file containing booking information (bus details, travel date, number of passengers, etc.) is generated and attached to the confirmation email.

---

## Technologies Used

- **Spring Boot**: The main framework for building the application.
- **Spring Security**: For user authentication and role-based authorization.
- **Thymeleaf**: Template engine for rendering dynamic HTML views.
- **Spring Data JPA**: Provides ORM capabilities for database interactions.
- **H2 Database**: In-memory database used for testing.
- **JavaMail**: For email functionality (sending confirmation emails).
- **iText PDF**: Used for generating PDF documents (ticket attachments).
- **Swagger**: API documentation and testing.
- **Maven/Gradle**: Build tools for dependency management and project build lifecycle.

---

## Getting Started

### Prerequisites

Before you can run this project locally, ensure you have the following installed:

- **Java 17** or above
- **Maven** or **Gradle**
- An IDE like IntelliJ IDEA or Eclipse (optional but recommended)
- **Docker** (for containerized deployment)

### Cloning the Repository

To get started, first clone the repository to your local machine:

```bash
git clone https://github.com/JAYASURYAJSP03/capstone_project_deploy.git
cd capstone_project_deploy/capstone_project




site live at  =>     https://capstone-project-deploy-5skj.onrender.com/login
 




