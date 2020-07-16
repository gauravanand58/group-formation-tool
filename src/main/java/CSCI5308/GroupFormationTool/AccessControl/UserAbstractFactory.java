package CSCI5308.GroupFormationTool.AccessControl;

public abstract class UserAbstractFactory {
	private static UserAbstractFactory uniqueInstance = null;
	
	protected UserAbstractFactory() {
	}
	
	public static UserAbstractFactory instance() {
		if(null == uniqueInstance) {
			uniqueInstance = new UserFactory();
		}
		return uniqueInstance;
	}
	
	public void setFactory(UserAbstractFactory userFactory) {
		uniqueInstance = userFactory;
	}
	
	public abstract IUser makeUser();
	public abstract IUser makeUserWithBanner(String bannerID, IUserPersistence userDB);
	public abstract IUser makeUserWithID(long id, IUserPersistence userDB);
	public abstract IUserPersistence makeUserDB();
	public abstract IUserNotifications makeUserNotifications();
}
