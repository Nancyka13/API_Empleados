package com.paf.ferreteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class sisferreteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(sisferreteriaApplication.class, args);
	}

}

