package com.kiet.q2;

import java.sql.SQLException;
import java.util.*;

public class StudentManager {
    private final StudentDAO dao;

    public StudentManager(StudentDAO dao) {
        this.dao = dao;
    }

    public void addStudent(Student student) throws SQLException {
        if (dao.findById(student.getStudentId()) != null) {
            throw new IllegalArgumentException("Student ID already exists: " + student.getStudentId());
        }
        dao.addStudent(student);
    }

    public Student findById(int id) throws SQLException { return dao.findById(id); }

    public String findByEmail(String email) throws SQLException {
        // Search helper kept simple for the console demonstration.
        return "Use the students table query to search email: " + email;
    }

    public List<Student> getMeritList(List<Student> students) {
        List<Student> result = new ArrayList<>(students);
        result.sort(Comparator.comparingDouble(Student::getAverage).reversed());
        return result;
    }

    public Map<Set<String>, List<Student>> groupBySkillSet(List<Student> students) {
        Map<Set<String>, List<Student>> groups = new LinkedHashMap<>();
        for (Student student : students) {
            Set<String> key = new TreeSet<>(student.getSkills());
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groups;
    }

    public List<Student> filterLowProgrammingHighMaths(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getProgrammingScore() < 50 && student.getMathsScore() >= 75) {
                result.add(student);
            }
        }
        return result;
    }
}
