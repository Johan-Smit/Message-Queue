package com.turtleMQ.broker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Message {
    private @Id @GeneratedValue Long id;
    private String payload;
    private String [] destinationNodes;

    Message() {}

    Message(String payload) {
        this.payload = payload;
    }

    public Long getId() {
        return this.id;
    }

    public String getPayload() {
        return this.payload;
    }

    public String[] getDestinationNodes() {
        return this.destinationNodes;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDestinationNodes(String[] destinationNodes) {
        this.destinationNodes = destinationNodes;
    }
}