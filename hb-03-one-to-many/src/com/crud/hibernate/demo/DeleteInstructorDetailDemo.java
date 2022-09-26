package com.crud.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo.entity.Instructor;
import com.hibernatedemo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			
			// get instructor detail by id:
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);			
			
			// print the associated instructor
			System.out.println("Associated instructor: " + tempInstructorDetail.getInstructor());	
			
			// DELETE THE INSTRUCTOR DETAIL
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			//handle leaking issue (SESSION THAT IS NOT CLOSED APPROPRIATELY)
			session.close();
			
			factory.close();
		}
		
	}

}
