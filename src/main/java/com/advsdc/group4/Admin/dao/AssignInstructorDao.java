package com.advsdc.group4.Admin.dao;

import java.util.ArrayList;

import com.advsdc.group4.BusinessObjectModels.User;

public interface AssignInstructorDao {
	String assignInstructor(String courseId, String bId);

	ArrayList<User> viewUsers();
}
