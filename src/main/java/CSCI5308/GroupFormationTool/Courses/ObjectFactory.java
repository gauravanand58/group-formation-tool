package CSCI5308.GroupFormationTool.Courses;

public class ObjectFactory {
	public static ICourse objFactory(CourseAbstractFactory obj) {
		return obj.createFacCourse();
	}
}
