package com.mypack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

  private long id;
  private String firstName;
  private String lastName;
  private String emailId;
  private int age;

  public Employee() {

  }

  public Employee(String firstName, String lastName, String emailId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailId = emailId;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column(name = "email_address", nullable = false)
  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @Column(name = "age", nullable = false)
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }


}
