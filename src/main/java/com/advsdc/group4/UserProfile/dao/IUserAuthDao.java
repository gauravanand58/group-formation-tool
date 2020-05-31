package com.advsdc.group4.UserProfile.dao;

import com.advsdc.group4.Model.IUserAuth;

public interface IUserAuthDao {
	public void loadUserAuth(String bannerID, IUserAuth userAuth);
}
