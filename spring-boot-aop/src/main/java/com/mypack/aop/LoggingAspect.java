package com.mypack.aop;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

  public void logBefore(JoinPoint joinPoint) {
    System.out.println("\nMethod execution started: " + joinPoint.getSignature());
  }

  public void logAfter(JoinPoint joinPoint) {
    System.out.println("\nMethod execution completed: " + joinPoint.getSignature());
  }
}
