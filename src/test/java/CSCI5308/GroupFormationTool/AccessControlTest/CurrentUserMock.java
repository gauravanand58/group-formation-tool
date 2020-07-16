package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;

public class CurrentUserMock {
	public IUser getCurrentAuthenticatedUser() {
		IUserPersistence userDB = new UserDBMock();
		String bannerID = "B00000000";
		IUser u = UserAbstractFactory.instance().makeUser();
		userDB.loadUserByBannerID(bannerID, u);
		return u;
	}
}
