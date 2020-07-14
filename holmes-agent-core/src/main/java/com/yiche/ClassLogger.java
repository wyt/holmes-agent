package com.yiche;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * @author wangyongtao
 * @date 2020/7/13
 */
public class ClassLogger implements ClassFileTransformer {

  @Override
  public byte[] transform(
      ClassLoader loader,
      String className,
      Class<?> classBeingRedefined,
      ProtectionDomain protectionDomain,
      byte[] classfileBuffer) {
    try {
      System.out.println(className);
    } catch (Throwable ignored) {
      ignored.printStackTrace();
    } finally {
      return classfileBuffer;
    }
  }
}
