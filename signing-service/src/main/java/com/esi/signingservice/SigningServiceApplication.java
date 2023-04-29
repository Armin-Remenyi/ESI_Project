package src.main.java.com.esi.signingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SigningServiceApplication {
	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return  WebClient.builder();
	}


	public static void main(String[] args) {
		DatabaseInitializer.initialize("handoverservice_db");
		SpringApplication.run(SigningServiceApplication.class, args);
	}

}
