package com.mypack;

import java.util.Map.Entry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCollectionRef {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("collection-injection-ref.xml");
    Student student = (Student) context.getBean("studentBean");
    	/*if(student.getCourceList().size()>0){
    		System.out.println("Displaying cource list.......");
    		for(Cource c : student.getCourceList()){
    			System.out.println("ID: "+c.getId() + "  " +c.getName());
    		}
    	}*/
    if (student.getCourceProjectMap().size() > 0) {
      System.out.println("Displaying cource project map.......");
      for (Entry<Cource, Project> entry : student.getCourceProjectMap().entrySet()) {
        Cource cource = entry.getKey();
        Project project = entry.getValue();
        System.out.println(
            cource.getId() + " " + cource.getName() + "  ||  " + project.getId() + "  "
                + project.getName());
      }
    }
  }
}
