package com.clearlove.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author promise
 * @date 2023/3/11 - 14:59
 */
public class TalkSend implements Runnable{

  DatagramSocket socket = null;
  BufferedReader reader = null;

  private int fromPort;
  private String toIp;
  private int toPort;

  public TalkSend(int fromPort, String toIp, int toPort) {
    this.fromPort = fromPort;
    this.toIp = toIp;
    this.toPort = toPort;

    try {
      socket = new DatagramSocket(fromPort);
      reader = new BufferedReader(new InputStreamReader(System.in));
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void run() {

    while (true) {
      try {
        String data = reader.readLine();

        DatagramPacket packet =
            new DatagramPacket(
                data.getBytes(StandardCharsets.UTF_8),
                0,
                data.getBytes(StandardCharsets.UTF_8).length,
                new InetSocketAddress(this.toIp, this.toPort));

        socket.send(packet);
        if ("bye".equals(data)) {
          break;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


    socket.close();
  }
}
