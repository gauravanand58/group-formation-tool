package CSCI5308.GroupFormationTool.CoursesTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

class CourseTest {
	@Test
	public void ConstructorTests() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		assertTrue(course.getId() == -1);
		assertTrue(course.getTitle().isEmpty());

		ICoursePersistence courseDB = CourseTestSystemConfig.instance().getCourseDBMock();
		course = CourseAbstractFactory.instance().makeCourseWithID(0, courseDB);
		assertTrue(course.getId() == 0);
		assertTrue(course.getTitle().equals("Software Engineering"));
	}

	@Test
	public void setIdTest() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		course.setId(7);
		assertTrue(course.getId() == 7);
	}

	@Test
	public void getIdTest() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		course.setId(7);
		assertTrue(course.getId() == 7);
	}

	@Test
	public void setTitleTest() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		course.setTitle("Advanced Topics in Software Development");
		assertTrue(course.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void getTitleTest() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		course.setTitle("Advanced Topics in Software Development");
		assertTrue(course.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void deleteCourseTest() {
		ICoursePersistence courseDB = CourseTestSystemConfig.instance().getCourseDBMock();
		boolean status = courseDB.deleteCourse(0);
		assertTrue(status);
	}

	@Test
	public void createCourseTest() {
		ICoursePersistence courseDB = CourseTestSystemConfig.instance().getCourseDBMock();
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		course.setId(0);
		course.setTitle("Software Engineering");
		courseDB.createCourse(course);
		assertTrue(course.getId() == 0);
		assertTrue(course.getTitle().equals("Software Engineering"));
	}
}
