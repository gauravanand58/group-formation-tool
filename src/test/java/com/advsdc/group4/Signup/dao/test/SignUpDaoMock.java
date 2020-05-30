package com.advsdc.group4.Signup.dao.test;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.dao.SignUpDao;

public class SignUpDaoMock implements SignUpDao{

	private int insertCount;
	private String query;
	
	@Override
	public boolean addUser(User user) {
		setInsertCount(getInsertCount() + 1);
		setQuery("INSERT INTO Users (BannerID, FName, LName, Email) "+
				" VALUES (?,?,?,?)");
		return false;
	}

	@Override
	public boolean userExists(User user) {
		setQuery("SELECT * from Users where BannerID = ?");
		user.setFirstName("fName");
		return false;
	}

	public int getInsertCount() {
		return insertCount;
	}

	public void setInsertCount(int insertCount) {
		this.insertCount = insertCount;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String insertQuery) {
		this.query = insertQuery;
	}
}
