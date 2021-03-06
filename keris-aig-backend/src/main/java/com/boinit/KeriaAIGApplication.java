package com.boinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KeriaAIGApplication {

	public static void main(String[] args) {

		String profile = System.getProperty("spring.profiles.active");
		if (profile == null) {
			System.setProperty("spring.profiles.active", "oracle");
		}

		SpringApplication.run(KeriaAIGApplication.class, args);
	}

}
