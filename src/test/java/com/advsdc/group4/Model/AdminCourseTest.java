package com.advsdc.group4.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.AdminCourse;

public class AdminCourseTest {

	@Test
	void getCourseIdTest() {
		AdminCourse course = new AdminCourse();
		course.setCourseId("5409");
		assertTrue(course.getCourseId().equals("5409"));
	}

	@Test
	void setCourseIdTest() {
		AdminCourse course = new AdminCourse();
		course.setCourseId("5409");
		assertTrue(course.getCourseId().equals("5409"));
	}

	@Test
	void getCourseNameTest() {
		AdminCourse course = new AdminCourse();
		course.setCourseName("advanced Topics in web");
		assertTrue(course.getCourseName().equals("advanced Topics in web"));
	}

	@Test
	void setCourseNameTest() {
		AdminCourse course = new AdminCourse();
		course.setCourseName("advanced Topics in web");
		assertTrue(course.getCourseName().equals("advanced Topics in web"));
	}

}
