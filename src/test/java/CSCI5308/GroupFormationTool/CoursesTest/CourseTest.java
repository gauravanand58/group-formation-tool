package CSCI5308.GroupFormationTool.CoursesTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

class CourseTest {
	@Test
	public void ConstructorTests() {
		Course course = new Course();
		assertTrue(course.getId() == -1);
		assertTrue(course.getTitle().isEmpty());

		ICoursePersistence courseDB = new CourseDBMock();
		course = new Course(0, courseDB);
		assertTrue(course.getId() == 0);
		assertTrue(course.getTitle().equals("Software Engineering"));
	}

	@Test
	public void setIdTest() {
		Course course = new Course();
		course.setId(7);
		assertTrue(course.getId() == 7);
	}

	@Test
	public void getIdTest() {
		Course course = new Course();
		course.setId(7);
		assertTrue(course.getId() == 7);
	}

	@Test
	public void setTitleTest() {
		Course course = new Course();
		course.setTitle("Advanced Topics in Software Development");
		assertTrue(course.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void getTitleTest() {
		Course course = new Course();
		course.setTitle("Advanced Topics in Software Development");
		assertTrue(course.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void deleteCourseTest() {
		ICoursePersistence courseDB = new CourseDBMock();
		boolean status = courseDB.deleteCourse(0);
		assertTrue(status);
	}

	@Test
	public void createCourseTest() {
		ICoursePersistence courseDB = new CourseDBMock();
		Course course = new Course();
		course.setId(0);
		course.setTitle("Software Engineering");
		courseDB.createCourse(course);
		assertTrue(course.getId() == 0);
		assertTrue(course.getTitle().equals("Software Engineering"));
	}
}
