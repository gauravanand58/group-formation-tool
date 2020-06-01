package com.advsdc.group4.UserProfile.dao;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.IUserAuth;

public interface IUserProfileDao {
	public void loadUserWithID(String bannerID, IUser user);
	
	
}
