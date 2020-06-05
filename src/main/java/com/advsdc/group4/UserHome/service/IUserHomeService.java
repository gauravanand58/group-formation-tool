package com.advsdc.group4.UserHome.service;

import java.util.List;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.IUser;

public interface IUserHomeService {
	public IUser loadUserCourseMap(String bannerID);
	
	public List<Course> getAllCourses();
	
	public String getCourseName(int courseID);
}
