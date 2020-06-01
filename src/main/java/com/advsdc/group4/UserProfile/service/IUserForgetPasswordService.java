package com.advsdc.group4.UserProfile.service;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Model.UserAuth;
import com.advsdc.group4.UserProfile.dao.IUserAuthDao;
import com.advsdc.group4.UserProfile.dao.IUserProfileDao;
import com.advsdc.group4.UserProfile.dao.UserAuthDaoImpl;

public interface IUserForgetPasswordService {
	public User getUserInfo(String bannerID, IUserProfileDao userDao);
	
	public UserAuth getUserAuthInfo(String bannerID,IUserAuthDao userAuthDao);
	
	public boolean generateOtp(String userEmail,UserAuth userAuth, IUserAuthDao userAuthDao);
	
	public boolean validateOTP(String otp, String bannerID, IUserAuthDao userAuthDao);
	
	public boolean checkExpiration(String bannerID, IUserAuthDao userAuthDao);
	
	public boolean userResetPassword(String bannerId,String password, IUserAuthDao userAuthDao);
}
