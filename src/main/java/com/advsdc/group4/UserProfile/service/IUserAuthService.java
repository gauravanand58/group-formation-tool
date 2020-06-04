package com.advsdc.group4.UserProfile.service;

import java.util.List;

import com.advsdc.group4.UserProfile.dao.IUserAuthDao;

public interface IUserAuthService {
	public boolean validateUserCredentials(String username, String password, IUserAuthDao authDao);
	
	public List<String> fetchUserRoles(String username, IUserAuthDao authDao);
}
