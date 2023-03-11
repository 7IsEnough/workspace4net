package com.clearlove.lesson04;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author promise
 * @date 2023/3/11 - 15:37
 */
public class URLDownload {

  public static void main(String[] args) throws Exception {
    // 1.下载地址
    URL url =
        new URL(
            "https://gossiponthis.com/wp-content/uploads/2020/01/kobe-bryant-dead.jpg");
    // 2.连接到这个资源 HTTP
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

    InputStream is = urlConnection.getInputStream();

    FileOutputStream fos = new FileOutputStream("kobe bryant.jpg");

    byte[] buffer = new byte[1024];
    int len;

    while ((len=is.read(buffer))!=-1) {
      fos.write(buffer, 0 ,len);
    }

    fos.close();
    is.close();
    // 断开连接
    urlConnection.disconnect();


  }
}
