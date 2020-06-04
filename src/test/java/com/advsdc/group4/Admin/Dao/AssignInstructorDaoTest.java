package com.advsdc.group4.Admin.Dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import com.advsdc.group4.Admin.dao.AssignInstructorDao;
import com.advsdc.group4.Admin.dao.AssignInstructorDaoImpl;
import com.advsdc.group4.Model.AdminCourse;
import com.advsdc.group4.Model.AdminUser;

public class AssignInstructorDaoTest {

	AssignInstructorDao assignInstructorDao = mock(AssignInstructorDaoImpl.class);
	AdminCourse course;
	AdminUser user;

	public AssignInstructorDaoTest() {
		course = new AdminCourse();
		course.setCourseId("5709");
		course.setCourseName("Adv. topics in applied computing");

		user = new AdminUser();
		user.setbId("B00858585");
		user.setfName("Raymond");
		user.setlName("Johnson");
	}

	@Test
	public void assignInstructorTest() {
		when(assignInstructorDao.assignInstructor(course.getCourseId(), user.getbId()))
				.thenReturn("Instructor added successfully");
		assertEquals(assignInstructorDao.assignInstructor(course.getCourseId(), user.getbId()),
				"Instructor added successfully");
		verify(assignInstructorDao).assignInstructor(course.getCourseId(), user.getbId());
	}
}
