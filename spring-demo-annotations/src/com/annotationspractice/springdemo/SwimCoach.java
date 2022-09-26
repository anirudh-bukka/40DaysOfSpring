package com.annotationspractice.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneServiceObject;
	
	public SwimCoach(FortuneService fortuneServiceObject) { this.fortuneServiceObject = fortuneServiceObject; }
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team")
	private String team;
	
	public String getEmail() { return email; }
	
	public String getTeam() { return team; }
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000m warm up";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneServiceObject.getFortune();
	}
}
