package com.turtleMQ.broker.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.turtleMQ.broker.components.NodeQueue;

@Service
public class NodeManagerService {
    
    private HashMap<String, NodeQueue> nodeQueues;

    public NodeManagerService() {
        nodeQueues = new HashMap<>();
    }

    public void register(String nodeID, String location, int port, ArrayList<String> topics) {
        topics.forEach(t -> {
            if (nodeQueues.containsKey(t) == false) {
                nodeQueues.put(t, new NodeQueue(t));
            }
            nodeQueues.get(t).addNode(nodeID, location, port);
        });
    }

    public void activate() {
        for(Map.Entry<String, NodeQueue> entry : nodeQueues.entrySet()) {
            entry.getValue().start();
        }
    }
}
