package com.practiceapp.spring;

public class TrackCoach implements Coach {
	
	// Define private fields for extra features such as FortuneService
	private FortuneService fortuneServiceObject;
	
	// Constructors
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fsTrackObj) {
		fortuneServiceObject = fsTrackObj;
	}
	
	// Define the methods from the Coach Interface
	public String getDailyWorkout() {
		return "200m dash.";
	}
	
	public String getDailyFortune() {
		return fortuneServiceObject.getFortune();
	}
}
