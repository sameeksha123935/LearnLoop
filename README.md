# 🎓 LearnLoop — Interactive Learning Platform

LearnLoop is a full-stack web application designed to make learning interactive and fun!  
It combines tutorials, quizzes, and notes with a clean interface and a connected backend powered by Spring Boot and MySQL.

---

## 🚀 Features

### 🌐 Frontend (HTML, CSS, JS)
- User-friendly responsive design  
- Signup & Login pages connected to backend  
- Practice quizzes with instant feedback  
- Auto-calculated and stored quiz scores  
- Sections for tutorials, notes, about, and contact  

### ⚙️ Backend (Spring Boot + MySQL)
- REST APIs for:
  - User signup/login  
  - Quiz score management  
- MySQL database integration  
- CORS enabled for frontend connection  
- Deployed locally on `http://localhost:8080`

---

## 🧩 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Frontend** | HTML, CSS, JavaScript |
| **Backend** | Spring Boot (Java) |
| **Database** | MySQL |
| **Tools** | IntelliJ IDEA / VS Code, Postman, Git & GitHub |

---

## 🗄️ Database Structure

### `user` Table
| Column | Type | Description |
|---------|------|-------------|
| `id` | INT | Primary Key |
| `name` | VARCHAR | User's name |
| `email` | VARCHAR | Unique user email |
| `password` | VARCHAR | Encrypted password |

### `quiz_score` Table
| Column | Type | Description |
|---------|------|-------------|
| `id` | INT | Primary Key |
| `username` | VARCHAR | User who took the quiz |
| `score` | INT | Quiz score |

---

## 🧠 API Endpoints

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `POST` | `/api/users/signup` | Register a new user |
| `POST` | `/api/users/login` | Login existing user |
| `GET` | `/api/users` | Fetch all users |
| `POST` | `/api/quiz/submit` | Submit and store quiz score |
| `GET` | `/api/quiz/scores` | Get all quiz scores |

---

## 🧰 Setup Instructions

### 🔹 Prerequisites
- Java 17 or above  
- MySQL installed & running  
- Node.js (optional, for frontend live server)  
- Git

### 🔹 Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/<your-username>/learnloop.git
   cd learnloop
   
2.Database Setup
CREATE DATABASE learnloop;
USE learnloop;

3.Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/learnloop
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

4.Run the Backend
mvn spring-boot:run

5.Run the Frontend
Open frontend/index.html in your browser
