package com.turtleMQ.broker.services;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.turtleMQ.broker.entities.Message;

@Service
public class MessageLogger {

    public MessageLogger() {
    }

    public void WriteLogger(Message message) throws IOException {
        try {
            LocalDate today = LocalDate.now();
            LocalDateTime todayTime = LocalDateTime.now();
            String destinations = String.join(",", message.getDestinationNodes());
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(today + ".txt"), "utf-8"))) {
                writer.write(todayTime.toString() + "||" + message.getId().toString()
                        + "||<" + destinations + ">||" + message.getPayload() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
