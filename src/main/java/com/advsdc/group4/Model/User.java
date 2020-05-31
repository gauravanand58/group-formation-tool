package com.advsdc.group4.Model;

import com.advsdc.group4.UserProfile.dao.IUserProfileDao;

public class User implements IUser {
	
	private int role;
	private String firstName;
	private String lastName;
	private String email;
	private String bannerID;
	private String password;
	
	public User() {
	}
	
	public User(String bannerID, IUserProfileDao iUserDao) {
		iUserDao.loadUserWithID(bannerID, this);
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
