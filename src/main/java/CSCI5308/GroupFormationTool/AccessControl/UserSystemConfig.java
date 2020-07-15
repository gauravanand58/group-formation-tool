package CSCI5308.GroupFormationTool.AccessControl;

public class UserSystemConfig {
	private static UserSystemConfig uniqueInstance = null;
	
	private IUserNotifications userNotifications = null;
	private IUserPersistence userDB = null;
	
	private UserSystemConfig() {
		userNotifications = new UserNotifications();
		userDB = new UserDB();
	}
	
	public static UserSystemConfig instance() {
		if(uniqueInstance == null) {
			uniqueInstance = new UserSystemConfig();
		}
		return uniqueInstance;
	}

	public IUserNotifications getUserNotifications() {
		return userNotifications;
	}

	public void setUserNotifications(IUserNotifications userNotifications) {
		this.userNotifications = userNotifications;
	}

	public IUserPersistence getUserDB() {
		return userDB;
	}

	public void setUserDB(IUserPersistence userDB) {
		this.userDB = userDB;
	}
}