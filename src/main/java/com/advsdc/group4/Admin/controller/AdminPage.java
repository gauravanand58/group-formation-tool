package com.advsdc.group4.Admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPage {
	
	@RequestMapping("/admin_home_page")
	public String adminHome() {

		
		return "adminHomePage";
	}

}
