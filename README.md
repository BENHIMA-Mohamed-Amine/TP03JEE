# TP3JEEaa: Hospital Management Web Application (Spring Boot + Spring Security)

This is a practical Spring Boot web application developed as part of a university lab (TP). It allows managing patients using Spring MVC, Thymeleaf, Spring Data JPA, and Spring Security.

## 🛠 Technologies Used

- Java 17+
- Spring Boot 3.2
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- H2 Database (or any RDBMS)
- Maven

---

## ✅ Features Implemented

### 🧩 Part 1: Core CRUD (based on [YouTube Tutorial](https://www.youtube.com/watch?v=jDm-q-jEbiA))

- List all patients with pagination
- Search patients by keyword
- Delete patients
- Extra improvements and UI polishing

### 🧩 Part 2: Form Templates and Validation ([YouTube Tutorial](https://www.youtube.com/watch?v=eoBE745lDE0))

- Added form templates for adding/editing patients
- Implemented server-side validation with error feedback

### 🔐 Part 3: Security with Spring Security

1. **In-Memory Authentication**  
   Implemented as shown in [this tutorial](https://www.youtube.com/watch?v=7VqpC8UD1zM)

2. **JDBC Authentication**  
   Based on [this guide](https://www.youtube.com/watch?v=Haz3wLiQ5-0)

3. **UserDetailsService Implementation**  
   Custom implementation following [this tutorial](https://www.youtube.com/watch?v=RTiS9ygyYs4)

---

## 🔐 Sample Roles

- `user1` / `user2`: role `USER`
- `admin`: roles `USER`, `ADMIN`
> Default password for all: `1234` (BCrypt encoded)

---

## 🧪 How to Run

1. Clone the repo
2. Open in IntelliJ / Eclipse
3. Run `HospitalAppApplication.java`
4. Access the app at `http://localhost:8080`
5. 
---

## 📌 Notes

- Code is updated to work with Spring Boot 3.2
- Security configuration uses `SecurityFilterChain` instead of deprecated `WebSecurityConfigurerAdapter`

---

## 👨‍💻 BENHIMA Mohamed-amine

Student @ [ENSET Mohammedia](https://www.enset.ma/) 
TP Assignment for Web Development Course  
