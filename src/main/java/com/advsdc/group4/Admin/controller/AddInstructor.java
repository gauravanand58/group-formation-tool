package com.advsdc.group4.Admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddInstructor {
	
	@RequestMapping("/add_instructor_page")
	public String addInst() {

		
		return "addInstructorPage";
	}

}

