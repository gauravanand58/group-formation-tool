package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.User;

public interface ICourseUserRelationship {
	public boolean userHasRoleInCourse(IUser user, Role role, ICourse course);

	public List<Role> loadAllRoluesForUserInCourse(IUser user, ICourse course);

	public boolean enrollUserInCourse(IUser user, ICourse course, Role role);
	
	public IUser findInstructorWithCourse(long courseId);
}
