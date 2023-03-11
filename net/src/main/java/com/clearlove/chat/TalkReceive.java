package com.clearlove.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author promise
 * @date 2023/3/11 - 15:06
 */
public class TalkReceive implements Runnable {

  DatagramSocket socket = null;
  private int port;
  private String msgFrom;

  public TalkReceive(int port, String msgFrom) {
    this.port = port;
    this.msgFrom = msgFrom;
    try {
      socket = new DatagramSocket(port);
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {

    while (true) {
      try {
        // 准备接收数据
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);

        // 阻塞式接收包裹
        socket.receive(packet);

        // 断开连接 bye
        byte[] data = packet.getData();
        String receiveData = new String(data, 0, data.length);
        System.out.println(msgFrom + "：" + receiveData);
        if ("bye".equals(receiveData.trim())) {
          break;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    socket.close();
  }
}
