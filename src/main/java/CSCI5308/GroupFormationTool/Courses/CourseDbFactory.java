package CSCI5308.GroupFormationTool.Courses;

public class CourseDbFactory implements CoursePersistenceAbstractFactory {

	@Override
	public ICoursePersistence createCourseDB() {
		return new CourseDB();
	}

}
