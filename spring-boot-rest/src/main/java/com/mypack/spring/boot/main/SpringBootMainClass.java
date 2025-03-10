package com.mypack.spring.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mypack.spring.config"})
public class SpringBootMainClass {

  public static void main(String[] ar) {
    SpringApplication.run(SpringBootMainClass.class, ar);
  }
}
