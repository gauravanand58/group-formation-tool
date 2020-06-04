package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.Model.AdminCourse;
import com.advsdc.group4.Model.AdminUser;

public interface AssignInstructorService {
	String assignInstructor(String courseId, String bId);

	ArrayList viewUser();
}
