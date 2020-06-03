package com.advsdc.group4.Admin.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advsdc.group4.Admin.service.AssignInstructorServiceImpl;
import com.advsdc.group4.Admin.service.DeleteCourseServiceImpl;
import com.advsdc.group4.BusinessObjectModels.Course;
import com.advsdc.group4.BusinessObjectModels.User;

@Controller
public class AssignInstructorController {
	ArrayList<Course> courseList;
	ArrayList<User> userList;

	@GetMapping("/assign_instructor_page")
	public String viewAddInstPage(Model model) {
		DeleteCourseServiceImpl objViewCourse = new DeleteCourseServiceImpl();
		courseList = objViewCourse.viewCourse();
		model.addAttribute("courseList", courseList);
		AssignInstructorServiceImpl objAssignInst = new AssignInstructorServiceImpl();
		userList = objAssignInst.viewUser();
		model.addAttribute("userList", userList);
		return "adminAssignInstructor";
	}

	@PostMapping("/assign_role")
	public String assignInstructor(@RequestParam("courseId") String courseId, User user, Model model) {
		model.addAttribute("courseList", courseList);
		model.addAttribute("userList", userList);
		AssignInstructorServiceImpl objAddInst = new AssignInstructorServiceImpl();
		String message = objAddInst.assignInstructor(courseId.split(" - ")[0], user.getbId());
		model.addAttribute("message", message);
		return "adminAssignInstructor";
	}
}
