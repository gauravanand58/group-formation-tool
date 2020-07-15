package CSCI5308.GroupFormationTool.Courses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class CourseUserRelationshipDB implements ICourseUserRelationshipPersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<User> findAllUsersWithoutCourseRole(Role role, long courseID) {
		List<User> users = new ArrayList<User>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spFindUsersWithoutCourseRole(?, ?)");
			proc.setParameter(1, role.toString());
			proc.setParameter(2, courseID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userID = results.getLong(1);
					String bannerID = results.getString(2);
					String firstName = results.getString(3);
					String lastName = results.getString(4);
					User u = new User();
					u.setID(userID);
					u.setBannerID(bannerID);
					u.setFirstName(firstName);
					u.setLastName(lastName);
					users.add(u);
				}
			}
		} catch (SQLException e) {
			logger.error("spFindUsersWithoutCourseRole(?, ?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return users;
	}

	public List<User> findAllUsersWithCourseRole(Role role, long courseId) {
		List<User> users = new ArrayList<User>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spFindUsersWithCourseRole(?, ?)");
			proc.setParameter(1, role.toString());
			proc.setParameter(2, courseId);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userID = results.getLong(1);
					User u = new User();
					u.setID(userID);
					users.add(u);
				}
			}
		} catch (SQLException e) {
			logger.error("spFindUsersWithCourseRole(?, ?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return users;
	}

	public boolean enrollUser(ICourse course, User user, Role role) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spEnrollUser(?, ?, ?)");
			proc.setParameter(1, course.getId());
			proc.setParameter(2, user.getID());
			proc.setParameter(3, role.toString());
			proc.execute();
		} catch (SQLException e) {
			logger.error("spEnrollUser(?, ?, ?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Successfully enrolled user with ID:" + user.getID());
		return true;
	}

	public List<Role> loadUserRolesForCourse(ICourse course, User user) {
		List<Role> roles = new ArrayList<Role>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadUserRolesForCourse(?, ?)");
			proc.setParameter(1, course.getId());
			proc.setParameter(2, user.getID());
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					Role role = Role.valueOf(results.getString(1).toUpperCase());
					roles.add(role);
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadUserRolesForCourse(?, ?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return roles;
	}
}