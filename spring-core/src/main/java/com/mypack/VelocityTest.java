package com.mypack;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * There is some compilation issue after upgrading spring version
 * */

public class VelocityTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("velocity-conf.xml");
    VelocityEngine velocityEngine = (VelocityEngine) context.getBean("velocityEngine");
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "Imran Khan");
    System.out.println("==========" + velocityEngine);
    //String ss = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "abc.vm", "UTF-8", map);
    //System.out.println(ss);


  }
}
