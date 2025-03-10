package com.mypack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSetterInjection {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("setter-injection.xml");
    User user = (User) context.getBean("userBean");
    System.out.println(
        user.getRoll() + "  " + user.getName() + " " + user.getCource().getId() + "  "
            + user.getCource().getName());
  }
}
