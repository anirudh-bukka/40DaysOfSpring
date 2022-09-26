package com.webapps1.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/LandingPage") // in case of a DummyCopyController
public class HelloWorldController {
	
	// controller method to show the initial HTML Form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form"; // WEB-INF/view/helloworld-form.jsp
	}
	
	// controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	
	// Create a new method to process form data, read the form data, convert the name to uppercase and add the uppercase version to the model.
	
		// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo!" + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude( @RequestParam("studentName") String theName, Model model) {
		
		// no need to request the parameter from HTML form
		
		// convert the data to all caps.
		theName = theName.toUpperCase();
		
		String result = "This is using V3: " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}
	
	
	
}
