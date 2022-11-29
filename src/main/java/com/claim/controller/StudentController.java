package com.claim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.claim.entity.Student;
import com.claim.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public String welcome(Model model) {
		System.out.println("Home");
		return "index";
	}

	@GetMapping("/sign-up")
	public ModelAndView signUp(Model model) {
		// When the user tries to view the sign up page
		// This servlet will handle the request and add a spring ModelAttribute
		// object to map to the sign up form called “student”, which is a Student
		// object.
		System.out.println("Signup");
		return new ModelAndView("sign-up", "student", new Student());
	}

	@PostMapping("/sign-up")
	// The Model Attribute will map to the html model attribute in step 19
	public String handleSignUp(Model model, @ModelAttribute("student") Student student, HttpSession session) {
		
		studentService.saveStudent(student);
		model.addAttribute("newStudent", student);
		
		return "thank-you";

	}
	
	@GetMapping("/login")
	// The Model Attribute will map to the html model attribute in step 19
	public ModelAndView callLogin(Model model) {
		
		//create a session with the student
		System.out.println("Login");
		
		return new ModelAndView("login", "student", new Student());

	}
	
	@PostMapping("/login")
	// The Model Attribute will map to the html model attribute in step 19
	public String handleLogin(Model model, @ModelAttribute("student") Student student, HttpSession session) {
		
		//create a session with the student
		System.out.println("Login");
		return "index";

	}

}
