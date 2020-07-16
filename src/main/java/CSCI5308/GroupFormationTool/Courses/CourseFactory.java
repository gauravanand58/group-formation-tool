package CSCI5308.GroupFormationTool.Courses;

public class CourseFactory implements CourseAbstractFactory {

	@Override
	public ICourse createFacCourse() {
		return new Course();
	}
	
	@Override
	public ICourse createFacCourse(long id, ICoursePersistence courseDB) {
		return new Course(id, courseDB);
	}

}
