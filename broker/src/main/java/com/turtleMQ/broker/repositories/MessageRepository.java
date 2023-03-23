package com.turtleMQ.broker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turtleMQ.broker.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}