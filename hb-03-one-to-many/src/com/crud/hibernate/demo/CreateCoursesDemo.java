package com.crud.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo.entity.Course;
import com.hibernatedemo.entity.Instructor;
import com.hibernatedemo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			// start a transaction
			session.beginTransaction();
			
// get the instructor from DB
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

// create some courses
			Course tempCourse1 = new Course("Air Guitar - The ultimate guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			
// add courses to instructor
			// SETTING UP THE BI-DIRECTIONAL RELATIONSHIP BETWEEN THE COURSE AND THE GIVEN INSTRUCTOR
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
