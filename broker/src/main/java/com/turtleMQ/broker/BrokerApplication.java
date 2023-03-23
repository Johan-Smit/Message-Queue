package com.turtleMQ.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.turtleMQ.broker.services.ConfigService;
import com.turtleMQ.broker.services.NodeManagerService;

@SpringBootApplication
public class BrokerApplication {

	@Autowired
	static ConfigService configService;
	public static void main(String[] args) {
		SpringApplication.run(BrokerApplication.class, args);
	}

}
