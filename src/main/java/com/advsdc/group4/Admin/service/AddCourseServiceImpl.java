package com.advsdc.group4.Admin.service;

import com.advsdc.group4.Admin.dao.AddCourseDao;
import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.Model.AdminCourse;

public class AddCourseServiceImpl implements AddCourseService {
	String message;


	@Override
	public String addCourse(AdminCourse course) {
		AddCourseDao addCourseDao = new AddCourseDaoImpl();
		String message = addCourseDao.addCourse(course);
		return message;
	}

}
