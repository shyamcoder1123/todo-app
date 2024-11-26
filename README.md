# Backend Todo Application

This is Backend of a Full-Stack Todo Application built with the following technologies:
- **Frontend**: React.js
- **Backend**: Spring Boot
- **Database**: MySQL

The application allows users to manage their tasks by performing actions such as:
- Adding, Editing, Deleting Todos
- Marking Todos as Pending or Completed
- Exporting Project Summary as an MD File
- User authentication with Spring Security

## Features
- **Frontend** (React):
  - Responsive UI for adding, updating, and deleting Todos
  - Mark Todos as pending or completed
  - View project summary and export it as a markdown file
- **Backend** (Spring Boot):
  - RESTful API for managing Todos
  - Basic user authentication with Spring Security
  - Project summary export functionality in markdown format
  - MySQL database to store Todo data

## Prerequisites

Before running the project, make sure you have the following installed:

- **Node.js** (version 14 or later) - For running the React frontend
- **npm** (comes with Node.js) - For managing frontend dependencies
- **Java 11 or later** - For running the Spring Boot backend
- **Maven** (or Gradle) - For building and running the Spring Boot application
- **MySQL** - For the database (if not using an alternative like PostgreSQL)

## Backend Setup (Spring Boot)

### 1. Clone the Repository

Clone the backend repository to your local machine:

```bash
git clone https://github.com/your-username/todo-backend.git
