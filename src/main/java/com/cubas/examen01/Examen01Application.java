package com.cubas.examen01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Examen01Application {

	public static void main(String[] args) {
		SpringApplication.run(Examen01Application.class, args);
	}

}
