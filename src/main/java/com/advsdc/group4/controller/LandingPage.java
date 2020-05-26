package com.advsdc.group4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.advsdc.group4.service.LandingService;

@Controller 
public class LandingPage {
	@Autowired
	LandingService landingService;
	
	@RequestMapping("/")
	public String home(Model model) {
		String resultUI = landingService.landingHome(model);
		
		return resultUI;
	}
	
	
	
}
