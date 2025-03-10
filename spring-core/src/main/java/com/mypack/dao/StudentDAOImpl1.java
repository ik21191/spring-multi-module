package com.mypack.dao;

import org.springframework.stereotype.Repository;

import com.mypack.dto.StudentDTO;

@Repository("studentDao1")
public class StudentDAOImpl1 implements StudentDAO {

  public StudentDAOImpl1() {
    System.out.println("Constructor StudentDAOImpl1 called..................");
  }

  public StudentDTO createNewStudent() {
    System.out.println("StudentDAOImpl called");
    StudentDTO student = new StudentDTO();
    student.setId(101);
    student.setFirstName("Imran");
    student.setLastName("Khan");
    return student;
  }
}