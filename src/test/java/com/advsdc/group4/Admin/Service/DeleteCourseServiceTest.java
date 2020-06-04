package com.advsdc.group4.Admin.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Admin.service.DeleteCourseService;
import com.advsdc.group4.Admin.service.DeleteCourseServiceImpl;
import com.advsdc.group4.Model.AdminCourse;

public class DeleteCourseServiceTest{
	
	
	DeleteCourseService deleteCourseDao = mock(DeleteCourseServiceImpl.class);
	AdminCourse course;
	ArrayList<String> arrayList = new ArrayList<String>();

	public DeleteCourseServiceTest() {
		course = new AdminCourse();
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