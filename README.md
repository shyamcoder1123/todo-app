# Backend Todo Application

This is Backend of a Todo Application built with the following technologies:
- **Backend**: Spring Boot
- **Database**: MySQL or any SQL database

- **Backend** (Spring Boot):
  - RESTful API for managing Projects, and Todos
  - Basic user authentication with Spring Security
  - Project summary export functionality in markdown format
  - MySQL database to store Todo data

## Prerequisites

Before running the project, make sure you have the following installed:
- **Java 11 or later** - For running the Spring Boot backend
- **Maven** (or Gradle) - For building and running the Spring Boot application
- **MySQL** - For the database (if not using an alternative like PostgreSQL, Oracle)

## Backend Setup (Spring Boot)

### 1. Clone the Repository

Clone the backend repository to your local machine:


git clone https://github.com/your-username/todo-backend.git

cd todo-backend


### 1.2 Configure MySQL Database in `application.properties`

Configure the MySQL database in the `src/main/resources/application.properties` file:

```properties
spring.application.name=Todo
spring.datasource.url=jdbc:mysql://localhost:3306/todo_app
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update


