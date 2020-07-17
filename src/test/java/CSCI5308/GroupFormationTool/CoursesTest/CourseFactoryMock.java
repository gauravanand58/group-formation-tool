package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.CourseUserRelationship;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationship;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;

public class CourseFactoryMock extends CourseAbstractFactory {

	@Override
	public ICourse makeCourse() {
		return new Course();
	}

	@Override
	public ICourse makeCourseWithID(long id, ICoursePersistence courseDB) {
		return new Course(id,courseDB);
	}

	@Override
	public ICoursePersistence makeCourseDB() {
		return new CourseDBMock();
	}

	@Override
	public ICourseUserRelationship makeCourseUserRelationship() {
		return new CourseUserRelationship();
	}

	@Override
	public ICourseUserRelationshipPersistence makeCourseUserRelationshipDB() {
		return new CourseUserRelationshipDBMock();
	}
}
