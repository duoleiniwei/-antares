package com.nehs.antares.utils.thread;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * BIO客户端
 */
public class BIOClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 1234);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ":hello mother fuck!" + Thread.currentThread().getId()).getBytes());
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
