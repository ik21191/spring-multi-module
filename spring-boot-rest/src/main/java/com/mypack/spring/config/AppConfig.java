package com.mypack.spring.config;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan({"com.mypack.spring.boot.main", "com.mypack.entities",
    "com.mypack.spring.rest.controller", "com.mypack.spring.exception"})

@EnableJpaRepositories("com.mypack.spring.repository")
@EntityScan("com.mypack.entities")
public class AppConfig {
  
  @Value("${application.env}")
  String applicationEnv;

  @Bean
  @Autowired
  public CommandLineRunner listAllBeans(ApplicationContext applicationContext) {

    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        System.out.println("\nPrinting Application Environment \n" + applicationEnv + "\n");
        RequestMappingHandlerMapping mapping =
            applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMapping = mapping.getHandlerMethods();
        handlerMethodMapping.forEach((k, v) -> {
          System.out.println(k);
          System.out.println(v);
          System.out.println("-----");
        });
      }
    };
  }
}
