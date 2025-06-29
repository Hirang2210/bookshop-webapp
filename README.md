# 📚 BookShop Spring Boot Application

A simple online bookstore built with Spring Boot, supporting customer and admin functionality.

---

## 🛠 Features

- Admin: Add/edit/delete books
- Customer: Browse books, add to cart, place orders
- Cart management
- Connects to a MySQL database
- Spring Boot backend with JPA and Hibernate
- Thymeleaf-powered UI

## 🛠 Tech Stack

- **Backend**: Spring Boot, JPA, Hibernate
- **Frontend**: Thymeleaf, HTML/CSS
- **Database**: MySQL
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL 8.x

---

## 🔧 Setup Instructions and How to Run Locally

1. **Clone the repo**

   ```bash
   git clone https://github.com/Hirang2210/bookshop-webapp.git
   cd bookshop-webapp


2. **Set up MySQL**
Ensure MySQL server is running.
Create a database named bookshop_db.
Import bookshop_db.sql to populate it.

4. **Configure application properties**
In src/main/resources/application.properties, check that:
spring.datasource.url=jdbc:mysql://localhost:3306/bookshop_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

5. **Run the application**
Run BookShopApplication.java from your IDE

6. **Open the Browser and go to http://localhost:8080**

Screenshots:

**Landing Page:**
![image](https://github.com/user-attachments/assets/d6ca2e22-cf3b-4b40-b7fa-896e5f8e0c8b)

**Admin Login:**
![image](https://github.com/user-attachments/assets/bf07cd67-a024-4739-a2de-22546ba08f26)

**Admin Book Dashboard**
![image](https://github.com/user-attachments/assets/d99f13cc-e048-477a-9283-223d631829c7)

**Customer page**
![image](https://github.com/user-attachments/assets/4f7156c6-63e1-4f16-bd32-0f1e312f69ee)

**View cart and checkout page with credit card details**
![image](https://github.com/user-attachments/assets/0d12c9aa-22b0-4871-b6af-b1b57858e62e)

**Order confirmation**
![image](https://github.com/user-attachments/assets/8549e34c-9efa-4d0b-ae87-9e9811b654f5)

**New customer registration page**
![image](https://github.com/user-attachments/assets/a001ee45-3cfc-4d3c-b4a1-1bb36e16feac)


- Login credentials and user details 
- email 		&		password
- admin@bookshop.com	-	admin123
- customer@bookshop.com	-	customer123
- test@gmail.com       -	abc123
- sadhvi@test.com		-	abc123
- sadhvi@gmail.com 	-	abcde12345
