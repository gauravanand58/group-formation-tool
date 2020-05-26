package com.advsdc.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class LandingPage {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Hello World!");
		return "home";
	}
}
