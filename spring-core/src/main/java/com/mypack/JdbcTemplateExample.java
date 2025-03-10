//package com.mypack;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.mypack.beans.Employee;
//import com.mypack.dao.EmployeeDao;
//
//public class JdbcTemplateExample {
//
//  public static void main(String[] args) {
//    ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
//    EmployeeDao edao = (EmployeeDao) context.getBean("employeeDao");
//    Employee e = new Employee();
//    e.setId(101);
//    e.setName("test");
//    e.setSalary(1002);
//    //edao.insert(e);// insert single object
//
//    //Creating Employee list
//    List<Employee> empList = new ArrayList<Employee>();
//    empList.add(new Employee(101, "A", 1001));
//    empList.add(new Employee(102, "B", 1101.00));
//    empList.add(new Employee(103, "C", 1401.23));
//    System.out.println("Adding list of Employee............");
//    edao.insert(empList);// insert list of Objects
//    System.out.println("Added.");
//  }
//}
//
