package com.advsdc.group4.Admin.dao;

import java.util.ArrayList;

import com.advsdc.group4.Model.AdminUser;

public interface AssignInstructorDao {
	String assignInstructor(String courseId, String bId);

	ArrayList<AdminUser> viewUsers();
}
