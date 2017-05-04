package com.example;

import io.swagger.annotations.Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
	
	 @Bean
	  public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2).select()
	        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build()
	        .pathMapping("/").apiInfo(apiInfo()).useDefaultResponseMessages(false);
	  }

	  @Bean
	  public ApiInfo apiInfo() {
	    final ApiInfoBuilder builder = new ApiInfoBuilder();
	    builder.title("Swagger Test Api").version("1.0").license("(C) Copyright Test")
	        .description("The API provides a platform to query build test swagger api");

	    return builder.build();
	  }
}
