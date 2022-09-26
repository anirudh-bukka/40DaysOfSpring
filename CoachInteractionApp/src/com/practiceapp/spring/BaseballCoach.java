package com.practiceapp.spring;

public class BaseballCoach implements Coach {
	
	// Define private fields for extra features such as FortuneService 
	private FortuneService fortuneServiceObject;
	
	// Constructors for Dependency Injection
		// have to create a default constructor because spring requires. If default constructor is not declared by us when parameterised constructor is declared/defined, error is thrown.
	public BaseballCoach() {}
	
	public BaseballCoach(FortuneService fsObjBball) {
		fortuneServiceObject = fsObjBball;
	}
	
	// Define the methods from the Coach Interface
	public String getDailyWorkout() {
		return "30 mins batting practice.";
	}
	
	public String getDailyFortune() {
		return fortuneServiceObject.getFortune();
	}

}
