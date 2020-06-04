package com.advsdc.group4.UserProfile.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserLoginController {
	
	@RequestMapping("/")
	public String userLogin(@RequestParam(required = false) boolean error ,Model model) {
		model.addAttribute("invalid", error);
		return "home";
	}
	
	@RequestMapping("/success.html")
	public String userLoginSuccess(Model model) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		for (GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("Admin") ) {
				return "admin/adminHomePage";
			}else if (grantedAuthority.getAuthority().equals("Guest")  || grantedAuthority.getAuthority().equals("Student") || grantedAuthority.getAuthority().equals("Instructor") || grantedAuthority.getAuthority().equals("TA")) {
				return "user/userHome";
			}
		}
		
		return "invalidSession";
		
	}
}
