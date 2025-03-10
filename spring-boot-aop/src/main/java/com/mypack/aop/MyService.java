package com.mypack.aop;

import org.springframework.stereotype.Component;

@Component
public class MyService {
  private int amount;
  public void deposit(int amt) {
    System.out.println("Adding amount");
    this.amount = this.amount + amt;
  }
  
  public void witdraw(int amt) {
    System.out.println("Witdrawing amount");
    
    if (amount > this.amount) {
      System.out.println("Invalid amount");
      throw new RuntimeException("Requested amount is not avaialble");
    } 
    this.amount = this.amount - amt;
  }
  
  public void displayAmount() {
    System.out.println("Available amount: " + this.amount);
  }
  
}
