package com.pjblat.springboot.rest.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/*
 * To access the Swagger UI - http://localhost:8080/swagger-ui.html
 * To get the YAML - http://localhost:8080/v3/api-docs.yaml
 *
 */
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Contact Application API").description(
                        "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }
	
	// Swagger 2
	// All the paths
	// All the APIs
}
