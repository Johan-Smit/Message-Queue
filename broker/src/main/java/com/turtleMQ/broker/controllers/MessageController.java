package com.turtleMQ.broker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turtleMQ.broker.entities.Message;
import com.turtleMQ.broker.repositories.MessageRepository;

@RestController
class MessageController {

    private final MessageRepository repository; // TODO: Replace with NodeManager

    MessageController(MessageRepository repository) {
        // TODO: instantiate NodeManager and use instead of repository
        this.repository = repository;
    }

    @GetMapping("/messages")
    List<Message> all() {
        return repository.findAll();
    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        try {
            // TODO: Pass to NodeManager instead of repository
            return repository.save(newMessage);
            //return true;
        } catch (Exception ex) {
            //return false;
            throw ex;
        }
    }
}