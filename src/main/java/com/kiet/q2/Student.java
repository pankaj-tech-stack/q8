package com.kiet.q2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String course;
    private int programmingScore;
    private int mathsScore;
    private List<String> skills = new ArrayList<>();

    public Student(int studentId, String name, String email, String course,
                   int programmingScore, int mathsScore, List<String> skills) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.course = course;
        setProgrammingScore(programmingScore);
        setMathsScore(mathsScore);
        this.skills = skills == null ? new ArrayList<>() : new ArrayList<>(skills);
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public int getProgrammingScore() { return programmingScore; }
    public int getMathsScore() { return mathsScore; }
    public List<String> getSkills() { return new ArrayList<>(skills); }

    public void setProgrammingScore(int score) {
        validateScore(score);
        this.programmingScore = score;
    }

    public void setMathsScore(int score) {
        validateScore(score);
        this.mathsScore = score;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills == null ? new ArrayList<>() : new ArrayList<>(skills);
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
    }

    public double getAverage() {
        return (programmingScore + mathsScore) / 2.0;
    }

    public String getCategory() {
        double average = getAverage();
        if (average >= 90) return "Excellent";
        if (average >= 75) return "Very Good";
        if (average >= 60) return "Good";
        if (average >= 40) return "Average";
        return "Needs Improvement";
    }

    public String getStrongerSubject() {
        if (programmingScore > mathsScore) return "Programming";
        if (mathsScore > programmingScore) return "Mathematics";
        return "Both equally strong";
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name='" + name + '\'' +
                ", email='" + email + '\'' + ", course='" + course + '\'' +
                ", programmingScore=" + programmingScore + ", mathsScore=" + mathsScore +
                ", average=" + getAverage() + ", category='" + getCategory() + '\'' +
                ", skills=" + skills + '}';
    }
}
