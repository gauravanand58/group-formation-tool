package com.advsdc.group4.UserHome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.UserHome.Dao.MockUserHomeDao;
import com.advsdc.group4.UserHome.dao.IUserHomeDao;

public class UserHomeServiceImplTest {

	@Test
	public void loadUserCourseMapTest() {
		IUserHomeDao mockUserHomeDao = new MockUserHomeDao();
		User user = new User("B000000", mockUserHomeDao);
		Map<Integer, List<Integer>> roleMap = user.getRoleMap();
		assertEquals(-1, roleMap.get(-1).get(0));
	}
	
	@Test
	public void getAllCoursesTest() {
		IUserHomeDao mockUserHomeDao = new MockUserHomeDao();
		assertEquals(2, mockUserHomeDao.getAllCourses().size());
	}
	
	@Test
	public void getCourseName() {
		IUserHomeDao mockUserHomeDao = new MockUserHomeDao();
		assertEquals("TestCourseName", mockUserHomeDao.getCourseName(1));
	}
}
