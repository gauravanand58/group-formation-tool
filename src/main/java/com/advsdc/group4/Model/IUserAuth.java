package com.advsdc.group4.Model;

import java.sql.Timestamp;

public interface IUserAuth {
	public void setBannerID(String bannerID);
	public void setPassword(String password);
	public void setOtp(String otp);
	public void setTimestamp(Timestamp timestamp);
}
