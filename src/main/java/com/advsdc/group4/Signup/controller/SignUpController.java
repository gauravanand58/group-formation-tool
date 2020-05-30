package com.advsdc.group4.Signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.dao.SignUpDao;
import com.advsdc.group4.Signup.dao.SignUpDaoImpl;
import com.advsdc.group4.Signup.service.SignUpService;
import com.advsdc.group4.Signup.service.SignUpServiceImpl;

@Controller
public class SignUpController {
	
	@Autowired
	SignUpDao signUpDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
		SignUpService signupService = new SignUpServiceImpl(user, signUpDao);
		boolean isUserNew = signupService.userExists();
		if(isUserNew) {
			msg = "User already exists. Try to login or create account with different B00";
			model.addAttribute("msg", msg);
			return "signup";
		}
		
		// encrypt password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// set role as Guest
		user.setRole(5);
		
		// add user to Users table
		boolean isUserAdded = signupService.addUserToDB();
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
