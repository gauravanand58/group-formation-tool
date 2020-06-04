package com.advsdc.group4.Admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.advsdc.group4.Admin.service.AddCourseService;
import com.advsdc.group4.Admin.service.AddCourseServiceImpl;
import com.advsdc.group4.Model.AdminCourse;

@Controller
public class AddCourseController {
	
	
	
	@RequestMapping(value="/add_course_page", method = RequestMethod.GET)
	public String addCourse(Model model) {	
		model.addAttribute("course", new AdminCourse());
		return "addCoursePage";
	}
	
	@RequestMapping("/add_course")
	public String addCourse(AdminCourse course, Model model) {
		AddCourseService addCourseService = new AddCourseServiceImpl();
		String message = addCourseService.addCourse(course);
		model.addAttribute("message", message);
		return "addCoursePage";
	}
	
	
	

}