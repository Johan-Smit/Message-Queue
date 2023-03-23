package com.turtleMQ.fireforceservice;

import com.turtleMQ.MessageHandler;
import com.turtleMQ.fireforceservice.requests.CallCentre;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageHandler(8003);
        messageHandler.register(new CallCentre());
        messageHandler.start();
    }
}
