package com.saps;

import com.turtleMQ.MessageHandler;

import requests.AccidentResponse;
import requests.CallCenter;
import requests.CrimeResponse;

public class App 
{
    public static void main( String[] args )
    {
        MessageHandler messageHandler = new MessageHandler(8008);
        messageHandler.register(new CallCenter());
        messageHandler.start();

        MessageHandler crimeHandler = new MessageHandler(8001);
        crimeHandler.register(new CrimeResponse());
        crimeHandler.start();

        MessageHandler accidentHandler = new MessageHandler(8002);
        accidentHandler.register(new AccidentResponse());
        accidentHandler.start();
    }
}
