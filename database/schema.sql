CREATE DATABASE IF NOT EXISTS student_profile_db;
USE student_profile_db;

CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    course VARCHAR(50) NOT NULL,
    programming_score INT NOT NULL CHECK (programming_score BETWEEN 0 AND 100),
    maths_score INT NOT NULL CHECK (maths_score BETWEEN 0 AND 100)
);

CREATE TABLE IF NOT EXISTS student_skills (
    student_id INT NOT NULL,
    skill VARCHAR(100) NOT NULL,
    PRIMARY KEY (student_id, skill),
    CONSTRAINT fk_student_skills_student FOREIGN KEY (student_id)
        REFERENCES students(student_id) ON DELETE CASCADE
);
