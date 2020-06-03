package com.advsdc.group4.BusinessObjectModelsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.BusinessObjectModels.Course;

public class CourseTest {

	@Test
	void getCourseIdTest() {
		Course course = new Course();
		course.setCourseId("5409");
		assertTrue(course.getCourseId().equals("5409"));
	}

	@Test
	void setCourseIdTest() {
		Course course = new Course();
		course.setCourseId("5409");
		assertTrue(course.getCourseId().equals("5409"));
	}

	@Test
	void getCourseNameTest() {
		Course course = new Course();
		course.setCourseName("advanced Topics in web");
		assertTrue(course.getCourseName().equals("advanced Topis in web"));
	}

	@Test
	void setCourseNameTest() {
		Course course = new Course();
		course.setCourseName("advanced Topics in web");
		assertTrue(course.getCourseName().equals("advanced Topis in web"));
	}

}
