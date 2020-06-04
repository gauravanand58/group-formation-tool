package com.advsdc.group4.UserProfile.dao;

import com.advsdc.group4.Model.IUser;

public class MockSignUpDao implements ISignUpDao{

	private int insertCount;
	
	@Override
	public boolean addUser(IUser user) {
		setInsertCount(getInsertCount() + 1);
		return true;
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

}
