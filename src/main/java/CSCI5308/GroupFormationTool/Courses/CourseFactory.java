package CSCI5308.GroupFormationTool.Courses;

public class CourseFactory implements CourseAbstractFactory {

	@Override
	public ICourse createFacCourse() {
		return new Course();
	}

}
