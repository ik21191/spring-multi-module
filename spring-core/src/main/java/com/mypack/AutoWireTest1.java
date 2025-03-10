package com.mypack;

import com.mypack.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireTest1 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("auto-wired1.xml");
    StudentService s = (StudentService) context.getBean("studentService");
    System.out.println(s.createNewStudent());
  }
}
