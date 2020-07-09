package CSCI5308.GroupFormationTool.Courses;

public class CourseFactory extends CourseAbstractFactory{

	@Override
	public ICourse createFacCourse() {
		return new Course();
	}

}
