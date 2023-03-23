package com.turtleMQ.broker.controllers;

import com.turtleMQ.broker.services.MessageLogger;
import com.turtleMQ.broker.services.NodeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turtleMQ.broker.entities.Message;

@RestController
class MessageController {
    @Autowired
    NodeManagerService nodeManagerService;
    @Autowired
    MessageLogger messageLogger;

    MessageController() {
    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        nodeManagerService.send(newMessage);
        return newMessage;
    }
}