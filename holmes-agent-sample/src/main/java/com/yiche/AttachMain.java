package com.yiche;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Attach方式,VirtualMachine在tools.jar中，需要将tools.jar加入到classpath
 *
 * @author wangyongtao
 * @date 2020/7/13
 */
public class AttachMain {

  public static void main(String[] args)
      throws IOException, AttachNotSupportedException, AgentLoadException,
          AgentInitializationException {

    // attach方法参数为目标应用程序的进程号
    VirtualMachine vm = VirtualMachine.attach("18824");

    try {
      // agent路径
      vm.loadAgent(
          "E:\\idea\\projects\\yiche\\holmes-agent\\holmes-agent-core\\target\\holmes-agent-core-0.0.1.jar",
          "foobar");
    } finally {
      vm.detach();
    }
  }
}
