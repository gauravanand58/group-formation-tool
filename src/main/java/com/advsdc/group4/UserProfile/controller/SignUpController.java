package com.advsdc.group4.UserProfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.UserProfile.service.ISignUpService;
import com.advsdc.group4.UserProfile.service.SignUpServiceImpl;

@Controller
public class SignUpController {
	
	private ISignUpService signUpService;
	
	public SignUpController() {
		signUpService = new SignUpServiceImpl();
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user, Model model) {
		String response = signUpService.addUserToDB(user);		
		model.addAttribute("msg", response);
		return "signup";
	}
}
