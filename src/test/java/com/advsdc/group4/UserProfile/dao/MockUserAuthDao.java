package com.advsdc.group4.UserProfile.dao;


import java.sql.Timestamp;
import java.time.Instant;

import com.advsdc.group4.Model.IUserAuth;


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

}
