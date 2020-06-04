package com.advsdc.group4.Admin.Dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Admin.dao.DeleteCourseDao;
import com.advsdc.group4.Admin.dao.DeleteCourseDaoImpl;
import com.advsdc.group4.Model.Course;

public class DeleteCourseDaoTest{
	
	
	DeleteCourseDao deleteCourseDao = mock(DeleteCourseDaoImpl.class);
	Course course;
	ArrayList<Course> arrayList = new ArrayList<Course>();

	public DeleteCourseDaoTest() {
		course = new Course();
		course.setCourseId("5709");
		course.setCourseName("Adv. topics in applied computing");

	}
	
	@Test
	public void deleteCourseTest() {
		when(deleteCourseDao.deleteCourse(arrayList)).thenReturn("Course Deleted Successfully");
		assertEquals(deleteCourseDao.deleteCourse(arrayList),"Course Deleted Successfully");
		verify(deleteCourseDao).deleteCourse(arrayList);
	}
	
	

}
