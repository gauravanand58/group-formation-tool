package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.Admin.dao.AssignInstructorDao;
import com.advsdc.group4.Admin.dao.AssignInstructorDaoImpl;
import com.advsdc.group4.Model.AdminUser;

public class AssignInstructorServiceImpl implements AssignInstructorService{
	
	AssignInstructorDao assignInstructorDao = new AssignInstructorDaoImpl();

	@Override
	public ArrayList<AdminUser> viewUser() {
		ArrayList<AdminUser> userList = new ArrayList<AdminUser>();
		userList = assignInstructorDao.viewUsers();
		return userList;
	}

	@Override
	public String assignInstructor(String courseId, String bId) {
		String message = assignInstructorDao.assignInstructor(courseId, bId);
		return message;
	}

}
