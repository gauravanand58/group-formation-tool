package com.advsdc.group4.CourseAdminPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.advsdc.group4.CourseAdminPage.service.EnrollStudentService;
import com.advsdc.group4.CourseAdminPage.service.EnrollStudentServiceImpl;

@Controller
public class EnrollStudentController {
	
	EnrollStudentService enrollstudentservice;
	public EnrollStudentController() {
		enrollstudentservice=new EnrollStudentServiceImpl();
	}
	
	@RequestMapping("/SubmitCSV")
	public String validateCSV(@RequestParam("csv") MultipartFile file,@RequestParam("courseID") int courseID,Model model) {
		Boolean enrolledStudent=enrollstudentservice.readCSV(file, courseID);	
		model.addAttribute("enrolledStudent", enrolledStudent);
		model.addAttribute("courseID", courseID);
		model.addAttribute("display", 3);
		return "user/CourseAdminPage";
	}
}
