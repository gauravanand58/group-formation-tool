package com.advsdc.group4.Signup.dao;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.dao.SignUpDao;

public class SignUpDaoMock implements SignUpDao{

	private int insertCount;
	private String bannerID;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private int role;
	
	public SignUpDaoMock() {
		bannerID = "B000000";
		email = "test@dal.ca";
		firstName = "fName";
		lastName = "lName";
		password = "test_password";
		role = -1;
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
		user.setRole(role);
	}
}
