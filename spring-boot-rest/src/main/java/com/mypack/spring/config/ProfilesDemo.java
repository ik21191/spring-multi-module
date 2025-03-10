package com.mypack.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfilesDemo {
  @Profile("test")
  @Bean
  public String testBean() {
    System.out.println("\n############ Bean for test profile activated.#################\n");
    return "Test Profile";
  }

  @Profile("prod")
  @Bean
  public String prodBean() {
    System.out.println("\n############ Bean for production profile activated.#################\n");
    return "Prod Profile";
  }
}
