package com.turtleMQ.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.turtleMQ.broker.services.ConfigService;

@SpringBootApplication
public class BrokerApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.turtleMQ.broker");
        context.refresh();

		context.getBean(ConfigService.class).initialize();

		SpringApplication.run(BrokerApplication.class, args);

		context.close();
	}

}
