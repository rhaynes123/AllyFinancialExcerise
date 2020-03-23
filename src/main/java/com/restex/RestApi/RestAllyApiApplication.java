package com.restex.RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RestAllyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAllyApiApplication.class, args);
	}
}
