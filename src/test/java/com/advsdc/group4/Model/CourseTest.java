package com.advsdc.group4.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.Course;

public class CourseTest {

	@Test
	void getCourseIDTest() {
		Course course = new Course();
		course.setCourseID(5409);
		assertEquals(Integer.valueOf(5409), course.getCourseID());
	}

	@Test
	void setCourseIDTest() {
		Course course = new Course();
		course.setCourseID(5409);
		assertEquals(Integer.valueOf(5409), course.getCourseID());
	}

	@Test
	void getCourseNameTest() {
		Course course = new Course();
		course.setCourseName("advanced Topics in web");
		assertTrue(course.getCourseName().equals("advanced Topics in web"));
	}

	@Test
	void setCourseNameTest() {
		Course course = new Course();
		course.setCourseName("advanced Topics in web");
		assertTrue(course.getCourseName().equals("advanced Topics in web"));
	}
	
	@Test
	void getCourseDescriptionTest() {
		Course course = new Course();
		course.setCourseDescription("Course includes object oriented concepts.");
		assertTrue(course.getCourseDescription().equals("Course includes object oriented concepts."));
	}

	@Test
	void setCourseDescriptionTest() {
		Course course = new Course();
		course.setCourseDescription("Course includes object oriented concepts.");
		assertTrue(course.getCourseDescription().equals("Course includes object oriented concepts."));
	}
}
