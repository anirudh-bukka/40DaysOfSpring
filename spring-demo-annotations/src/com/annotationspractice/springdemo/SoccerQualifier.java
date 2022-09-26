package com.annotationspractice.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerQualifier implements Coach {
	
//	@Autowired
//	@Qualifier("happyFortuneService")
//	private FortuneService fortuneService;
//	
//	public SoccerQualifier() { System.out.println("Inside default constructor of SoccerQualifier."); }
//	
//	public String getDailyWorkout() { return "Do some workout"; }
//	
//	public String getDailyFortune() { return fortuneService.getFortune(); }
	@Autowired
//	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public SoccerQualifier() {
		System.out.println(">> SoccerQualifier: inside default constructor");
	}

	
	@Override
	public String getDailyWorkout() {
		return "Just soccer";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
