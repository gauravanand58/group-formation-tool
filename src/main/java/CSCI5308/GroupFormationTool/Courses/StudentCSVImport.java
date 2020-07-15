package CSCI5308.GroupFormationTool.Courses;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;

public class StudentCSVImport {
	private List<String> successResults;
	private List<String> failureResults;
	private ICourse course;
	private IUserPersistence userDB;
	private IPasswordEncryption passwordEncryption;
	private IUserNotifications userNotification;
	private IStudentCSVParser parser;

	public StudentCSVImport(IStudentCSVParser parser, ICourse course2) {
		userNotification = UserSystemConfig.instance().getUserNotifications();
		this.course = course2;
		successResults = new ArrayList<String>();
		failureResults = new ArrayList<String>();
		userDB = UserSystemConfig.instance().getUserDB();
		passwordEncryption = SystemConfig.instance().getPasswordEncryption();
		this.parser = parser;
		enrollStudentFromRecord();
	}

	private void enrollStudentFromRecord() {
		List<IUser> studentList = parser.parseCSVFile(failureResults);
		for (IUser u : studentList) {
			String bannerID = u.getBanner();
			String firstName = u.getFirstName();
			String lastName = u.getLastName();
			String email = u.getEmail();
			String userDetails = bannerID + " " + firstName + " " + lastName + " " + email;

			IUser user = UserAbstractFactory.instance().createUserObject();
			userDB.loadUserByBannerID(bannerID, user);
			if (user.isValidUser()==false) {
				user.setBannerID(bannerID);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(u.getBannerID());
				if (user.createUser(userDB, passwordEncryption, userNotification)) {
					successResults.add("Created: " + userDetails);
					userDB.loadUserByBannerID(bannerID, user);
				} else {
					failureResults.add("Unable to save this user to DB: " + userDetails);
					return;
				}
			}
			if (course.enrollUserInCourse(Role.STUDENT, user)) {
				successResults.add("User enrolled in course: " + userDetails);
			} else {
				failureResults.add("Unable to enroll user in course: " + userDetails);
			}
		}
	}

	public List<String> getSuccessResults() {
		return successResults;
	}

	public List<String> getFailureResults() {
		return failureResults;
	}
}