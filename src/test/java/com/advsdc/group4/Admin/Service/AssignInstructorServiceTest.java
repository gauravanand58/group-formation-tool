package com.advsdc.group4.Admin.Service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.advsdc.group4.Admin.service.AssignInstructorService;
import com.advsdc.group4.Admin.service.AssignInstructorServiceImpl;
import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.User;

@RunWith(MockitoJUnitRunner.class)
public class AssignInstructorServiceTest {

	AssignInstructorService assignInstructorDao = mock(AssignInstructorServiceImpl.class);
	Course course;
	User user;

	public AssignInstructorServiceTest() {
		course = new Course();
		course.setCourseId("5709");
		course.setCourseName("Adv. topics in applied computing");

		user = new User();
		user.setbId("B00858585");
		user.setfName("Raymond");
		user.setlName("Johnson");
	}



	@Test
	public void assignInstructorTest() {
		when(assignInstructorDao.assignInstructor(course.getCourseId(), user.getbId())).thenReturn("Instructor added successfully");
		assertEquals(assignInstructorDao.assignInstructor(course.getCourseId(), user.getbId()), "Instructor added successfully");
		verify(assignInstructorDao).assignInstructor(course.getCourseId(), user.getbId());
	}
}


