package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.Admin.dao.DeleteCourseDao;
import com.advsdc.group4.Admin.dao.DeleteCourseDaoImpl;
import com.advsdc.group4.Model.AdminCourse;

public class DeleteCourseServiceImpl implements DeleteCourseService {
	
	DeleteCourseDao deleteCourseDao = new DeleteCourseDaoImpl();
	@Override
	public ArrayList<AdminCourse> viewCourse() {
		ArrayList<AdminCourse> courseList = new ArrayList<AdminCourse>();
		courseList = deleteCourseDao.viewCourse();
		return courseList;
	}

	@Override
	public String deleteCourse(ArrayList<String> courseDelList) {
		String message = deleteCourseDao.deleteCourse(courseDelList);
		return message;
	}
}
