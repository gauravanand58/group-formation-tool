package com.advsdc.group4.Signup.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.UserProfile.dao.ISignUpDao;

public class SignUpDaoMock implements ISignUpDao{

	private int insertCount;
	private String bannerID;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Map<Integer, List<Integer>> roleMap;
	
	public SignUpDaoMock() {
		bannerID = "B000000";
		email = "test@dal.ca";
		firstName = "fName";
		lastName = "lName";
		password = "test_password";
		roleMap = createRoleMap();
	}
	
	private Map<Integer, List<Integer>> createRoleMap() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> courseList = new LinkedList<>();
		courseList.add(-1);
		map.put(-1, courseList);
		return map;
	}
	
	@Override
	public boolean addUser(IUser user) {
		setInsertCount(getInsertCount() + 1);
		return false;
	}

	@Override
	public boolean userExists(IUser user) {
		if(user.getBannerID() == "B000000")
			return true;
		return false;
	}

	public int getInsertCount() {
		return insertCount;
	}

	public void setInsertCount(int insertCount) {
		this.insertCount = insertCount;
	}

	@Override
	public void loadUserWithID(String bID, IUser user) {
		user.setBannerID(bannerID);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setRoleMap(roleMap);
	}
}
