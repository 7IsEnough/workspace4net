package com.clearlove.lesson3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author promise
 * @date 2023/3/11 - 14:04
 * 还是要等待客户端的连接
 */
public class UdpServerDemo01 {

  public static void main(String[] args) throws Exception {
    // 开放端口
    DatagramSocket socket = new DatagramSocket(9090);

    // 接收数据
    byte[] buffer = new byte[1024];
    DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

    // 阻塞接收
    socket.receive(packet);

    System.out.println(packet.getAddress().getHostAddress());
    System.out.println(new String(packet.getData(), 0, packet.getLength()));

    // 关闭连接
    socket.close();
  }
}
