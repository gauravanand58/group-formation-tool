package com.advsdc.group4.UserHome.dao;

import java.util.List;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.IUser;

public interface IUserHomeDao {
	
	public void loadUserCourseMap(String bannerID, IUser user);

	public List<Course> getAllCourses();
	
	public String getCourseName(int courseID);
}
