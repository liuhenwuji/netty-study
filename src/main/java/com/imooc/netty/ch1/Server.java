package com.imooc.netty.ch1;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("server start success, port " + port);
        } catch (IOException e) {
            System.out.println("server start fail!");
            e.printStackTrace();
        }
    }

    public void start(){
        new Thread(()->{
           doStart();
        }).start();
    }

    private void doStart() {
        while (true){
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            }catch (IOException e){
                System.out.println("server exception!");
            }
        }
    }
}
