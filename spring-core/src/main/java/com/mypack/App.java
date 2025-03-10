package com.mypack;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App 
{
    public static void main( String[] args ) {
    	Resource resource = new ClassPathResource("Spring-Module.xml");
    	BeanFactory factory = new XmlBeanFactory(resource);//Core IOC container
    	//ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");//Advance IOC container
    	User obj = (User) factory.getBean("userBean");
    	System.out.println(obj.getName());
    	System.out.println(obj.getRoll());
    	//System.out.println(obj.getCource().getId()+"   "+obj.getCource().getName());
    	System.out.println("List: " + obj.getList());
    	System.out.println("List: " + obj.getSet());
    	System.out.println("List: " + obj.getMap());
    }
}
