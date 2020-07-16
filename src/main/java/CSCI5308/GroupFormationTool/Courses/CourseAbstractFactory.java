package CSCI5308.GroupFormationTool.Courses;

public abstract class CourseAbstractFactory {
	private static CourseAbstractFactory uniqueInstance = null;

	protected CourseAbstractFactory() {
	}

	public static CourseAbstractFactory instance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CourseFactory();
		}
		return uniqueInstance;
	}

	public void setFactory(CourseAbstractFactory factory) {
		uniqueInstance = factory;
	}

	public CourseAbstractFactory getFactory() {
		return uniqueInstance;
	}

	public abstract ICourse makeCourse();

	public abstract ICourse makeCourseWithID(long id, ICoursePersistence courseDB);

	public abstract ICoursePersistence makeCourseDB();

	public abstract ICourseUserRelationship makeCourseUserRelationship();

	public abstract ICourseUserRelationshipPersistence makeCourseUserRelationshipDB();
}
