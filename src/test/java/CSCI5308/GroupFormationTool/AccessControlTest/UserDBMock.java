package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.*;

public class UserDBMock implements IUserPersistence {
	@Override
	public void loadUserByID(long id, User user) {
		user.setID(id);
		user.setBannerID("B00000000");
		user.setPassword("Pass@123");
		user.setFirstName("Rob");
		user.setLastName("Hawkey");
		user.setEmail("rhawkey@dal.ca");
	}

	@Override
	public void loadUserByBannerID(String bannerID, User user) {
		user.setID(1);
		user.setBannerID(bannerID);
		user.setPassword("Pass@123");
		user.setFirstName("Rob");
		user.setLastName("Hawkey");
		user.setEmail("rhawkey@dal.ca");
	}

	@Override
	public boolean createUser(User user) {
		user.setID(0);
		user.setBannerID("B00000000");
		user.setPassword("Pass@123");
		user.setFirstName("Rob");
		user.setLastName("Hawkey");
		user.setEmail("rhawkey@dal.ca");
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		user.setID(0);
		user.setBannerID("B00000000");
		user.setPassword("Pass@123");
		user.setFirstName("Rob");
		user.setLastName("Hawkey");
		user.setEmail("rhawkey@dal.ca");
		return true;
	}

	@Override
	public long checkUserByBannerID(String bannerID) {
		User user = new User();
		user.setID(0);
		user.setBannerID("B00000000");
		user.setPassword("Pass@123");
		user.setFirstName("Rob");
		user.setLastName("Hawkey");
		user.setEmail("rhawkey@dal.ca");
		return user.getID();
	}
}
