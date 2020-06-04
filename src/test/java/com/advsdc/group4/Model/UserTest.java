package com.advsdc.group4.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.UserProfile.dao.MockSignUpDao;

public class UserTest {
	
	@Test
	public void getFirstNameTest() {
		MockSignUpDao signUpDaoMock = new MockSignUpDao();
		User user = new User("B000000", signUpDaoMock);
		assertEquals("fName", user.getFirstName());
	}
	
	@Test
	public void setFirstNameTest() {
		User user = new User();
		user.setFirstName("fName");
		assertEquals("fName", user.getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		MockSignUpDao signUpDaoMock = new MockSignUpDao();
		User user = new User("B000000", signUpDaoMock);
		assertEquals("lName", user.getLastName());
	}
	
	@Test
	public void setLastNameTest() {
		User user = new User();
		user.setLastName("lName");
		assertEquals("lName", user.getLastName());
	}
	
	@Test
	public void getEmailTest() {
		MockSignUpDao signUpDaoMock = new MockSignUpDao();
		User user = new User("B000000", signUpDaoMock);
		assertEquals("test@dal.ca", user.getEmail());
	}
	
	@Test
	public void setEmailTest() {
		User user = new User();
		user.setEmail("test@dal.ca");
		assertEquals("test@dal.ca", user.getEmail());
	}
	
	@Test
	public void getBannerIDTest() {
		MockSignUpDao signUpDaoMock = new MockSignUpDao();
		User user = new User("B000000", signUpDaoMock);
		assertEquals("B000000", user.getBannerID());
	}
	
	@Test
	public void setBannerIDTest() {
		User user = new User();
		user.setBannerID("B000000");
		assertEquals("B000000", user.getBannerID());
	}
	
	@Test
	public void getPasswordTest() {
		MockSignUpDao signUpDaoMock = new MockSignUpDao();
		User user = new User("B000000", signUpDaoMock);
		assertEquals("test_password", user.getPassword());
	}
	
	@Test
	public void setPasswordTest() {
		User user = new User();
		user.setPassword("test_password");
		assertEquals("test_password", user.getPassword());
	}
	
	@Test
	public void getRoleMapTest() {
		MockSignUpDao signUpDaoMock = new MockSignUpDao();
		User user = new User("B000000", signUpDaoMock);
		assertEquals(createRoleMap(), user.getRoleMap());
	}
	
	@Test
	public void setRoleMapTest() {
		User user = new User();
		user.setRoleMap(createRoleMap());
		assertEquals(createRoleMap(), user.getRoleMap());
	}
	
	private Map<Integer, List<Integer>> createRoleMap(){
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> courseList = new LinkedList<>();
		courseList.add(-1);
		map.put(-1, courseList);
		return map;
	}
	
}
