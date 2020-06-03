package com.advsdc.group4.Admin.service;

import java.util.ArrayList;

import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.Admin.dao.DeleteCourseDaoImpl;
import com.advsdc.group4.BusinessObjectModels.Course;

public class DeleteCourseServiceImpl implements DeleteCourseService {
	@Override
	public ArrayList<Course> viewCourse() {
		// TODO Auto-generated method stub
		ArrayList<Course> courseList = new ArrayList<Course>();
		DeleteCourseDaoImpl adi2 = new DeleteCourseDaoImpl();
		courseList = adi2.viewCourse();
		return courseList;
	}

	@Override
	public String deleteCourse(ArrayList<String> courseDelList) {
		DeleteCourseDaoImpl objDel = new DeleteCourseDaoImpl();
		String message = objDel.deleteCourse(courseDelList);
		return message;
	}
}
