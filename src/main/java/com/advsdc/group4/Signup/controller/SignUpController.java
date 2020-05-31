package com.advsdc.group4.Signup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.service.SignUpService;
import com.advsdc.group4.Signup.service.SignUpServiceImpl;
import com.advsdc.group4.util.PasswordEncoder;

@Controller
public class SignUpController {
	
	private SignUpService signUpService;
	
	public SignUpController() {
		signUpService = new SignUpServiceImpl();
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		System.out.println("SignUp page");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user, Model model) {
		String msg = "Hello Signup Check!";
		System.out.println(user.toString());
		
		// check if user already exists
		boolean isUserNew = signUpService.userExists(user);
		if(isUserNew) {
			msg = "User already exists. Try to login or create account with different B00";
			model.addAttribute("msg", msg);
			return "signup";
		}
		
		// encrypt password
		PasswordEncoder passwordEncoder = new PasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// set role as Guest
		user.setRole(5);
		
		// add user to Users table
		boolean isUserAdded = signUpService.addUserToDB(user);
		if(!isUserAdded) {
			msg = "Error while adding user. Please try again.";
			model.addAttribute("msg", msg);
			return "signup";
		}
		msg = "User added successfully. You may login now";
		model.addAttribute("msg", msg);
		return "signup";
	}
}
