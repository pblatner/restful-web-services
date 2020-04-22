package com.pjblat.springboot.rest.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pjblat.springboot.rest.restfulwebservices.user.UserResource;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@ComponentScan(basePackageClasses = {
	    UserResource.class
	})
/*
 * Swagger UI - http://localhost:8080/swagger-ui.html
 * Raw Swagger JSON - http://localhost:8080/v2/api-docs
 */
public class SwaggerConfig 
{
	@Bean
	public Docket api() 
	{
		return new Docket(DocumentationType.SWAGGER_2);
	}

}
