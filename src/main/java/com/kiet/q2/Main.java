package com.kiet.q2;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        StudentManager manager = new StudentManager(dao);

        try {
            System.out.println("Student Profile and Skill Development Management System");
            System.out.println("-----------------------------------------------");
            Student student = manager.findById(101);
            if (student != null) {
                System.out.println("Student found:");
                System.out.println(student);
            } else {
                System.out.println("No student with ID 101 found. Add a student first.");
            }
        } catch (SQLException e) {
            System.err.println("Database operation failed: " + e.getMessage());
            System.err.println("Check MySQL is running, schema is created, and credentials in StudentDAO are correct.");
        }
    }
}
