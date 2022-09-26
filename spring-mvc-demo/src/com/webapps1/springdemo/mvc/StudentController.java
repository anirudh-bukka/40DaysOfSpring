package com.webapps1.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// create a method to display the form
	@RequestMapping("/showForm") // beware
	public String showForm(Model theModelObj) {
		
		// create a new student object
		Student theStudent = new Student();
		
		// add student object to the model attribute
		theModelObj.addAttribute("student", theStudent);
		
		return "student-form"; // returns it back to student-form.jsp
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudentObj) {
		System.out.println("theStudent: " + theStudentObj.getFirstName() + " " + theStudentObj.getLastName());
		return "student-confirmation";
	}
	
}
