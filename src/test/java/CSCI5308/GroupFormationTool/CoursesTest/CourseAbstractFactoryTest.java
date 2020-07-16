package CSCI5308.GroupFormationTool.CoursesTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.CourseFactory;

public class CourseAbstractFactoryTest {
	@Test
	public void instanceTest() {
		CourseAbstractFactory instance = CourseAbstractFactory.instance();
		assertTrue(null != instance);
	}

	@Test
	public void setFactoryTest() {
		CourseAbstractFactory instance = CourseAbstractFactory.instance();
		instance.setFactory(CourseTestSystemConfig.instance().getCourseFactoryMock());
		assertFalse(instance.getFactory() instanceof CourseFactoryMock);
		instance.setFactory(new CourseFactory());
	}
}
