package com.practiceapp.spring;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppImplementation {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Coach theCoachObj = context.getBean("myBballCoach", Coach.class);
//		Coach theCoachObj = context.getBean("myCricCoach", Coach.class);
		Coach theCoachObj = context.getBean("myRowCoach", Coach.class);
		
		System.out.println(theCoachObj.getDailyWorkout());
		System.out.println(theCoachObj.getDailyFortune());
		
		context.close();
		// WRONG -->
//		Coach bball = new BaseballCoach();
//		Coach trackObj = new TrackCoach();
		
//		System.out.println("BaseballCoach class implemented: \n" + "\t" + bball.getDailyWorkout() + "\n" + "\t" + bball.getDailyFortune());
//		System.out.println("TrackCoach class implemented: \n" + "\t" + trackObj.getDailyWorkout() + "\n" + "\t" + trackObj.getDailyFortune());
	}
}