package com.imooc.netty.ch1;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final String Host = "127.0.0.1";
    public static final int Port = 9000;
    public static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(Host, Port);

        new Thread(()->{
            System.out.println("client start ok");
            while (true){
                String message = "hello world";
                System.out.println("client send data: " + message);
                try {
                    socket.getOutputStream().write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sleep();
            }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
