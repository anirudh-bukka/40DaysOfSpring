package com.annotationspractice.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.annotationspractice.springdemo")
public class SportConfig {
	
	// Define Bean for SadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService(); // instance of the SadFortuneService
	}
	
	// Define bean for SwimCoach AND Inject Dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	// 
}
