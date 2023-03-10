package com.clearlove.lesson1;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author promise
 * @date 2023/3/10 - 11:32
 */
public class TestInetSocketAddress {

  public static void main(String[] args) {
    InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
    InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 8080);
    System.out.println(socketAddress);
    System.out.println(socketAddress2);

    System.out.println(socketAddress.getAddress());
    // hosts 地址
    System.out.println(socketAddress.getHostName());
    // 端口
    System.out.println(socketAddress.getPort());
  }

}
