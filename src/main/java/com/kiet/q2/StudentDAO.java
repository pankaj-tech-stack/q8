package com.kiet.q2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/student_profile_db";
    private final String username = "root";
    private final String password = "YOUR_MYSQL_PASSWORD"; // Replace with your local MySQL password.

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (student_id, name, email, course, programming_score, maths_score) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getProgrammingScore());
            ps.setInt(6, student.getMathsScore());
            ps.executeUpdate();
        }
        saveSkills(student.getStudentId(), student.getSkills());
    }

    private void saveSkills(int studentId, List<String> skills) throws SQLException {
        String sql = "INSERT INTO student_skills (student_id, skill) VALUES (?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            for (String skill : skills) {
                ps.setInt(1, studentId);
                ps.setString(2, skill);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    public Student findById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                Student student = new Student(rs.getInt("student_id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("course"),
                        rs.getInt("programming_score"), rs.getInt("maths_score"), getSkills(id));
                return student;
            }
        }
    }

    public List<String> getSkills(int studentId) throws SQLException {
        List<String> skills = new ArrayList<>();
        String sql = "SELECT skill FROM student_skills WHERE student_id = ? ORDER BY skill";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) skills.add(rs.getString("skill"));
            }
        }
        return skills;
    }
}
