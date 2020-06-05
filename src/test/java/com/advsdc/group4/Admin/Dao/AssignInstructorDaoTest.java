package com.advsdc.group4.Admin.Dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import com.advsdc.group4.Admin.dao.AssignInstructorDao;
import com.advsdc.group4.Admin.dao.AssignInstructorDaoImpl;
import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.User;

public class AssignInstructorDaoTest {

	AssignInstructorDao assignInstructorDao = mock(AssignInstructorDaoImpl.class);
	Course course;
	User user;

	public AssignInstructorDaoTest() {
		course = new Course();
		course.setCourseID(5709);
		course.setCourseName("Adv. topics in applied computing");
		course.setCourseDescription("Gradruate Course");

		user = new User();
		user.setBannerID("B00858585");
		user.setFirstName("Raymond");
		user.setLastName("Johnson");
	}

	@Test
	public void assignInstructorTest() {
		when(assignInstructorDao.assignInstructor(course.getCourseID(), user.getBannerID()))
				.thenReturn("Instructor added successfully");
		assertEquals(assignInstructorDao.assignInstructor(course.getCourseID(), user.getBannerID()),
				"Instructor added successfully");
		verify(assignInstructorDao).assignInstructor(course.getCourseID(), user.getBannerID());
	}
}
