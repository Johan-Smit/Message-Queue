package com.turtleMQ.broker.components;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import lombok.Getter;

public class Node {

    @Getter
    private String nodeID;

    private Socket socket;
    private String location;
    private int port;

    public Node(String nodeID, String location, int port) {
        this.nodeID = nodeID;
        this.location = location;
        this.port = port;
    }

    public void connect() {
        try {
            socket = new Socket(location, port);
        }
        catch (UnknownHostException unknownHostException) {
            //System.out.println("Error: " + unknownHostException);
        }
        catch (IOException ioException) {
            //System.out.println("Error: " + ioException);
        }
    }

    public boolean isActive() {
        return (socket != null);
    }

    public synchronized void send(String payload) {
        try {
            if (isActive())
                new PrintWriter(socket.getOutputStream(), true).println(payload);
            connect();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
