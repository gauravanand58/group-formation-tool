package CSCI5308.GroupFormationTool.Courses;

public interface CourseAbstractFactory {
	public ICourse createFacCourse();

	public ICourse createFacCourse(long id, ICoursePersistence courseDB);
	
}
