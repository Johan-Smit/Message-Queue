package com.turtleMQ.broker.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.turtleMQ.broker.components.NodeQueue;
import com.turtleMQ.broker.entities.Message;

@Service
@Scope("singleton")
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

    public void send(Message message) {
        for (int i=0; i<message.getDestinationNodes().length; i++) {
            try{
                nodeQueues.get("test").send(message.getPayload());
            }
            catch (Exception e) {
                System.out.println(message.getDestinationNodes()[i] + " caused an error:");
                System.out.println(e);
            }
        }
    }
}
