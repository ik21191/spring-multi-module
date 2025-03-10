package com.mypack.objectCreation;

public class X {

  String name;

  public X(String name) {
    this.name = name;
  }

  public static X getX(String name) {
    return new X(name);
  }

  public void display() {
    System.out.println("Value of name is : " + name);
  }
}
