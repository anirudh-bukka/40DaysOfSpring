package com.crud.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo.entity.Course;
import com.hibernatedemo.entity.Instructor;
import com.hibernatedemo.entity.InstructorDetail;
import com.hibernatedemo.entity.Review;
import com.hibernatedemo.entity.Student;

public class AddCoursesForMary {

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
			
//			// create a course
//			Course tempCourse = new Course("Pacman - How To Score One Million Points");
//			
//			// save the course
//			System.out.println("\nSaving the course ...");
//			session.save(tempCourse);
//			System.out.println("Save the course: " + tempCourse);
//			
//			// create a few students
//			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
//			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
//			
//			// add students to the course
//			tempCourse.addStudent(tempStudent1);
//			tempCourse.addStudent(tempStudent2);
//			
//			// save the Students
//			System.out.println("Saving students ...");
//			session.save(tempStudent1);
//			session.save(tempStudent2);
//			System.out.println("Saved the students: " + tempCourse.getStudents());
			
			
			
			// get the student Mary from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId); // we should have mary loaded at this time.
			
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Course selected: " + tempStudent.getCourses());
			
			// CREATE MORE COURSES
			Course tempCourse1 = new Course("Rubik's Cube - How to speed cube.");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the COURSES
			System.out.println("\nSaving the courses ...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			
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





