package com.advsdc.group4.Signup.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.dao.test.SignUpDaoMock;

public class SignUpServiceImplTest {

	@Test
	public void addUserToDBTest() {
		SignUpDaoMock daoMock = new SignUpDaoMock();
		User user = new User();
		daoMock.addUser(user);
		assertEquals(1, daoMock.getInsertCount());
		assertEquals("INSERT INTO Users (BannerID, FName, LName, Email) "+
				" VALUES (?,?,?,?)", daoMock.getQuery());
	}
	
	@Test
	public void userExistsTest() {
		User user = new User();
		SignUpDaoMock daoMock = new SignUpDaoMock();
		daoMock.userExists(user);
		assertEquals("fName", user.getFirstName());
		assertEquals("SELECT * from Users where BannerID = ?", daoMock.getQuery());
	}
}
