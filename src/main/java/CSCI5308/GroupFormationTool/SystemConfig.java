package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Security.*;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Database.*;
import CSCI5308.GroupFormationTool.Courses.*;


public class SystemConfig {
	private static SystemConfig uniqueInstance = null;

	private IPasswordEncryption passwordEncryption;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IPasswordPolicyPersistance passwordPolicyDB;
	private IUserPasswordHistoryRelationshipPersistance userPasswordRelationshipDB;
	
	private SystemConfig() {
		passwordEncryption = new BCryptPasswordEncryption();
		userDB = new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		passwordPolicyDB = new PasswordPolicyDB();
		userPasswordRelationshipDB = new UserPasswordHistoryRelationshipDB();

	}

	public static SystemConfig instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}

	public IPasswordEncryption getPasswordEncryption() {
		return passwordEncryption;
	}

	public void setPasswordEncryption(IPasswordEncryption passwordEncryption) {
		this.passwordEncryption = passwordEncryption;
	}

	public IUserPersistence getUserDB() {
		return userDB;
	}

	public void setUserDB(IUserPersistence userDB) {
		this.userDB = userDB;
	}
	
	public PasswordPolicyConfiguration getConfiguration() {
		return PasswordPolicyConfiguration.instance(passwordPolicyDB);
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}

	public void setCourseDB(ICoursePersistence courseDB) {
		this.courseDB = courseDB;
	}

	public ICoursePersistence getCourseDB() {
		return courseDB;
	}

	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
		this.courseUserRelationshipDB = courseUserRelationshipDB;
	}

	public IPasswordPolicyPersistance getPasswordPolicyDB() {
		return passwordPolicyDB;
	}

	public void setPasswordPolicyDB(IPasswordPolicyPersistance passwordPolicyDB) {
		this.passwordPolicyDB = passwordPolicyDB;
	}

	public IUserPasswordHistoryRelationshipPersistance getUserPasswordRelationshipDB() {
		return userPasswordRelationshipDB;
	}

	public void setUserPasswordRelationshipDB(IUserPasswordHistoryRelationshipPersistance userPasswordRelationshipDB) {
		this.userPasswordRelationshipDB = userPasswordRelationshipDB;
	}

	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB() {
		return courseUserRelationshipDB;
	}

}