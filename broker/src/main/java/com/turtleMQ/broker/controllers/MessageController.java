package com.turtleMQ.broker.controllers;

import java.io.IOException;
import java.util.List;

import com.turtleMQ.broker.services.MessageLogger;
import com.turtleMQ.broker.services.NodeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turtleMQ.broker.entities.Message;

@RestController
class MessageController {
    @Autowired NodeManagerService nodeManagerService;
    @Autowired MessageLogger messageLogger;

    MessageController() { }

    @PostMapping("/messages")
    void newMessage(@RequestBody Message newMessage) throws IOException {
        messageLogger.WriteLogger(newMessage);
        nodeManagerService.send(newMessage);
    }
}