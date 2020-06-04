package com.advsdc.group4.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.AdminUser;

public class AdminUserTest {
	@Test
	void getfNameTest() {
		AdminUser user = new AdminUser();
		user.setfName("Aaron");
		assertTrue(user.getfName().equals("Aaron"));
	}

	@Test
	void setfNameTest() {
		AdminUser user = new AdminUser();
		user.setfName("Aaron");
		assertTrue(user.getfName().equals("Aaron"));
	}
	
	@Test
	void getlNameTest() {
		AdminUser user = new AdminUser();
		user.setlName("Kelly");
		assertTrue(user.getlName().equals("Kelly"));
	}

	@Test
	void setlNameTest() {
		AdminUser user = new AdminUser();
		user.setlName("Kelly");
		assertTrue(user.getlName().equals("Kelly"));
	}
	
	@Test
	void getbIdTest() {
		AdminUser user = new AdminUser();
		user.setbId("B00818181");
		assertTrue(user.getbId().equals("B00818181"));
	}

	@Test
	void setbIdTest() {
		AdminUser user = new AdminUser();
		user.setbId("B00818181");
		assertTrue(user.getbId().equals("B00818181"));
	}

	
}
