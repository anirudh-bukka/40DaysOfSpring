package com.annotationspractice.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

// Create an array of random strings and return any one of the strings randomly.
	
	private String[] data = {
			"Beware of the wolf in sheep's clothing.",
			"Diligence is the mother of good luck.",
			"The journey is the reward."
	};
	
	// create a random number generator
	
	private Random randomGenerator = new Random();
	
	@Override
	public String getFortune() {
		
		// pick a random number:
		int index = randomGenerator.nextInt(data.length);
		
		String displayFortune = data[index];
		
		return displayFortune;
	}

}
