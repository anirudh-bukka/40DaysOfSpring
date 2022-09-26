package com.hibernatedemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
// define fields
// define constructors
// define getter setters
// define toString()
// annotate fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "column")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) // we dont want to apply cascade delete.
	@JoinColumn(name = "instructor_id") // @JoinColumn is a column that is in the COURSE table, so course table has a column "instructor_id" that has the key that points back to the actual instructor. So that's the mapping we setup -- The course KNOWS how to find its given instructor.
	private Instructor instructor;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;
	
	// getter and setter for "reviews"
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	// initially, title constructor is enough because ID is auto generated and instructor will be assigned later (and we can always add instructor constructor whenever needed)
	public Course(String title) {
		this.title = title;
	}
	

	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Instructor getInstructor() { // ------> (Can print these out later)
		return instructor;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setInstructor(Instructor instructor) { // ------> (Can print these out later)
		this.instructor = instructor;
	}
	
	
	// add a convenience method:
	public void addReview(Review theReview) {
		if(reviews == null)
			reviews = new ArrayList<>();
		
		reviews.add(theReview);
	}
	
	@Override
	public String toString() {
		return "Course [id: " + id + ", title: " + title + "]";
	}
	
	

}
