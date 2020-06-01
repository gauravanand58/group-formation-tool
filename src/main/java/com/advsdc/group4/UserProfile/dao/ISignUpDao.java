package com.advsdc.group4.UserProfile.dao;

import com.advsdc.group4.Model.IUser;

public interface ISignUpDao {
	public boolean addUser(IUser user);

	public boolean userExists(IUser user);
	
	public void loadUserWithID(String bannerID, IUser user);
}
