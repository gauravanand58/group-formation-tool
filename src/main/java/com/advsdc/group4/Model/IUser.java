package com.advsdc.group4.Model;

public interface IUser {
	public String getFirstName();
	
	public void setFirstName(String firstName);
	
	public String getLastName();
	
	public void setLastName(String lastName);
	
	public String getEmail();
	
	public void setEmail(String email);
	
	public String getBannerID();
	
	public void setBannerID(String bannerID);
	
	public String getPassword();
	
	public void setPassword(String password);

	public int getRole();

	public void setRole(int role);
}
