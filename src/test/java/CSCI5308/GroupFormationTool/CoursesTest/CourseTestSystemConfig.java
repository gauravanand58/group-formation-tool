package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.CourseFactory;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;

public class CourseTestSystemConfig {
	private static CourseTestSystemConfig uniqueInstance = null;

	private ICoursePersistence courseDBMock;
	private ICourseUserRelationshipPersistence courseUserRelationshipDBMock;
	private CourseFactory courseFactoryMock;

	private CourseTestSystemConfig() {
		courseDBMock = new CourseDBMock();
		courseUserRelationshipDBMock = new CourseUserRelationshipDBMock();
	}

	public static CourseTestSystemConfig instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new CourseTestSystemConfig();
		}
		return uniqueInstance;
	}

	public ICoursePersistence getCourseDBMock() {
		return courseDBMock;
	}

	public void setCourseDBMock(ICoursePersistence courseDBMock) {
		this.courseDBMock = courseDBMock;
	}

	public ICourseUserRelationshipPersistence getCourseUserRelationshipDBMock() {
		return courseUserRelationshipDBMock;
	}

	public void setCourseUserRelationshipDBMock(ICourseUserRelationshipPersistence courseUserRelationshipDBMock) {
		this.courseUserRelationshipDBMock = courseUserRelationshipDBMock;
	}

	public CourseFactory getCourseFactoryMock() {
		return courseFactoryMock;
	}

	public void setCourseFactoryMock(CourseFactory courseFactoryMock) {
		this.courseFactoryMock = courseFactoryMock;
	}
}
