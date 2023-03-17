package com.turtleMQ.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BrokerApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.turtleMQ.broker");
        context.refresh();

		SpringApplication.run(BrokerApplication.class, args);
	}

}
