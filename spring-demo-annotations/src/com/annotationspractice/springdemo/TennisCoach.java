package com.annotationspractice.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneServiceObj;
	
	public TennisCoach() {
		
	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneServiceObj) {
//		this.fortuneServiceObj = fortuneServiceObj;
//	}
	
	public String getDailyWorkout() {
		return "Practice 50 serves.";
	}
	
	public String getDailyFortune() {
		return fortuneServiceObj.getFortune();
	}
	
}
