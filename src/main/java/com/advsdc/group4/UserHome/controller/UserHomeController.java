package com.advsdc.group4.UserHome.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.UserHome.service.IUserHomeService;
import com.advsdc.group4.UserHome.service.UserHomeServiceImpl;

@Controller
public class UserHomeController {
	
	private IUserHomeService userHomeService;
	
	public UserHomeController() {
		userHomeService = new UserHomeServiceImpl();
	}
	
	@GetMapping("/userHome")
	public String userHome(Model model) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String bannerID = authentication.getName();
		System.out.println("Banner ID is: " + bannerID);
		IUser user = userHomeService.loadUserCourseMap(bannerID);
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("Student") || grantedAuthority.getAuthority().equals("Instructor") || grantedAuthority.getAuthority().equals("TA")) {
				model.addAttribute("userBannerID", bannerID);
				model.addAttribute("userCourseMap", user.getRoleMap());
				return "user/userHome";
			}
		}
		List<Course> courseList = userHomeService.getAllCourses();		
		model.addAttribute("userBannerID", "Guest");
		model.addAttribute("courseList", courseList);
		return "user/userHome";
	}
	
	@PostMapping("/Student")
	public String showStudentPage(@RequestParam(value="courseID") String courseID, @RequestParam(value="bannerID") String bannerID, Model model) {
		int id = Integer.parseInt(courseID);
		String courseName = userHomeService.getCourseName(id);
		System.out.println(courseName);
		model.addAttribute("courseName", courseName);
		return "user/student";
	}
	
}
