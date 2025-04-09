package com.mypack.spring.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.beans.ConditionalBean;
import com.mypack.entities.Employee;
import com.mypack.service.DatabaseType;
import com.mypack.spring.repository.EmployeeRepository;
import com.mypack.spring.rest.error.EntityNotFoundException;


@RestController
//@RequestMapping("/api/v1")
public class EmployeeController {

  private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private DatabaseType databaseType;
  @Autowired
  private ConditionalBean conditionalBean;

  @GetMapping("/")
  public ResponseEntity<String> getHomePage() {
    log.info("getHomePage() called.");
    return ResponseEntity.ok().body("This is home page.");
  }

  @GetMapping(value = "/api/employees" /*produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}*/)
  public List<Employee> getAllEmployees() {
    if (databaseType != null) {
      System.out.println(
          "hasCode ::::::::::::::::::" + databaseType + "   " + databaseType.hashCode());
    }
    if (conditionalBean == null) {
      System.out.println("Object of ConditionalBean is not present in IOC container.");
    }
    log.info("getAllEmployees method is called.");
    return employeeRepository.findAll();
  }
  //The user having ADMIN role will be able to access this end point
  @GetMapping(value = "/admin/hello")
  public String helloAdmin() {
    System.out.println("############## helloAdmin() is called. #####################");
    return "Hello Admin";
  }

  @PutMapping("/api/employees")
  public Employee createEmployee(@RequestBody Employee employee) {
    log.info("createEmployee method is called.");
    return employeeRepository.save(employee);
  }

  /***
   * Sample request
   http://localhost:8888/api/employees/101/Imran?queryParameter=101
   */
  @GetMapping("/api/employees/{id}/{name}")
  public ResponseEntity<com.mypack.entities.Employee> getEmployeeById(
      @PathVariable Map<String, String> pathVariableMap,
      @RequestParam("queryParameter") String queryParameter)
      throws Exception {
    Long employeeId = Long.parseLong(pathVariableMap.get("id"));
    log.info("getEmployeeById method is called.");
    log.info("getEmployeeById method is called, name parameter value is : " + pathVariableMap.get(
        "name"));
    log.info("getEmployeeById : queryParameter is : " + queryParameter);
    Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new EntityNotFoundException(employeeId.intValue()));
    return ResponseEntity.ok().body(employee);
  }

  @DeleteMapping("/api/employees/{id}")
  public ResponseEntity<Object> deleteEmployeeById(@PathVariable(value = "id") Long employeeId)
      throws Exception {
    log.info("deleteEmployeeById method is called.");
    Optional<Employee> optional = employeeRepository.findById(employeeId);
    if (optional.isPresent()) {
      employeeRepository.deleteById(employeeId);
      return ResponseEntity.ok().body("Deleted");
    } else {
      throw new EntityNotFoundException(employeeId.intValue());
    }
  }
}
