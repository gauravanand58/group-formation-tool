package com.advsdc.group4.Signup.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.dao.SignUpDaoMock;

public class SignUpServiceImplTest {

	@Test
	public void addUserToDBTest() {
		SignUpDaoMock daoMock = new SignUpDaoMock();
		User user = new User();
		daoMock.addUser(user);
		assertEquals(1, daoMock.getInsertCount());
	}

}
