package com.practiceapp.spring;

public class CricketCoach implements Coach {
	
//	Here we implement Coach interface and perform dependency injection using constructor Setters, Getters.
	
	private FortuneService fortuneServiceObject;
	private String emailAddress;
	private String team;
	
	public CricketCoach() {}
	
	// INJECTION THROUGH CONSTRUCTOR
//	public CricketCoach(FortuneService fortuneServiceObject) {
//		this.fortuneServiceObject = fortuneServiceObject;
//	}
	
	// Getter and Setter methods.
	
		// ALWAYS FORGETTNIG ->
	public void setFortuneService(FortuneService fortuneServiceObjCric) {
		System.out.println("CricketCoach: inside the setter methods - setFortuneService.");
		fortuneServiceObject = fortuneServiceObjCric;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getTeam() {
		return team;
	}

	// from Coach interface
	public String getDailyWorkout() {
		return "Pace bowling";
	}
	
	public String getDailyFortune() {
		return fortuneServiceObject.getFortune();
	}

}
