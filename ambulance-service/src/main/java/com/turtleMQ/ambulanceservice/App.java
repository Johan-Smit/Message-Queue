package com.turtleMQ.ambulanceservice;

import com.turtleMQ.MessageHandler;
import com.turtleMQ.ambulanceservice.requests.CallCentre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MessageHandler messageHandler = new MessageHandler(8008);
        messageHandler.register(new CallCentre());
        messageHandler.start();
    }
}
