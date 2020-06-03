package com.advsdc.group4.UserProfile.dao;

import com.advsdc.group4.Model.IUserAuth;
import com.advsdc.group4.Model.UserAuth;

public interface IUserAuthDao {
	public void loadUserAuth(String bannerID, IUserAuth userAuth);
	
	public int saveOtp(UserAuth userAuth);
	
	public int userResetPassword(UserAuth userAuth);

}