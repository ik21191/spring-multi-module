package com.mypack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypack.beans.A;


public class AutoWireTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("auto-wired.xml");
    System.out.println("\nRequesting spring container for the bean A...");
    A a = (A) context.getBean("a");
    a.getB().display();
  }
}
