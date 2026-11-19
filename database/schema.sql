CREATE DATABASE IF NOT EXISTS student_profile_db;
USE student_profile_db;
CREATE TABLE IF NOT EXISTS students (
 student_id INT PRIMARY KEY, student_name VARCHAR(100) NOT NULL,
 email VARCHAR(150) NOT NULL UNIQUE, course_name VARCHAR(80) NOT NULL,
 programming_score DECIMAL(5,2) NOT NULL,
 mathematics_score DECIMAL(5,2) NOT NULL,
 CHECK (programming_score BETWEEN 0 AND 100),
 CHECK (mathematics_score BETWEEN 0 AND 100)
);
CREATE TABLE IF NOT EXISTS student_skills (
 student_id INT NOT NULL, skill VARCHAR(80) NOT NULL,
 PRIMARY KEY(student_id, skill),
 FOREIGN KEY(student_id) REFERENCES students(student_id) ON DELETE CASCADE
);