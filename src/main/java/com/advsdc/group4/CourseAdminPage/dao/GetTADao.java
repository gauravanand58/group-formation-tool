package com.advsdc.group4.CourseAdminPage.dao;

import com.advsdc.group4.Model.IUser;

public interface GetTADao {
	public String getUser(IUser user,int courseID);
	public Boolean insertTA(IUser user,int courseID);
	
}
