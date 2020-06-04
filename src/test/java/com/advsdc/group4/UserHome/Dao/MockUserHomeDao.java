package com.advsdc.group4.UserHome.Dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.UserHome.dao.IUserHomeDao;

public class MockUserHomeDao implements IUserHomeDao{

	private Map<Integer, List<Integer>> roleMap;
	
	public MockUserHomeDao() {
		roleMap = createRoleMap();
	}
	
	private Map<Integer, List<Integer>> createRoleMap() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> courseList = new LinkedList<>();
		courseList.add(-1);
		map.put(-1, courseList);
		return map;
	}

	@Override
	public void loadUserCourseMap(String bannerID, IUser user) {
		user.setRoleMap(roleMap);
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> list = new LinkedList<>();
		list.add(new Course(1, "TestCourseName1", "TestCourseDescription1"));
		list.add(new Course(2, "TestCourseName2", "TestCourseDescription2"));
		return list;
	}

	@Override
	public String getCourseName(int courseID) {
		if(courseID == 1) {
			return "TestCourseName";
		} else {
			return "";
		}
	}
}
