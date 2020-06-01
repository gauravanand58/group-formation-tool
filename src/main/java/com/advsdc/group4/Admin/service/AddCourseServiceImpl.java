package com.advsdc.group4.Admin.service;

import com.advsdc.group4.Admin.dao.AddCourseDao;
import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.BusinessObjectModels.Course;

public class AddCourseServiceImpl implements AddCourseService{
	
	private AddCourseDao addCourseDao;
	String message;

//	public AddCourseServiceImpl(AdminDao addCourseDao)
//	{
//		this.addCourseDao=addCourseDao;
//		
//	}
	
	@Override
	public String insertCourseDetails(Course course) {
		AddCourseDaoImpl adi = new AddCourseDaoImpl();
		adi.addCourse(course);
		return null;
	}

}
