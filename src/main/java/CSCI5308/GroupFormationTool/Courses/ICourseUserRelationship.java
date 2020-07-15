package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface ICourseUserRelationship {
	public boolean userHasRoleInCourse(User user, Role role, ICourse course);

	public List<Role> loadAllRoluesForUserInCourse(User user, ICourse course);

	public boolean enrollUserInCourse(User user, ICourse course, Role role);
	
	public User findInstructorWithCourse(long courseId);
}
