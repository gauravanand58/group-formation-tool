package com.advsdc.group4.BusinessObjectModelsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.BusinessObjectModels.User;

public class UserTest {
	@Test
	void getfNameTest() {
		User user = new User();
		user.setfName("Aaron");
		assertTrue(user.getfName().equals("Aaron"));
	}

	@Test
	void setfNameTest() {
		User user = new User();
		user.setfName("Aaron");
		assertTrue(user.getfName().equals("Aaron"));
	}
	
	@Test
	void getlNameTest() {
		User user = new User();
		user.setlName("Kelly");
		assertTrue(user.getlName().equals("Kelly"));
	}

	@Test
	void setlNameTest() {
		User user = new User();
		user.setlName("Kelly");
		assertTrue(user.getlName().equals("Kelly"));
	}
	
	@Test
	void getbIdTest() {
		User user = new User();
		user.setbId("B00818181");
		assertTrue(user.getbId().equals("B00818181"));
	}

	@Test
	void setbIdTest() {
		User user = new User();
		user.setbId("B00818181");
		assertTrue(user.getbId().equals("B00818181"));
	}

	
}
