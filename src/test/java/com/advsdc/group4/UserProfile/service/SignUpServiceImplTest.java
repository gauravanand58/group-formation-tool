package com.advsdc.group4.UserProfile.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.UserProfile.dao.MockSignUpDao;

public class SignUpServiceImplTest {

	@Test
	public void addUserToDBTest() {
		MockSignUpDao daoMock = new MockSignUpDao();
		User user = new User();
		user.setBannerID("B000000");
		daoMock.addUser(user);
		assertEquals(1, daoMock.getInsertCount());
		assertEquals(true, daoMock.userExists(user));
	}
}
