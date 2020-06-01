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
