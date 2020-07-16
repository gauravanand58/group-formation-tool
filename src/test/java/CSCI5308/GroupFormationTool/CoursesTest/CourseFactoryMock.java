package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationship;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;

public class CourseFactoryMock extends CourseAbstractFactory {

	@Override
	public ICourse makeCourse() {
		return null;
	}

	@Override
	public ICourse makeCourseWithID(long id, ICoursePersistence courseDB) {
		return null;
	}

	@Override
	public ICoursePersistence makeCourseDB() {
		return null;
	}

	@Override
	public ICourseUserRelationship makeCourseUserRelationship() {
		return null;
	}

	@Override
	public ICourseUserRelationshipPersistence makeCourseUserRelationshipDB() {
		return null;
	}

}
