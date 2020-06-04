package com.advsdc.group4.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.UserProfile.dao.MockUserProfileDao;

public class UserTest {
	
	@Test
	public void getFirstNameTest() {
		MockUserProfileDao mockUserProfileDao = new MockUserProfileDao();
		User user = new User("B00835818", mockUserProfileDao);
		assertEquals("Srikrishna", user.getFirstName());
	}
	
	@Test
	public void setFirstNameTest() {
		User user = new User();
		user.setFirstName("Srikrishna");
		assertEquals("Srikrishna", user.getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		MockUserProfileDao mockUserProfileDao = new MockUserProfileDao();
		User user = new User("B00835818", mockUserProfileDao);
		assertEquals("Sasidharan", user.getLastName());
	}
	
	@Test
	public void setLastNameTest() {
		User user = new User();
		user.setLastName("Sasidharan");
		assertEquals("Sasidharan", user.getLastName());
	}
	
	@Test
	public void getEmailTest() {
		MockUserProfileDao mockUserProfileDao = new MockUserProfileDao();
		User user = new User("B00835818", mockUserProfileDao);
		assertEquals("srikrishna.sasidharan@dal.ca", user.getEmail());
	}
	
	@Test
	public void setEmailTest() {
		User user = new User();
		user.setEmail("srikrishna.sasidharan@dal.ca");
		assertEquals("srikrishna.sasidharan@dal.ca", user.getEmail());
	}
	
	@Test
	public void getBannerIDTest() {
		MockUserProfileDao mockUserProfileDao = new MockUserProfileDao();
		User user = new User("B00835818", mockUserProfileDao);
		assertEquals("B00835818", user.getBannerID());
	}
	
	@Test
	public void setBannerIDTest() {
		User user = new User();
		user.setBannerID("B00835818");
		assertEquals("B00835818", user.getBannerID());
	}
	
	@Test
	public void getPasswordTest() {
		MockUserProfileDao mockUserProfileDao = new MockUserProfileDao();
		User user = new User("B00835818", mockUserProfileDao);
		assertEquals("password", user.getPassword());
	}
	
	@Test
	public void setPasswordTest() {
		User user = new User();
		user.setPassword("password");
		assertEquals("password", user.getPassword());
	}
	
	@Test
	public void getRoleMapTest() {
		MockUserProfileDao mockUserProfileDao = new MockUserProfileDao();
		User user = new User("B00835818", mockUserProfileDao);
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
