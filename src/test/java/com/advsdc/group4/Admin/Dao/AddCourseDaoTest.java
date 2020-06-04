package com.advsdc.group4.Admin.Dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Admin.dao.AddCourseDao;
import com.advsdc.group4.Admin.dao.AddCourseDaoImpl;
import com.advsdc.group4.Model.Course;

public class AddCourseDaoTest{
	
	AddCourseDao addCourseDao = mock(AddCourseDaoImpl.class);
	Course course;

	public AddCourseDaoTest() {
		course = new Course();
		course.setCourseName("Adv. topics in applied computing");
		course.setCourseDescription("Gradruate Course");

	}
	
	@Test
	public void testAddCourse() {
		when(addCourseDao.addCourse(course)).thenReturn("Course added successfully");
		assertEquals(addCourseDao.addCourse(course),"Course added successfully");
		verify(addCourseDao).addCourse(course);
	}
	
	@Test
	public void testCourseExists() {
		when(addCourseDao.addCourse(course)).thenReturn("Course with same course ID already exists");
		assertEquals(addCourseDao.addCourse(course),"Course with same course ID already exists");
		verify(addCourseDao).addCourse(course);
	}

}
