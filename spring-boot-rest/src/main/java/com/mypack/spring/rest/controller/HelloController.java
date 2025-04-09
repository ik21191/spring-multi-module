package com.mypack.spring.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class HelloController {

  @GetMapping("/api/hello")
  public String hello() throws Exception {
    System.out.println("hello() of HelloController is called");
    int a = 1;
    if (a == 1) {
      throw new Exception();
    }
    return "Hello, the time at the server is now " + new Date() + "\n";
  }
  
  @GetMapping("/out-of-memory")
  public String createOutOfMemoryError() throws Exception {
    System.out.println("Creating outOfMemory error............");
    List<byte[]> list = new ArrayList<>();
    int index = 1;
    while (true) {
      // Allocate 1MB each loop (1 x 1024 x 1024 = 1048576 bytes)
      byte[] b = new byte[1048576];
      list.add(b);
      // Get the current free memory
      Runtime rt = Runtime.getRuntime();
      System.out.printf("[%d] free memory: %s%n", index++, rt.freeMemory());
    }
  }
}
