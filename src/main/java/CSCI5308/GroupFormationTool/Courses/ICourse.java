package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface ICourse {

	public boolean delete(ICoursePersistence courseDB);

	public boolean createCourse(ICoursePersistence courseDB);

	public boolean enrollUserInCourse(Role role, User user);

	public boolean isCurrentUserEnrolledAsRoleInCourse(Role role);

	public boolean isCurrentUserEnrolledAsRoleInCourse(String role);

	public List<Role> getAllRolesForCurrentUserInCourse();

	public String getTitle();

	public void setTitle(String title);

	public void setId(long id);

	public long getId();
}
