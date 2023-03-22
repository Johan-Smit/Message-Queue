package com.turtleMQ.broker.components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import lombok.Getter;

public class NodeQueue extends Thread {
    
    @Getter
    private boolean isActive = false;

    private String topic;

    private Queue<String> messages;

    private ArrayList<Node> receivers;

    public NodeQueue(String topic) {
        this.topic = topic;
        receivers = new ArrayList<>();
        messages = new LinkedList<>();
    }
    
    public void addNode(String nodeID, String location, int port) {
        receivers.add(new Node(nodeID, location, port));
    }

    public void send(String payload) {
        if (isActive) {

        }
        else {
            System.out.println(topic + " queue is inactive, message not sent");
        }
    }

    @Override
    public void run() {

        receivers.forEach(r -> {
            r.connect();
            if (r.isActive()) {
                System.out.print(r.getNodeID() + " online");
            }
            else {
                System.out.print(r.getNodeID() + " offline");
            }
            System.out.println(" for topic " + topic);
        });

        isActive = true;

        while (true) {
            if (isActive()) {
                if (messages.peek() != null) {
                    String payload = messages.remove();
                    receivers.forEach(r -> r.send(payload));
                }
            }
        }
    }
}