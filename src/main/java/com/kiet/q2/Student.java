package com.kiet.q2;
import java.util.*;
public class Student {
 private int studentId; private String studentName,email,courseName;
 private double programmingScore,mathematicsScore; private List<String> technicalSkills;
 public Student(int id,String name,String email,String course,double programming,double maths,List<String> skills){
  if(id<=0) throw new IllegalArgumentException("Student ID must be positive");
  validate(programming); validate(maths);
  this.studentId=id; this.studentName=name; this.email=email; this.courseName=course;
  this.programmingScore=programming; this.mathematicsScore=maths;
  this.technicalSkills=new ArrayList<>(skills);
 }
 private void validate(double score){if(score<0||score>100)throw new IllegalArgumentException("Scores must be between 0 and 100");}
 public int getStudentId(){return studentId;} public String getStudentName(){return studentName;}
 public String getEmail(){return email;} public String getCourseName(){return courseName;}
 public double getProgrammingScore(){return programmingScore;} public double getMathematicsScore(){return mathematicsScore;}
 public List<String> getTechnicalSkills(){return new ArrayList<>(technicalSkills);}
 public double average(){return (programmingScore+mathematicsScore)/2.0;}
 public String category(){double a=average();if(a>=85)return "Excellent";if(a>=70)return "Good";if(a>=50)return "Satisfactory";return "Needs Improvement";}
 public String strongerSubject(){if(programmingScore>mathematicsScore)return "Programming";if(mathematicsScore>programmingScore)return "Mathematics";return "Both are equal";}
 public String toString(){return "ID:"+studentId+" | "+studentName+" | "+email+" | "+courseName+" | Programming:"+programmingScore+" | Maths:"+mathematicsScore+" | Average:"+average()+" | "+category()+" | Stronger:"+strongerSubject()+" | Skills:"+technicalSkills;}
}