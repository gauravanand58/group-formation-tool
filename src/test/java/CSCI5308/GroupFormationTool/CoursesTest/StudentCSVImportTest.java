package CSCI5308.GroupFormationTool.CoursesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import CSCI5308.GroupFormationTool.AccessControlTest.UserDBMock;
import CSCI5308.GroupFormationTool.Courses.CourseAbstractFactory;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.Role;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.SecurityTest.PasswordEncryptionMock;

class StudentCSVImportTest {

	@Test
	public void enrollStudentFromRecord() {
		IUser user = UserAbstractFactory.instance().makeUser();
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		IUserPersistence userDB = new UserDBMock();
		IPasswordEncryption passwordEncryption = new PasswordEncryptionMock();
		assertTrue(user.createUser(userDB, passwordEncryption, null));
		assertTrue(course.enrollUserInCourse(Role.STUDENT, user) == false);
	}

	@Test
	public void getSuccessResults() {
		List<String> successResults = new ArrayList<String>();
		successResults.add("Created record");
		assertThat(successResults).isNotNull();
		assertThat(successResults).isNotEmpty();
		assertTrue(successResults.size() > 0);
	}

	@Test
	public void getFailureResults() {
		List<String> failureResults = new ArrayList<String>();
		failureResults.add("Created record");
		assertThat(failureResults).isNotNull();
		assertThat(failureResults).isNotEmpty();
		assertTrue(failureResults.size() > 0);
	}
}