package CSCI5308.GroupFormationTool.CoursesTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationship;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;

public class CourseFactoryTest {
	@Test
	public void makeCourse() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		assertTrue(null != course);
	}

	@Test
	public void makeCourseDB() {
		ICoursePersistence courseDB = CourseAbstractFactory.instance().makeCourseDB();
		assertTrue(null != courseDB);
	}

	@Test
	public void makeCourseUserRelationship() {
		ICourseUserRelationship courseUserRelationship = CourseAbstractFactory.instance().makeCourseUserRelationship();
		assertTrue(null != courseUserRelationship);
	}

	@Test
	public void makeCourseUserRelationshipDB() {
		ICourseUserRelationshipPersistence courseUserRelationshipPersistence = CourseAbstractFactory.instance()
				.makeCourseUserRelationshipDB();
		assertTrue(null != courseUserRelationshipPersistence);
	}

	@Test
	public void makeCourseWithID() {
		ICoursePersistence courseDBMock = CourseTestSystemConfig.instance().getCourseDBMock();
		ICourse course = CourseAbstractFactory.instance().makeCourseWithID(1L, courseDBMock);
		assertTrue(null != course);
	}
}
