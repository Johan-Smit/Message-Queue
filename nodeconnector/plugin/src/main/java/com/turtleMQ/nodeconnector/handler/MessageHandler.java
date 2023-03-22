package com.turtleMQ.nodeconnector.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class MessageHandler extends Thread {
    
    private ServerSocket server;
    private Socket broker;

    private int port;

    public MessageHandler(int port) {
        this.port = port;
    }

    private final void initialize(int port) {

        this.port = port;

        try {
            server = new ServerSocket(port);

            System.out.println("Listening for messages on port: " + port);

            broker = server.accept();

        } catch (IOException e) {
            System.out.println("Error initializing: " + e);
        }
    }

    public void run() {

        initialize(port);
        

        while (true) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(broker.getInputStream()));
                handle(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void handle(String payload);
}
