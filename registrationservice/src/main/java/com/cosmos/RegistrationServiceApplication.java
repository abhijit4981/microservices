package com.cosmos;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RegistrationServiceApplication {


	public static void main(String[] args) {
		log.info("Started execution..");
		SpringApplication.run(RegistrationServiceApplication.class, args);
	}

}
