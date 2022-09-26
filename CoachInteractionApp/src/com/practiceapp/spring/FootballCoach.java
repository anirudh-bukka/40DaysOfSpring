package com.practiceapp.spring;

public class FootballCoach implements Coach {
	
	private FortuneService fortuneServiceObject;
	
	public FootballCoach() {
		
	}
	
	public FootballCoach(FortuneService fbFortuneServ) {
		fortuneServiceObject = fbFortuneServ;
	}
	
	public String getDailyWorkout() {
		return "Practice penalties.";
	}
	
	public String getDailyFortune() {
		return fortuneServiceObject.getFortune();
	}

}
