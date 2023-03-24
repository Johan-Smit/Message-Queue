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
        System.out.println("Successfully added " + nodeID);
    }

    public void send(String payload) {
        messages.add(payload);
    }

    @Override
    public void run() {

        receivers.forEach(r -> {
            String receiverStatus;
            r.connect();
            if (r.isActive()) {
                receiverStatus = r.getNodeID() + " online";
            }
            else {
                receiverStatus = r.getNodeID() + " offline";
            }
            System.out.println(receiverStatus + " for topic " + topic);
        });

        isActive = true;

        while (true) {
            if (messages.peek() != null) {
                String payload = messages.remove();
                receivers.forEach(r -> {
                    r.send(payload);
                });
            }
        }
    }
}
