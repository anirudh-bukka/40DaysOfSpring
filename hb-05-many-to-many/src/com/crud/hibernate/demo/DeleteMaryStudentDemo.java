package com.crud.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo.entity.Course;
import com.hibernatedemo.entity.Instructor;
import com.hibernatedemo.entity.InstructorDetail;
import com.hibernatedemo.entity.Review;
import com.hibernatedemo.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the student Mary from database
			int studentId = 2; // use Mary's student ID
			Student tempStudent = session.get(Student.class, studentId); // we should have mary loaded at this time.
			
			System.out.println("Loaded Student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			// delete student
			System.out.println("Deleting students: " + tempStudent);
			session.delete(tempStudent);
			// ----> now the course stil remains
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





