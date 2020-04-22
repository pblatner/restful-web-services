package com.pjblat.springboot.rest.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Link to the HAL Browser for the application - http://localhost:8080
 *    with al actuator endpoints: http://localhost:8080/browser/index.html#/actuator
 * Link to the Spring actuator data - http://localhost:8080/actuator
 */
@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
