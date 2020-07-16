package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserNotifications;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;

public class UserFactoryMock extends UserAbstractFactory{

	@Override
	public IUser makeUser() {
		return new User();
	}

	@Override
	public IUser makeUserWithBanner(String bannerID, IUserPersistence userDB) {
		return new User(bannerID,userDB);
	}

	@Override
	public IUser makeUserWithID(long id, IUserPersistence userDB) {
		return new User(id,userDB);
	}

	@Override
	public IUserPersistence makeUserDB() {
		return new UserDBMock();
	}

	@Override
	public IUserNotifications makeUserNotifications() {
		return new UserNotificationMock();
	}
	
}
