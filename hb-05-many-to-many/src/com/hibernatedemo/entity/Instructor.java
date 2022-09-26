package com.hibernatedemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	

	
	// *************** Add One-To-One relation between Instructor class and InstructorDetail class ***************
//	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")	// ----> Here, hibernate can use the foreign key, and then find the instructor detail record, and load that data accordingly.
 	private InstructorDetail instructorDetail;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) // Refers to the "Instructor" property in the "Course" class.
	private List<Course> courses; // since one instructor can teach multiple courses.
	
	
	// DEFAULT CONSTRUCTOR
	public Instructor() {}
	
	// PARAMETERISED CONSTRUCTOR
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// GETTER METHODS
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	
	// SETTER METHODS
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
		
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	// add convenience methods for bi-directional relationship --> also helps set up that bi-directional relationship between instructors and courses.
	
	public void add(Course tempCourse) {
		if(courses == null)
			courses = new ArrayList<>();
		
		courses.add(tempCourse); // Adding a course to the list of courses for this given instructor
		
		tempCourse.setInstructor(this); // Telling the COURSE class -- that this is the new instructor (meet and greet between the course and the actual instructor).
	}	
	
	// just for debugging purpose - to print the object and get the actual details for it.
		public String toString() {
			return "Instructor: [First Name: " + firstName + ", Last Name: " + lastName + ", Email id: " + email + ".\nInstructor Detail (instructorDetail): " +instructorDetail + ".";
		}

}