package com.turtleMQ.broker.components;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.stereotype.Component;

import lombok.Getter;

public class Node {

    @Getter
    private String nodeID;

    private boolean isActive = false;

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
            isActive = true;
        }
        catch (UnknownHostException unknownHostException) {
            //System.out.println("Error: " + unknownHostException);
        }
        catch (IOException ioException) {
            //System.out.println("Error: " + ioException);
        }
    }

    public boolean isActive() {
        return ((socket != null) && (socket.isConnected()));
    }

    public void send(String payload) {
        if (isActive()) {
            try {
                System.out.println("Sending " + payload + " to " + nodeID );
                new PrintWriter(socket.getOutputStream(), true).println(payload);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
        else {
            System.out.println(nodeID + " is inactive, message not sent");
        }
    }

}
