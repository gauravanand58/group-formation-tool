package com.advsdc.group4.UserProfile.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.advsdc.group4.Model.IUser;

public class MockUserProfileDao implements IUserProfileDao {
	private String firstName;
	private String lastName;
	private String email;
	private String bannerID;
	private String password;
	private Map<Integer, List<Integer>> roleMap;
	
	public MockUserProfileDao() {
		setToDefault();
	}

	@Override
	public void loadUserWithID(String bannerID, IUser user) {
		user.setBannerID(this.bannerID);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setRoleMap(roleMap);
		user.setPassword(password);
	}
	
	public void setToDefault()
	{
		firstName = "Srikrishna";
		lastName = "Sasidharan";
		email = "srikrishna.sasidharan@dal.ca";
		bannerID = "B00835818";
		password = "password";
		roleMap = createRoleMap();
	}
	
	private Map<Integer, List<Integer>> createRoleMap() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> courseList = new LinkedList<>();
		courseList.add(-1);
		map.put(-1, courseList);
		return map;
	}

}
