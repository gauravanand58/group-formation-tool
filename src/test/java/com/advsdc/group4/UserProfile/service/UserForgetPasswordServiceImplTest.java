package com.advsdc.group4.UserProfile.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Model.UserAuth;
import com.advsdc.group4.UserProfile.dao.IUserAuthDao;
import com.advsdc.group4.UserProfile.dao.IUserProfileDao;
import com.advsdc.group4.UserProfile.dao.MockUserAuthDao;
import com.advsdc.group4.UserProfile.dao.MockUserProfileDao;

public class UserForgetPasswordServiceImplTest {

	@Test
	public void getUserInfoTest() {
		String bannerID = "B00835818";
		IUserProfileDao userDao = new MockUserProfileDao();
		UserForgetPasswordServiceImpl impl = new UserForgetPasswordServiceImpl();
		User user = impl.getUserInfo(bannerID, userDao);
		assertEquals("srikrishna.sasidharan@dal.ca", user.getEmail());
		
	}

	@Test
	public void getUserAuthInfoTest() {
		String bannerID = "B00835818";
		IUserAuthDao userDao = new MockUserAuthDao();
		UserForgetPasswordServiceImpl impl = new UserForgetPasswordServiceImpl();
		UserAuth user = impl.getUserAuthInfo(bannerID, userDao);
		assertEquals("AA123", user.getPassword());		
	}

	@Test
	public void generateOtpTest() {
		UserForgetPasswordServiceImpl impl = new UserForgetPasswordServiceImpl();
		String bannerID = "B00835818";
		IUserAuthDao userDao = new MockUserAuthDao();
		UserAuth user = impl.getUserAuthInfo(bannerID, userDao);		
		boolean val = impl.generateOtp("testg@gmail.com", user, userDao);
		assertTrue(val);
	}

	
	@Test
	public void validateOTPTest() {
		UserForgetPasswordServiceImpl impl = new UserForgetPasswordServiceImpl();
		String otp = "A12d";
		String bannerID="B00835818";
		IUserAuthDao userDao = new MockUserAuthDao();
		boolean result = impl.validateOTP(otp, bannerID, userDao);
		assertTrue(result);
	}

	@Test
	public void checkExpirationTest() {
		UserForgetPasswordServiceImpl impl = new UserForgetPasswordServiceImpl();
		String bannerID = "B00835818";
		IUserAuthDao userDao = new MockUserAuthDao();
		boolean result = impl.checkExpiration(bannerID, userDao);
		assertTrue(result);
		
	}

	@Test
	public void userResetPasswordTest() {
		UserForgetPasswordServiceImpl impl = new UserForgetPasswordServiceImpl();
		String bannerId  = "B00835818";
		String password = "AA123";
		IUserAuthDao userDao = new MockUserAuthDao();
		boolean result = impl.userResetPassword(bannerId, password, userDao);
		assertTrue(result);
		
	}
	
}
