package com.kiet.q2;
import java.sql.SQLException; import java.util.*; import java.util.stream.Collectors;
public class StudentManager {
 private final StudentDAO dao=new StudentDAO();
 public void add(Student s)throws SQLException{for(Student x:dao.findAll())if(x.getStudentId()==s.getStudentId())throw new IllegalArgumentException("Duplicate student ID");dao.addStudent(s);}
 public List<Student> all()throws SQLException{return dao.findAll();}
 public List<Student> byId(int id)throws SQLException{return dao.findAll().stream().filter(s->s.getStudentId()==id).collect(Collectors.toList());}
 public List<Student> byEmail(String email)throws SQLException{return dao.findAll().stream().filter(s->s.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());}
 public List<Student> byCourse(String course)throws SQLException{return dao.findAll().stream().filter(s->s.getCourseName().equalsIgnoreCase(course)).collect(Collectors.toList());}
 public List<Student> meritList()throws SQLException{return dao.findAll().stream().sorted(Comparator.comparingDouble(Student::average).reversed()).collect(Collectors.toList());}
 public Map<Set<String>,List<Student>> sameSkills()throws SQLException{return dao.findAll().stream().collect(Collectors.groupingBy(s->new TreeSet<>(s.getTechnicalSkills())));}
 public List<Student> programmingImprovement()throws SQLException{return dao.findAll().stream().filter(s->s.getProgrammingScore()<50&&s.getMathematicsScore()>=75).collect(Collectors.toList());}
}