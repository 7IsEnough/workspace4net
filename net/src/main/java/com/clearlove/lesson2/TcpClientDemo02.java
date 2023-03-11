package com.clearlove.lesson2;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author promise
 * @date 2023/3/11 - 12:57
 */
public class TcpClientDemo02 {

  public static void main(String[] args) throws Exception {
    // 1.创建一个socket连接
    Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

    // 2.创建一个输出流
    OutputStream os = socket.getOutputStream();

    // 3.文件流  读取文件
    FileInputStream fileInputStream = new FileInputStream("kobe.jpg");

    // 4.写出文件
    byte[] buffer = new byte[1024];
    int len;
    while ((len=fileInputStream.read(buffer))!=-1) {
      os.write(buffer, 0, len);
    }

    // 通知服务器，已经传输结束了
    // 传输结束
    socket.shutdownOutput();

    // 确定服务器接收完毕，才能够断开连接
    InputStream inputStream = socket.getInputStream();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer2 = new byte[1024];
    int len2;
    while ((len2=inputStream.read(buffer2))!=-1) {
      baos.write(buffer2, 0, len2);
    }

    System.out.println(baos.toString());

    // 5.关闭资源
    baos.close();
    inputStream.close();
    fileInputStream.close();
    os.close();
    socket.close();
  }
}
