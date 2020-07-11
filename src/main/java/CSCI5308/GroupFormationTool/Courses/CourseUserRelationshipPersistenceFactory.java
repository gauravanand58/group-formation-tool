package CSCI5308.GroupFormationTool.Courses;

public class CourseUserRelationshipPersistenceFactory implements CourseUserRelationshipPersistenceAbstractFactory {

	@Override
	public ICourseUserRelationshipPersistence createcourseUserRelationshipDB() {
		return new CourseUserRelationshipDB();
	}

}
