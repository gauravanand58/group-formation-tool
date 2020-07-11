package CSCI5308.GroupFormationTool.Courses;

public class CourseObjectFactory {
	public static ICourse objFactory(CourseAbstractFactory obj) {
		return obj.createFacCourse();
	}

	public static ICoursePersistence objDBFactory(CoursePersistenceAbstractFactory obj) {
		return obj.createCourseDB();
	}

	public static ICourseUserRelationshipPersistence objCourseUserRelationDBFactory(
			CourseUserRelationshipPersistenceAbstractFactory obj) {
		return obj.createcourseUserRelationshipDB();
	}

}
