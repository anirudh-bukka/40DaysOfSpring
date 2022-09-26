package com.crud.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernatedemo.entity.Course;
import com.hibernatedemo.entity.Instructor;
import com.hibernatedemo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//			
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 Code");
			Instructor tempInstructor = new Instructor("Susan", "Patel", "susan@mail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/", "Video Gaming");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor ---------> THIS WILL ALSO SAVE THE ASSOCIATED OBJECTS -- "Cascade"
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// session.createQuery("Delete from Instructor where id = 3").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Committed.");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
}
