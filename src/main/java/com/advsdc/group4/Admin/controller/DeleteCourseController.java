package com.advsdc.group4.Admin.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.advsdc.group4.Admin.service.DeleteCourseServiceImpl;
import com.advsdc.group4.BusinessObjectModels.Course;

@Controller
public class DeleteCourseController {
	@RequestMapping("/delete_course")
	public String viewCourse(Model model) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		DeleteCourseServiceImpl acsi = new DeleteCourseServiceImpl();
		courseList = acsi.viewCourse();
		model.addAttribute("courseList", courseList);
		return "delCoursePage";
	}
	
	@RequestMapping(value="/displayChecked" ,method=RequestMethod.POST)
	public String displayCheckedCourses(@RequestParam("courseChecked") ArrayList<String> courseFinalList, Model model)
	{
		String message = null;
		if (courseFinalList!=null)
		{
			DeleteCourseServiceImpl delObj = new DeleteCourseServiceImpl();
			message = delObj.deleteCourse(courseFinalList);
		}
		model.addAttribute("message", message);
		model.addAttribute("courseList", new ArrayList<>());
		return "delCoursePage";
	}
}
