package com.example.computers.compparts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Note-taking:
- The main class (executable JAR)
- Least minimal amount of Spring config in bootstrap
 */

@SpringBootApplication //Indication that's a Spring application
/*
@SpringBootApplication comprised of three annotations:
- @SpringBootConfiguration - specialized form of @Configuration, designates the class as a
configuration class
- @EnableAutoConfiguration - enables autoconfiguration, autoconfigure any components
- @ComponentScan - auto discovers and register components to the Spring app, declare other classes
such as @Component, @Controller, @Service
 */

public class ComppartsApplication { //Spring Boot App

	public static void main(String[] args) {
		SpringApplication.run(ComppartsApplication.class, args); //runs the application
	}

}
