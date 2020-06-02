package com.advsdc.group4.UserHome.dao;

import com.advsdc.group4.Model.IUser;

public interface IUserHomeDao {

	public void loadUserWithID(String bannerID, IUser user);
	
	public void loadUserCourseMap(IUser user);
	
}
