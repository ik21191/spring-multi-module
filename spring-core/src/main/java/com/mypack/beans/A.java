package com.mypack.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class A {

  @Autowired
  private B b;

  public A() {
    System.out.println("Constructor of A is called.");
  }

  public void print() {
    System.out.println("print() of A");
  }

  public B getB() {
    return b;
  }

  public void setB(B b) {
    this.b = b;
  }

}
