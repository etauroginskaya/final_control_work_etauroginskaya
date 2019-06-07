package com.gmail.etauroginskaya.finalcontrolwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.gmail.etauroginskaya",
		exclude = UserDetailsServiceAutoConfiguration.class)
@EntityScan("com.gmail.etauroginskaya.finalcontrolwork.repository.model")
public class FinalControlWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalControlWorkApplication.class, args);
	}

}
