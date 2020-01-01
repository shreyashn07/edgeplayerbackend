package com.steplabs.edgeplayerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.steplabs.edgeplayerbackend.repositories")
@EnableJpaAuditing
public class EdgeplayerbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeplayerbackendApplication.class, args);
	}

}
