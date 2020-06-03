package com.advsdc.group4.CourseAdminPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advsdc.group4.CourseAdminPage.service.GetTAService;
import com.advsdc.group4.CourseAdminPage.service.GetTAServiceImpl;
import com.advsdc.group4.Model.User;


@Controller
public class GetTAController {
	
	GetTAService gettaservice;
	public GetTAController(){
		gettaservice=new GetTAServiceImpl();
	}

	@RequestMapping("/CourseAdminPage")
	public String addUser(@RequestParam("courseID") int courseID,@RequestParam("bannerID") String bannerID, Model model) {
		model.addAttribute("courseID", courseID);
		model.addAttribute("display", 0);
		return "user/CourseAdminPage";
	}
	@RequestMapping("/CourseAdminDetails")
	public String CourseAdminUI(@ModelAttribute User user,@RequestParam("courseID") int courseID, Model model) {
		String taInfo=gettaservice.displayInfo(user, courseID);	
		model.addAttribute("taInfo", taInfo);
		model.addAttribute("courseID", courseID);
		model.addAttribute("bannerID", user.getBannerID());
		model.addAttribute("display", 1);
		return "user/CourseAdminPage";
	}
	@RequestMapping("/CourseTAEnrolled")
	public String CourseTAEnroll(@ModelAttribute User user,@RequestParam("courseID") int courseID, Model model) {
		Boolean enrolledTA=gettaservice.enrollTA(user, courseID);	
		model.addAttribute("enrolledTA", enrolledTA);
		model.addAttribute("courseID", courseID);
		model.addAttribute("bannerID", user.getBannerID());
		model.addAttribute("display", 2);
		return "user/CourseAdminPage";
	}
	
}
