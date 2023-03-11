package com.clearlove.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author promise
 * @date 2023/3/11 - 14:15
 */
public class UdpSenderDemo01 {

  public static void main(String[] args) throws Exception {

    DatagramSocket socket = new DatagramSocket(8888);

    // 准备数据：控制台读取 System.in

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String data = reader.readLine();

      DatagramPacket packet =
          new DatagramPacket(
              data.getBytes(StandardCharsets.UTF_8),
              0,
              data.getBytes(StandardCharsets.UTF_8).length,
              new InetSocketAddress("localhost", 6666));

      socket.send(packet);
      if ("bye".equals(data)) {
        break;
      }
    }


    socket.close();
  }
}
