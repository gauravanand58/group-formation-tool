package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationship;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;

public class CourseFactoryMock extends CourseAbstractFactory {

	@Override
	public ICourse makeCourse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICourse makeCourseWithID(long id, ICoursePersistence courseDB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICoursePersistence makeCourseDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICourseUserRelationship makeCourseUserRelationship() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICourseUserRelationshipPersistence makeCourseUserRelationshipDB() {
		// TODO Auto-generated method stub
		return null;
	}

}
