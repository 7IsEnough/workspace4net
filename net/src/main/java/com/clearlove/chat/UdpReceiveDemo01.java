package com.clearlove.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author promise
 * @date 2023/3/11 - 14:15
 */
public class UdpReceiveDemo01 {

  public static void main(String[] args) throws Exception {

    DatagramSocket socket = new DatagramSocket(6666);

    while (true) {
      // 准备接收数据
      byte[] container = new byte[1024];
      DatagramPacket packet = new DatagramPacket(container, 0, container.length);

      // 阻塞式接收包裹
      socket.receive(packet);

      // 断开连接 bye
      byte[] data = packet.getData();
      String receiveData = new String(data, 0, data.length);
      System.out.println(receiveData);
      if ("bye".equals(receiveData.trim())) {
        break;
      }

    }

    socket.close();
  }
}
