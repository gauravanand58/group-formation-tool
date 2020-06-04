package com.advsdc.group4.Admin.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.advsdc.group4.Admin.service.DeleteCourseService;
import com.advsdc.group4.Admin.service.DeleteCourseServiceImpl;
import com.advsdc.group4.Model.AdminCourse;

@Controller
public class DeleteCourseController {
	
	DeleteCourseService deleteCourseService = new DeleteCourseServiceImpl();
	
	@RequestMapping("/delete_course")
	public String viewCourse(Model model) {
		ArrayList<AdminCourse> courseList = new ArrayList<AdminCourse>();
		
		courseList = deleteCourseService.viewCourse();
		model.addAttribute("courseList", courseList);
		return "admin/delCoursePage";
	}
	
	@RequestMapping(value="/display_after_checking" ,method=RequestMethod.POST)
	public String displayCheckedCourses(@RequestParam("courseChecked") ArrayList<String> courseFinalList, Model model)
	{
		String message = null;
		if (courseFinalList!=null)
		{
			message = deleteCourseService.deleteCourse(courseFinalList);
		}
		model.addAttribute("message", message);
		model.addAttribute("courseList", new ArrayList<>());
		return "admin/delCoursePage";
	}
}
