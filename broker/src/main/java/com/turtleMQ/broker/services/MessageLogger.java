package com.turtleMQ.broker.services;
import java.util.Date;  

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.turtleMQ.broker.entities.Message;

@Service
public class MessageLogger {
    Date today = new Date();

    public MessageLogger(){
    try {
        
        File myObj = new File(today.toString()+".txt");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } 
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
    public void WriteLogger(Message message) throws IOException{
        FileWriter myWriter = new FileWriter(today+".txt");
        LocalTime myTimeObj = LocalTime.now();
        myWriter.append(myTimeObj.toString() + " " + message.getId().toString()
         + " " +message.getDestinationNodes()+ " "+ message.getPayload() +"\n");
        myWriter.close();
    }
    
}
