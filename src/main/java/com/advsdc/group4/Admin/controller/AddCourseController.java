package com.advsdc.group4.Admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.advsdc.group4.Admin.dao.AddCourseDao;
import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.Admin.service.AddCourseService;
import com.advsdc.group4.Admin.service.AddCourseServiceImpl;
import com.advsdc.group4.BusinessObjectModels.Course;

@Controller
public class AddCourseController {
	
	@RequestMapping(value="/add_course_page", method = RequestMethod.GET)
	public String addCourse(Model model) {	
		model.addAttribute("course", new Course());
		return "addCoursePage";
	}
	
	@RequestMapping("/add_course")
	public String addCourse(Course course, Model model) {
		AddCourseServiceImpl acsi = new AddCourseServiceImpl();
		acsi.insertCourseDetails(course);
		
		return null;
	}
}
