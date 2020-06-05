package com.advsdc.group4.UserProfile.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.UserProfile.dao.IUserAuthDao;
import com.advsdc.group4.UserProfile.dao.MockUserAuthDao;

public class UserAuthServiceTest {
	
	@Test
	public void validateUserCredentialsTest() {
		String username = "B00835818";
		String password = "AA123";
		IUserAuthDao authDao =  new MockUserAuthDao();
		UserAuthServiceImpl authServiceImpl =new UserAuthServiceImpl();
		assertTrue(authServiceImpl.validateUserCredentials(username, password,authDao));		
		
	}
	
	@Test
	public void fetchUserRolesTest() {
		String username = "B00835818";
		IUserAuthDao authDao =  new MockUserAuthDao();
		UserAuthServiceImpl authServiceImpl =new UserAuthServiceImpl();
		assertEquals("Guest", authServiceImpl.fetchUserRoles(username, authDao).get(0));		
		
	}


}
