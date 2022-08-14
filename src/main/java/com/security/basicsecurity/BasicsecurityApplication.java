package com.security.basicsecurity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Spring  security USer login",
		version = "1.0",
		description = "sample documents"
))
public class BasicsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicsecurityApplication.class, args);
	}

}