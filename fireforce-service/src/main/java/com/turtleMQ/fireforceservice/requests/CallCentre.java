package com.turtleMQ.fireforceservice.requests;

import com.turtleMQ.MessageReceiver;

public class CallCentre implements MessageReceiver {

    @Override
    public void handle(String arg0) {
        System.out.println(arg0);
    }

}
