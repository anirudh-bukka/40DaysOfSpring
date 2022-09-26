package com.annotationspractice.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RugbyCoach implements Coach {
	
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneServiceObj;
	
	private RugbyCoach() { System.out.println("Inside RugbyCoach default constructor."); }
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("RugbyCoach: Inside doMyStartupStuff() method");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("RugbyCoach: Inside doMyCleanupStuff() method");
	}
	
//	@Autowired
//	public void badumtssFortuneService(FortuneService fortuneServiceObj) {
//		this.fortuneServiceObj = fortuneServiceObj;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "21 goals to win";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneServiceObj.getFortune();
	}	
	
}
