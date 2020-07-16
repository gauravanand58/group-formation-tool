package CSCI5308.GroupFormationTool.CoursesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControlTest.CurrentUserMock;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;
import CSCI5308.GroupFormationTool.Courses.Role;

class CourseUserRelationshipTest {
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;

	public CourseUserRelationshipTest() {
		courseUserRelationshipDB = CourseTestSystemConfig.instance().getCourseUserRelationshipDBMock();
	}

	@Test
	public void userHasRoleInCourse() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		course.setId(0);
		CurrentUserMock currentUser = new CurrentUserMock();
		IUser user = currentUser.getCurrentAuthenticatedUser();
		List<Role> roles = courseUserRelationshipDB.loadUserRolesForCourse(course, user);
		assertThat(roles).isNotNull();
		assertThat(roles).isNotEmpty();
		assertTrue(roles.size() > 0);
	}

	@Test
	public void loadAllRoluesForUserInCourse() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		course.setId(0);
		CurrentUserMock currentUser = new CurrentUserMock();
		IUser user = currentUser.getCurrentAuthenticatedUser();
		List<Role> roles = courseUserRelationshipDB.loadUserRolesForCourse(course, user);
		assertTrue(roles.size() > 0);
	}

	@Test
	public void enrollUserInCourse() {
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		CurrentUserMock currentUser = new CurrentUserMock();
		IUser user = currentUser.getCurrentAuthenticatedUser();
		boolean result = courseUserRelationshipDB.enrollUser(course, user, Role.STUDENT);
		assertTrue(result);
	}
}