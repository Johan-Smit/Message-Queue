package com.turtleMQ.broker.components;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.stereotype.Component;

import lombok.Getter;

public class Node {

    @Getter
    private String nodeID;

    private Socket socket;
    private String location;
    private int port;

    public Node(String location, String nodeID, int port) {
        this.location = location;
        this.nodeID = nodeID;
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
        if (socket == null)
            return false;
        return socket.isConnected();
    }

}
