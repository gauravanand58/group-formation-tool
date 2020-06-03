package com.advsdc.group4.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.advsdc.group4.UserHome.dao.IUserHomeDao;
import com.advsdc.group4.UserProfile.dao.ISignUpDao;
import com.advsdc.group4.UserProfile.dao.IUserProfileDao;

public class User implements IUser{
	
	private String firstName;
	private String lastName;
	private String email;
	private String bannerID;
	private String password;
	private Map<Integer, List<Integer>> roleMap;
	
	public User() {
		setRoleMap(new HashMap<>());
	}
	
	public User(String bannerID, IUserProfileDao iUserDao) {
		iUserDao.loadUserWithID(bannerID, this);
	}
	
	public User(String bannerID, ISignUpDao signUpDao) {
		signUpDao.loadUserWithID(bannerID, this);
	}
	
	public User(String bannerID, IUserHomeDao userHomeDao) {
		userHomeDao.loadUserCourseMap(bannerID, this);
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBannerID() {
		return bannerID;
	}
	
	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Map<Integer, List<Integer>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<Integer, List<Integer>> roleMap) {
		this.roleMap = roleMap;
	}
}
