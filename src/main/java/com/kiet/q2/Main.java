package com.kiet.q2;
import java.sql.SQLException; import java.util.Arrays;
public class Main {
 public static void main(String[] args){
  StudentManager m=new StudentManager();
  try{
   // Uncomment ONCE to add this sample. Change ID/email for additional records.
   // m.add(new Student(101,"Aarav Sharma","aarav@example.com","CSE",88,92,Arrays.asList("Java","SQL","Spring Boot")));
   System.out.println("\\nALL STUDENTS");m.all().forEach(System.out::println);
   System.out.println("\\nSEARCH BY ID");m.byId(101).forEach(System.out::println);
   System.out.println("\\nSEARCH BY EMAIL");m.byEmail("aarav@example.com").forEach(System.out::println);
   System.out.println("\\nSEARCH BY COURSE");m.byCourse("CSE").forEach(System.out::println);
   System.out.println("\\nMERIT LIST");m.meritList().forEach(System.out::println);
   System.out.println("\\nSTUDENTS GROUPED BY SAME SKILLS");m.sameSkills().forEach((k,v)->{if(v.size()>1)System.out.println(k+" => "+v);});
   System.out.println("\\nPROGRAMMING < 50 AND MATHS >= 75");m.programmingImprovement().forEach(System.out::println);
  }catch(SQLException e){System.out.println("Database error: "+e.getMessage());}
   catch(IllegalArgumentException e){System.out.println("Validation error: "+e.getMessage());}
 }
}