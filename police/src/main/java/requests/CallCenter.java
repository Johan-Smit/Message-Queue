package requests;

import com.turtleMQ.MessageReceiver;

public class CallCenter implements MessageReceiver {
    @Override
    public void handle(String args) {
        System.out.println(args);
    }
}
