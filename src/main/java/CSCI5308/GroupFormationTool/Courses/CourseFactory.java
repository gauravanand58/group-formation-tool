package CSCI5308.GroupFormationTool.Courses;

public class CourseFactory extends CourseAbstractFactory {

	public ICourse makeCourse() {
		return new Course();
	}

	public ICoursePersistence makeCourseDB() {
		return new CourseDB();
	}

	public ICourseUserRelationship makeCourseUserRelationship() {
		return new CourseUserRelationship();
	}

	public ICourseUserRelationshipPersistence makeCourseUserRelationshipDB() {
		return new CourseUserRelationshipDB();
	}
}
