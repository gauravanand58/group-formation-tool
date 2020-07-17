package CSCI5308.GroupFormationTool.AccessControl;

public class UserFactory extends UserAbstractFactory {
	public IUser makeUser() {
		return new User();
	}

	public IUser makeUserWithBanner(String bannerID, IUserPersistence userDB) {
		return new User(bannerID, userDB);
	}

	public IUser makeUserWithID(long id, IUserPersistence userDB) {
		return new User(id, userDB);
	}

	public IUserPersistence makeUserDB() {
		return new UserDB();
	}

	public IUserNotifications makeUserNotifications() {
		return new UserNotifications();
	}
}