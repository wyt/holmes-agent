package com.yiche;

public class BuddyAgentTest {

  private void fun1() throws Exception {
    System.out.println("this is fun 1.");
    Thread.sleep(100);
  }

  private void fun2() throws Exception {
    System.out.println("this is fun 2.");
    Thread.sleep(100);
  }

  public static void main(String[] args) throws Exception {
    BuddyAgentTest test = new BuddyAgentTest();
    test.fun1();
    test.fun2();
  }
}
