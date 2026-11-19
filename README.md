# Student Profile and Skill Development Management System

A Java JDBC + MySQL console application for managing student profiles, academic scores, and technical skills.

## Tech stack
- Java
- JDBC
- MySQL
- Maven

## Setup
1. Create the database and tables by running `database/schema.sql` in MySQL.
2. Open this repository as a Maven project in IntelliJ IDEA.
3. In `StudentDAO.java`, replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.
4. Reload Maven dependencies.
5. Run `com.kiet.q2.Main`.

## Features
- Add and retrieve students
- Store and manage student skills
- Calculate averages and student categories
- Compare programming and mathematics scores
- Search by ID, email, or course
- Generate merit lists and group students by skills
- Validate score ranges and prevent duplicate student IDs

## Database
The SQL schema is in `database/schema.sql`.

> This project is an academic demonstration. Do not commit real database credentials.