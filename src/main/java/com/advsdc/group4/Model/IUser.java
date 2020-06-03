package com.advsdc.group4.Model;

import java.util.List;
import java.util.Map;

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
	
	public Map<Integer, List<Integer>> getRoleMap();

	public void setRoleMap(Map<Integer, List<Integer>> roleMap);
}
