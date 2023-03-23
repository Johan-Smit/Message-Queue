package com.turtleMQ.nodeconnector.example;

import com.turtleMQ.nodeconnector.handler.MessageHandler;
import com.turtleMQ.nodeconnector.handler.MessageReceiver;

public class Example implements MessageReceiver {

    @Override
    public synchronized void handle(String payload) {
        System.out.println(payload);
    }

}
