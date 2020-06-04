package com.advsdc.group4.Model;

import java.sql.Timestamp;


import com.advsdc.group4.UserProfile.dao.IUserAuthDao;

public class UserAuth implements IUserAuth{
	String bannerID;
	String password;
	String otp;
	Timestamp timestamp;
	
	public UserAuth() {}
	
	public UserAuth(String bannerID,IUserAuthDao authDao) {
		authDao.loadUserAuth(bannerID, this);
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
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
