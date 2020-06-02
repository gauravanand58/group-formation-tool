package com.advsdc.group4.UserHome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.UserHome.service.IUserHomeService;
import com.advsdc.group4.UserHome.service.UserHomeServiceImpl;

@Controller
public class UserHomeController {
	
	private IUserHomeService userHomeService;
	
	public UserHomeController() {
		userHomeService = new UserHomeServiceImpl();
	}
	
	@GetMapping("/userHome")
	public String userHome(@RequestParam(value="id") String bannerID, Model model) {
//		SecurityContext context = SecurityContextHolder.getContext();
//		Authentication authentication = context.getAuthentication();
//		String bannerID = authentication.getName();
		IUser user = userHomeService.loadUserCourseMap(bannerID);
		model.addAttribute("user", user);
		model.addAttribute("userCourseMap", user.getRoleMap());
		return "user_home";
	}
	
	@PostMapping("/CourseAdminPage")
	public String addUser(@RequestParam(value="courseID") String courseID, @RequestParam(value="bannerID") String bannerID, Model model) {
		System.out.println(courseID);
		System.out.println(bannerID);
		return "user_home";
	}
	
}
