package com.yiche;

import java.lang.instrument.Instrumentation;

/**
 * @author wangyongtao
 * @date 2020/7/13
 */
public class AgentBoot {

  /**
   * 以vm参数的方式载入，在Java程序的main方法执行之前执行
   *
   * @param args
   * @param instrumentation
   */
  public static void premain(String args, Instrumentation instrumentation) {

    System.out.println("java agent premain. args: " + args);
    ClassLogger transformer = new ClassLogger();
    instrumentation.addTransformer(transformer);
  }

  /**
   * 动态 attach 方式启动，运行此方法
   *
   * @param args
   * @param instrumentation
   */
  public static void agentmain(String args, Instrumentation instrumentation) {

    System.out.println("java agent premain. args: " + args);
    ClassLogger transformer = new ClassLogger();
    instrumentation.addTransformer(transformer);
  }
}
