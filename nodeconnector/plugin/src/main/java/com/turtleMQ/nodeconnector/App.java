package com.turtleMQ.nodeconnector;

import com.turtleMQ.nodeconnector.example.Example;
import com.turtleMQ.nodeconnector.handler.MessageHandler;

public class App 
{
    public static void main( String[] args )
    {
        MessageHandler messageHandler = new MessageHandler(8008);
        messageHandler.register(new Example());
        messageHandler.start(); 
    }
}
