package com.esi.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class UserserviceApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return  WebClient.builder();
	}

	public static void main(String[] args) {
		DatabaseInitializer.initialize("userservice_db");
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
