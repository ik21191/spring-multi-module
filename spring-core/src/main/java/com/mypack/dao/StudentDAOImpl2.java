package com.mypack.dao;

import com.mypack.dto.StudentDTO;
import org.springframework.stereotype.Repository;

@Repository("studentDao2")
public class StudentDAOImpl2 implements StudentDAO {

  public StudentDAOImpl2() {
    System.out.println("Constructor StudentDAOImpl2 called..................");
  }

  public StudentDTO createNewStudent() {
    System.out.println("StudentDAOImpl2 called.....");
    StudentDTO student = new StudentDTO();
    student.setId(101);
    student.setFirstName("Rakesh");
    student.setLastName("Kumar");
    return student;
  }
}
