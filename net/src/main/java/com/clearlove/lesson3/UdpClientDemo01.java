package com.clearlove.lesson3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author promise
 * @date 2023/3/11 - 13:56
 * 不需要连接服务器
 */
public class UdpClientDemo01 {

  public static void main(String[] args) throws Exception {

    // 1.建立一个Socket
    DatagramSocket socket = new DatagramSocket();

    // 2.创建数据包
    String msg = "服务器你好";

    // 发送给谁
    InetAddress localhost = InetAddress.getByName("127.0.0.1");
    int port = 9090;
    // 数据，数据的长度起始，要发送给谁
    DatagramPacket packet =
        new DatagramPacket(
            msg.getBytes(StandardCharsets.UTF_8),
            0,
            msg.getBytes(StandardCharsets.UTF_8).length,
            localhost,
            port);

    // 3.发送数据包
    socket.send(packet);

    // 4.关闭流
    socket.close();
  }
}
