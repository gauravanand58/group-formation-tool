package com.advsdc.group4.GetTA.dao;

public interface GetTADao {
	public String getUser(String bannerID,int courseID);
	public Boolean insertTA(String bannerID,int courseID);
	
}
