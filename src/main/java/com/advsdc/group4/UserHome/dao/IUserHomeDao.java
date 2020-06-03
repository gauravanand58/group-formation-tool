package com.advsdc.group4.UserHome.dao;

import com.advsdc.group4.Model.IUser;

public interface IUserHomeDao {
	
	public void loadUserCourseMap(String bannerID, IUser user);
	
}
