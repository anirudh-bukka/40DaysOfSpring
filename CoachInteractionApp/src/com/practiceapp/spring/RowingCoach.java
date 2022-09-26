package com.practiceapp.spring;

public class RowingCoach implements Coach{
	
	private FortuneService fortuneServiceObj;
	
	public RowingCoach() {}
	
	public RowingCoach(FortuneService theFortuneService) {
		fortuneServiceObj = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Row 2 kms upstream.";
	}

	@Override
	public String getDailyFortune() {

		return "Current is perfect today.";
	}
}