package com.mypack.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPDemo {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    ApplicationContext context = new ClassPathXmlApplicationContext("aop-config.xml");
    
    MyService myService = (MyService) context.getBean("myService");
    
    myService.deposit(100);
    myService.witdraw(50);
    myService.displayAmount();
    
  }
}
