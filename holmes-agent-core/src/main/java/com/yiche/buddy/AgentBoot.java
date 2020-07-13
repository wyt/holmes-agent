package com.yiche.buddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * @author wangyongtao
 * @date 2020/7/13
 */
@SuppressWarnings("all")
public class AgentBoot {

  /**
   * 以vm参数的方式载入，在Java程序的main方法执行之前执行
   *
   * @param args
   * @param instrumentation
   */
  public static void premain(String args, Instrumentation instrumentation) {

    System.out.println("java agent premain [byte-buddy]. args: " + args);

    AgentBuilder.Transformer transformer =
        new AgentBuilder.Transformer() {
          @Override
          public DynamicType.Builder<?> transform(
              DynamicType.Builder<?> builder,
              TypeDescription typeDescription,
              ClassLoader classLoader,
              JavaModule module) {
            return builder
                .method(ElementMatchers.any()) // 拦截任意方法
                .intercept(MethodDelegation.to(TimeInterceptor.class)); // 委托
          }
        };

    AgentBuilder.Listener listener =
        new AgentBuilder.Listener() {
          @Override
          public void onDiscovery(
              String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
            //
          }

          @Override
          public void onTransformation(
              TypeDescription typeDescription,
              ClassLoader classLoader,
              JavaModule javaModule,
              boolean b,
              DynamicType dynamicType) {
            //
          }

          @Override
          public void onIgnored(
              TypeDescription typeDescription,
              ClassLoader classLoader,
              JavaModule javaModule,
              boolean b) {
            //
          }

          @Override
          public void onError(
              String s,
              ClassLoader classLoader,
              JavaModule javaModule,
              boolean b,
              Throwable throwable) {
            //
          }

          @Override
          public void onComplete(
              String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
            //
          }
        };

    new AgentBuilder.Default()
        .type(ElementMatchers.nameStartsWith("com.yiche")) // 指定需要拦截的类
        .transform(transformer)
        .with(listener)
        .installOn(instrumentation);
  }
}
