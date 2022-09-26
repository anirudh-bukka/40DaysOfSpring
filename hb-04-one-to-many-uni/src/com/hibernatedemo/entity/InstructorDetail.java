package com.hibernatedemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	// **************** ADD A NEW FIELD FOR INSTRUCTOR ****************
	
	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
	private Instructor instructor;
	
		// Getter and setter for "instructor"
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	// ****************************************************************
	
	// DEFAULT CONSTRUCTOR
	public InstructorDetail() {}
	
	// PARAMETERISED CONSTRUCTOR
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	// GETTER FUNCTIONS
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public int getId() {
		return id;
	}
	
	// SETTER FUNCTIONS
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// just for debugging purpose - to print the object and get the actual details for it.
	public String toString() {
		return "Instructor's details: [id = " + id + ", YouTube Channel: " + youtubeChannel + ", Hobby: " + hobby;
	}

}
