package com.advsdc.group4.Admin.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Admin.service.AddCourseService;
import com.advsdc.group4.Admin.service.AddCourseServiceImpl;
import com.advsdc.group4.Model.Course;

public class AddCourseServiceTest {

	AddCourseService addCourseDao = mock(AddCourseServiceImpl.class);
	Course course;

	public AddCourseServiceTest() {
		course = new Course();
		course.setCourseId("5709");
		course.setCourseName("Adv. topics in applied computing");

	}

	@Test
	public void testAddCourse() {
		when(addCourseDao.addCourse(course)).thenReturn("Course added successfully");
		assertEquals(addCourseDao.addCourse(course), "Course added successfully");
		verify(addCourseDao).addCourse(course);
	}

	@Test
	public void testCourseExists() {
		when(addCourseDao.addCourse(course)).thenReturn("Course with same course ID already exists");
		assertEquals(addCourseDao.addCourse(course), "Course with same course ID already exists");
		verify(addCourseDao).addCourse(course);
	}

}
