package com.advsdc.group4.Signup.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;

public class SignUpDaoImplTest {

	@Test
	public void addUserTest() {
		IUser user = new User();
		SignUpDaoMock signUpDaoMock = new SignUpDaoMock();
		signUpDaoMock.addUser(user);
		assertEquals("INSERT INTO Users (BannerID, FName, LName, Email) "+
				" VALUES (?,?,?,?)", signUpDaoMock.getQuery());
		assertEquals(1, signUpDaoMock.getInsertCount());
	}
	
	@Test
	public void userExists() {
		IUser user = new User();
		SignUpDaoMock signUpDaoMock = new SignUpDaoMock();
		signUpDaoMock.userExists(user);
		assertEquals("fName", user.getFirstName());
		assertEquals("SELECT * from Users where BannerID = ?", signUpDaoMock.getQuery());
	}
	
}
