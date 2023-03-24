package com.turtleMQ.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.turtleMQ.broker.services.ConfigService;

@SpringBootApplication
public class BrokerApplication {

	@Autowired
	static ConfigService configService;
	public static void main(String[] args) {
		SpringApplication.run(BrokerApplication.class, args);
	}

}
