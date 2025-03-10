package com.mypack.main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ResourceUtils;
import com.mypack.app.config.AppConfig;
import com.mypack.entity.PersonEntity;
import com.mypack.model.CityModel;
import com.mypack.model.PersonIdentityModel;
import com.mypack.model.PersonModel;
import com.mypack.service.PersonService;

/**
 * @author
 *
 */
public class MainApp {
  //below method is not in use
  public String readSqlFileContents() {
    String sqlFilePath = null;
    try {
      File file = ResourceUtils.getFile("classpath:META-INF/db.sql");
      return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sqlFilePath;
  }


  public static void main(String[] args) throws SQLException {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    PersonService personService = context.getBean(PersonService.class);
    // personService.loadSqlSript(new MainApp().readSqlFileContents());


    // Add Persons
    CityModel city = new CityModel("New Delhi");
    PersonIdentityModel personIdentityModel1 = new PersonIdentityModel("AADHAR CARD");
    PersonIdentityModel personIdentityModel2 = new PersonIdentityModel("VOTER ID");
    PersonIdentityModel personIdentityModel3 = new PersonIdentityModel("DRIVING LICENSE");

    List<PersonIdentityModel> personIdentityModelList = new ArrayList<>();
    personIdentityModelList.add(personIdentityModel1);
    personIdentityModelList.add(personIdentityModel2);
    personIdentityModelList.add(personIdentityModel3);
    personService.add(
        new PersonModel("Imran", "Khan", "imran.khan@gmail.com", city, personIdentityModelList));
    // personService.add(new PersonModel("Rahul", "Kumar", "rahul.kumar@gmail.com", city));

    // fetch person
    long personId = 1;
    PersonModel personModel = personService.findPerson(personId);
    if (personModel != null) {
      System.out.println("Person details of given id: " + personId);
      System.out.println(personModel);
    } else {
      System.out.println("No details found of given id: " + personId);
    }
    // fetch all Persons
    List<PersonEntity> persons = personService.listPersons();
    for (PersonEntity person : persons) {
      System.out.println("Id = " + person.getId());
      System.out.println("First Name = " + person.getFirstName());
      System.out.println("Last Name = " + person.getLastName());
      System.out.println("Email = " + person.getEmail());
      System.out.println();
    }

  }
}
