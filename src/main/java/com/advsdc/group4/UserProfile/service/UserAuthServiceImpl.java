package com.advsdc.group4.UserProfile.service;

import java.util.List;

import com.advsdc.group4.UserProfile.dao.IUserAuthDao;

public class UserAuthServiceImpl implements IUserAuthService {
	public boolean validateUserCredentials(String username, String password, IUserAuthDao authDao) {
		return authDao.validateUserCredentials(username, password);		
		
	}

	@Override
	public List<String> fetchUserRoles(String username, IUserAuthDao authDao) {
		return authDao.fetchUserRoles(username);
	}
}
