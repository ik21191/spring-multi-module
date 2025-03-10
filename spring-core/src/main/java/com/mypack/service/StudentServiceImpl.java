package com.mypack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mypack.dao.StudentDAO;
import com.mypack.dto.StudentDTO;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

  public StudentServiceImpl() {
    System.out.println("Constructor StudentServiceImpl called..............");
  }

  @Autowired
  @Qualifier("studentDao1")//This Annotation is used when more than one implementation of an interface is given
  StudentDAO dao;

  public StudentDTO createNewStudent() {
    return dao.createNewStudent();
  }
}
