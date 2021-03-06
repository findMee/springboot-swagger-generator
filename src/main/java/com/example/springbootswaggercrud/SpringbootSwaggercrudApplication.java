package com.example.springbootswaggercrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.collect.Sets;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootSwaggercrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggercrudApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.protocols(Sets.newHashSet("https"))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.springbootswaggercrud.crud.controller"))
				.build();
	}

}
