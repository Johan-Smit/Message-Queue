package com.saps;

import com.turtleMQ.MessageHandler;

import requests.CallCenter;

public class App 
{
    public static void main( String[] args )
    {
        MessageHandler messageHandler = new MessageHandler(8008);
        messageHandler.register(new CallCenter());
        messageHandler.start();
    }
}
