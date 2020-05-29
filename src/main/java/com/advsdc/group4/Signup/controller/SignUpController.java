package com.advsdc.group4.Signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.service.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired
	SignUpService signupService;
	
	@Autowired
	User user;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		System.out.println("SignUp page");
		model.addAttribute("user", user);
		return "signup";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user, Model model) {
		System.out.println(user.toString());
		boolean result = signupService.addUserToDB(user);
		//boolean result =  signupdao.addEntry(user);
		System.out.println("Data added: "+result);
		String msg = "Hello Signup Check!";
		model.addAttribute("msg", msg);
		return "signup";
	}
}
