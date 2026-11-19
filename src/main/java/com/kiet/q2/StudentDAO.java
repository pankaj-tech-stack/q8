package com.kiet.q2;
import java.sql.*; import java.util.*;
public class StudentDAO {
 private final String url="jdbc:mysql://localhost:3306/student_profile_db";
 private final String username="root";
 private final String password="YOUR_MYSQL_PASSWORD"; // Replace this
 private Connection connect() throws SQLException{return DriverManager.getConnection(url,username,password);}
 public void addStudent(Student s)throws SQLException{
  String sql="INSERT INTO students VALUES(?,?,?,?,?,?)";
  try(Connection c=connect();PreparedStatement p=c.prepareStatement(sql)){
   p.setInt(1,s.getStudentId());p.setString(2,s.getStudentName());p.setString(3,s.getEmail());p.setString(4,s.getCourseName());p.setDouble(5,s.getProgrammingScore());p.setDouble(6,s.getMathematicsScore());p.executeUpdate();
   try(PreparedStatement skill=c.prepareStatement("INSERT INTO student_skills VALUES(?,?)")){
    for(String x:s.getTechnicalSkills()){skill.setInt(1,s.getStudentId());skill.setString(2,x);skill.addBatch();}skill.executeBatch();
   }
  }
 }
 public List<Student> findAll()throws SQLException{
  List<Student> out=new ArrayList<>();
  try(Connection c=connect();PreparedStatement p=c.prepareStatement("SELECT * FROM students");ResultSet r=p.executeQuery()){
   while(r.next()){int id=r.getInt("student_id");List<String> skills=new ArrayList<>();
    try(PreparedStatement sp=c.prepareStatement("SELECT skill FROM student_skills WHERE student_id=?")){sp.setInt(1,id);try(ResultSet sr=sp.executeQuery()){while(sr.next())skills.add(sr.getString(1));}}
    out.add(new Student(id,r.getString("student_name"),r.getString("email"),r.getString("course_name"),r.getDouble("programming_score"),r.getDouble("mathematics_score"),skills));
   }
  }return out;
 }
}