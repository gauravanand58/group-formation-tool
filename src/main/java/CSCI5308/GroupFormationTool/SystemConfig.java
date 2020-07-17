package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Database.DefaultDatabaseConfiguration;
import CSCI5308.GroupFormationTool.Database.IDatabaseConfiguration;
import CSCI5308.GroupFormationTool.Security.BCryptPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IPasswordPolicyPersistance;
import CSCI5308.GroupFormationTool.Security.IUserPasswordHistoryRelationshipPersistance;
import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordPolicyDB;
import CSCI5308.GroupFormationTool.Security.UserPasswordHistoryRelationshipDB;

public class SystemConfig {
	private static SystemConfig uniqueInstance = null;

	private IPasswordEncryption passwordEncryption;
	private IDatabaseConfiguration databaseConfiguration;
	private IPasswordPolicyPersistance passwordPolicyDB;
	private IUserPasswordHistoryRelationshipPersistance userPasswordRelationshipDB;

	private SystemConfig() {
		passwordEncryption = new BCryptPasswordEncryption();
		databaseConfiguration = new DefaultDatabaseConfiguration();
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

	public PasswordPolicyConfiguration getConfiguration() {
		return PasswordPolicyConfiguration.instance(passwordPolicyDB);
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
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

}
