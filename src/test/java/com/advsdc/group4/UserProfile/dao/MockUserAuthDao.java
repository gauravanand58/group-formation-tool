package com.advsdc.group4.UserProfile.dao;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.advsdc.group4.Model.IUserAuth;
import com.advsdc.group4.Model.UserAuth;


public class MockUserAuthDao implements IUserAuthDao{
	String bannerID;
	String password;
	String otp;
	Timestamp timestamp;
	public MockUserAuthDao() {
		setToDefault();
	}

	@Override
	public void loadUserAuth(String bannerID, IUserAuth userAuth) {
		userAuth.setBannerID(bannerID);
		userAuth.setOtp(otp);
		userAuth.setPassword(password);
		userAuth.setTimestamp(timestamp);
	}

	public void setToDefault()
	{
		password = "AA123";
		otp = "A12d";
		timestamp = Timestamp.from(Instant.now());
		bannerID = "B00835818";
	}

	@Override
	public int saveOtp(UserAuth userAuth) {
		return 1;
	}

	@Override
	public int userResetPassword(UserAuth userAuth) {
		return 1;
	}

	@Override
	public boolean validateUserCredentials(String username, String password) {
		return true;
	}

	@Override
	public List<String> fetchUserRoles(String username) {
		List<String> roles = new ArrayList<String>();
		roles.add("Guest");
		return roles;
	}

}
