package com.clearlove.lesson04;

import java.net.URL;

/**
 * @author promise
 * @date 2023/3/11 - 15:30
 */
public class URLDemo01 {

  public static void main(String[] args) throws Exception {
    URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=clearlove&password=123");
    // 协议
    System.out.println(url.getProtocol());
    // 主机IP
    System.out.println(url.getHost());
    // 端口号
    System.out.println(url.getPort());
    // 文件地址
    System.out.println(url.getPath());
    // 文件全路径
    System.out.println(url.getFile());
    // 参数
    System.out.println(url.getQuery());
  }
}
