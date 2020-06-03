package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.Admin.dao.AssignInstructorDao;
import com.advsdc.group4.Admin.dao.AssignInstructorDaoImpl;
import com.advsdc.group4.BusinessObjectModels.User;

public class AssignInstructorServiceImpl implements AssignInstructorService{

	@Override
	public ArrayList<User> viewUser() {
		ArrayList<User> userList = new ArrayList<User>();
		AssignInstructorDaoImpl adi = new AssignInstructorDaoImpl();
		userList = adi.viewUsers();
		return userList;
	}

	@Override
	public String assignInstructor(String courseId, String bId) {
		AssignInstructorDaoImpl objAddInst = new AssignInstructorDaoImpl();
		String message = objAddInst.assignInstructor(courseId, bId);
		return message;
	}

}
