package com.imooc.netty.ch1;

public class ServerBoot {
    private static final int PROT = 9000;

    public static void main(String[] args) {
        Server server = new Server(PROT);
        server.start();
    }

}
