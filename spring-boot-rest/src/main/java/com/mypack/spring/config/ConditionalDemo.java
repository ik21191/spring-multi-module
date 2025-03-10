package com.mypack.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import com.mypack.beans.ConditionalBean;
import com.mypack.beans.DatabaseTypeMongoCondition;
import com.mypack.beans.DatabaseTypeMysqlCondition;
import com.mypack.service.DatabaseTypeMongo;
import com.mypack.service.DatabaseTypeMysql;

@Configuration
public class ConditionalDemo {
  
  private static final Logger log = LoggerFactory.getLogger(ConditionalDemo.class);
  
  @Bean
  @Conditional(DatabaseTypeMysqlCondition.class)
  public DatabaseTypeMysql getMySqlDatabase() {
    log.info("getMySqlDatabase() called ......");
    return new DatabaseTypeMysql();
  }

  @Bean
  @Conditional(DatabaseTypeMongoCondition.class)
  public DatabaseTypeMongo getMongoDatabase() {
    log.info("getMongoDatabase() called ......");
    return new DatabaseTypeMongo();
  }

  @Bean
  @ConditionalOnProperty(name = "create.ConditionalBean", havingValue = "create",
      matchIfMissing = false)
  public ConditionalBean getConditionalBean() {
    log.info("getConditionalBean() called ......");
    return new ConditionalBean();
  }
}
