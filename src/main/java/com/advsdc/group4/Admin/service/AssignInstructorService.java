package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.Model.Course;

public interface AssignInstructorService {
	String assignInstructor(int courseId, String bId);

	ArrayList viewUser();
}
