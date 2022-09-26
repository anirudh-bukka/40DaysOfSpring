package com.annotationspractice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDriverApp {

	public static void main(String[] args) {
		
		// Read the Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// getBean from the Spring container
		Coach coachObject = context.getBean("tennisCoach", Coach.class);
//		Coach coachObject = context.getBean("rugbyCoach", Coach.class);
		
		// call a method
		System.out.println(coachObject.getDailyWorkout());
		System.out.println(coachObject.getDailyFortune());
		
		// close the container
		context.close();

	}

}
