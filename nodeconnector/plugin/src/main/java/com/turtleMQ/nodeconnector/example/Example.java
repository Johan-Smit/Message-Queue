package com.turtleMQ.nodeconnector.example;

import com.turtleMQ.nodeconnector.handler.MessageHandler;

public class Example extends MessageHandler{

    public Example() {
        super(8008);
    }

    @Override
    public void handle(String payload) {
        System.out.println(payload);
    }
    
}
