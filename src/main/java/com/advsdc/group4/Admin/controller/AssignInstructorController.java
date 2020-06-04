package com.advsdc.group4.Admin.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advsdc.group4.Admin.service.AssignInstructorService;
import com.advsdc.group4.Admin.service.AssignInstructorServiceImpl;
import com.advsdc.group4.Admin.service.DeleteCourseService;
import com.advsdc.group4.Admin.service.DeleteCourseServiceImpl;
import com.advsdc.group4.Model.AdminCourse;
import com.advsdc.group4.Model.AdminUser;

@Controller
public class AssignInstructorController {
	AssignInstructorService assignInstructorService = new AssignInstructorServiceImpl();
	ArrayList<AdminCourse> courseList;
	ArrayList<AdminUser> userList;

	@GetMapping("/assign_instructor_page")
	public String viewAddInstPage(Model model) {
		DeleteCourseService deleteCourseService = new DeleteCourseServiceImpl();
		courseList = deleteCourseService.viewCourse();
		model.addAttribute("courseList", courseList);
		userList = assignInstructorService.viewUser();
		model.addAttribute("userList", userList);
		return "admin/adminAssignInstructor";
	}

	@PostMapping("/assign_instructor")
	public String assignInstructor(@RequestParam("courseId") String courseId, AdminUser user, Model model) {
		model.addAttribute("courseList", courseList);
		model.addAttribute("userList", userList);
		
		String message = assignInstructorService.assignInstructor(courseId.split(" - ")[0], user.getbId());
		model.addAttribute("message", message);
		return "admin/adminAssignInstructor";
	}
}