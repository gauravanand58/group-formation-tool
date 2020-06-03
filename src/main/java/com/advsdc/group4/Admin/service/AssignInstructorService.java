package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.User;

public interface AssignInstructorService {
	String assignInstructor(String courseId, String bId);

	ArrayList viewUser();
}
