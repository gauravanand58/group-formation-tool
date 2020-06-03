package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.BusinessObjectModels.Course;
import com.advsdc.group4.BusinessObjectModels.User;

public interface AssignInstructorService {
	String assignInstructor(String courseId, String bId);

	ArrayList viewUser();
}
