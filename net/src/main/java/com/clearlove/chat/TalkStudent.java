package com.clearlove.chat;

/**
 * @author promise
 * @date 2023/3/11 - 15:11
 */
public class TalkStudent {

  public static void main(String[] args){
    // 开启2个线程
    new Thread(new TalkSend(7777, "localhost", 9999)).start();
    new Thread(new TalkReceive(8888, "老师")).start();
  }



}
