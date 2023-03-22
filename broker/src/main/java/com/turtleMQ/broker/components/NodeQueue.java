package com.turtleMQ.broker.components;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

public class NodeQueue extends Thread {

    private boolean isActive = false;

    private String topic;

    private ArrayList<Node> receivers;

    public NodeQueue(String topic) {
        this.topic = topic;
        receivers = new ArrayList<>();
    }
    
    public void addNode(String nodeID, String location, int port) {
        receivers.add(new Node(nodeID, location, port));
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

        while (true) {

        }
    }
}
