package com.coforge.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UtilisateurServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilisateurServiceApplication.class, args);
	}

}
