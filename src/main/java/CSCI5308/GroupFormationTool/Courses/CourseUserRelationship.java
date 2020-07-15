package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Questions.IQuestion;

public class CourseUserRelationship implements ICourseUserRelationship {
	public boolean userHasRoleInCourse(User user, Role role, ICourse course) {
		if (null == user || !user.isValidUser()) {
			return false;
		}
		if (null == role) {
			return false;
		}
		if (null == course) {
			return false;
		}
		ICourseUserRelationshipPersistence userCourseRelationshipDB = CourseSystemConfig.instance()
				.getCourseUserRelationshipDB();
		List<Role> roles = userCourseRelationshipDB.loadUserRolesForCourse(course, user);
		if (null != roles && roles.contains(role)) {
			return true;
		}
		return false;
	}

	public List<Role> loadAllRoluesForUserInCourse(User user, ICourse course) {
		ICourseUserRelationshipPersistence userCourseRelationshipDB = CourseSystemConfig.instance()
				.getCourseUserRelationshipDB();
		List<Role> roles = userCourseRelationshipDB.loadUserRolesForCourse(course, user);
		return roles;
	}

	public boolean enrollUserInCourse(User user, ICourse course, Role role) {
		ICourseUserRelationshipPersistence userCourseRelationshipDB = CourseSystemConfig.instance()
				.getCourseUserRelationshipDB();
		return userCourseRelationshipDB.enrollUser(course, user, role);
	}
	
	public User findInstructorWithCourse(long courseId){
		ICourseUserRelationshipPersistence userCourseRelationshipDB = CourseSystemConfig.instance()
				.getCourseUserRelationshipDB();
		List<User> usersList = userCourseRelationshipDB.findAllUsersWithCourseRole(Role.INSTRUCTOR, courseId);
		if(usersList.size() == 0) {
			return null;
		}
		return usersList.get(0);
	}
}