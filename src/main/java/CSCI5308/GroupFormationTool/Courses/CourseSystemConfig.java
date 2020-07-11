package CSCI5308.GroupFormationTool.Courses;


public class CourseSystemConfig {
	private static CourseSystemConfig uniqueInstance = null;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;

	private CourseSystemConfig() {
		courseDB = CourseObjectFactory.objDBFactory(new CourseDbFactory());
		courseUserRelationshipDB = CourseObjectFactory
				.objCourseUserRelationDBFactory(new CourseUserRelationshipPersistenceFactory());
	}

	public static CourseSystemConfig instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new CourseSystemConfig();
		}
		return uniqueInstance;
	}

	public void setCourseDB(ICoursePersistence courseDB) {
		this.courseDB = courseDB;
	}

	public ICoursePersistence getCourseDB() {
		return courseDB;
	}

	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
		this.courseUserRelationshipDB = courseUserRelationshipDB;
	}

	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB() {
		return courseUserRelationshipDB;
	}
}
