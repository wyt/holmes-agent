package com.yiche.buddy;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author wangyongtao
 * @date 2020/7/13
 */
@SuppressWarnings("all")
public class TimeInterceptor {

  @RuntimeType
  public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable)
      throws Exception {

    long start = System.currentTimeMillis();

    try {
      // 原有函数执行
      return callable.call();
    } finally {
      System.out.println(method + ": took " + (System.currentTimeMillis() - start) + "ms");
    }
  }
}
