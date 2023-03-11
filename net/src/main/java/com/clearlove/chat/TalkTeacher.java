package com.clearlove.chat;

/**
 * @author promise
 * @date 2023/3/11 - 15:13
 */
public class TalkTeacher {

  public static void main(String[] args) {
    // 开启2个线程
    new Thread(new TalkSend(5555, "localhost", 8888)).start();
    new Thread(new TalkReceive(9999, "学生")).start();
  }
}
