package com.advsdc.group4.GetTA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advsdc.group4.GetTA.service.GetTAService;


@Controller
public class GetTAController {
	
	@Autowired
	GetTAService gettaservice;

	@RequestMapping("/CourseAdminPage")
	public String CourseAdminUI(@RequestParam("courseID") int courseID, Model model) {
		model.addAttribute("courseID", courseID);
		model.addAttribute("display", 0);
		return "getTA";
	}
	@RequestMapping("/CourseAdminDetails")
	public String CourseAdminUI(@RequestParam("bannerID") String bannerID,@RequestParam("courseID") int courseID, Model model) {
		String taInfo=gettaservice.displayInfo(bannerID, courseID);	
		model.addAttribute("taInfo", taInfo);
		model.addAttribute("courseID", courseID);
		model.addAttribute("bannerID", bannerID);
		model.addAttribute("display", 1);
		return "getTA";
	}
	@RequestMapping("/CourseTAEnrolled")
	public String CourseTAEnroll(@RequestParam("bannerID") String bannerID,@RequestParam("courseID") int courseID, Model model) {
		Boolean enrolledTA=gettaservice.enrollTA(bannerID, courseID);	
		model.addAttribute("enrolledTA", enrolledTA);
		model.addAttribute("courseID", courseID);
		model.addAttribute("bannerID", bannerID);
		model.addAttribute("display", 2);
		return "getTA";
	}
	
}
