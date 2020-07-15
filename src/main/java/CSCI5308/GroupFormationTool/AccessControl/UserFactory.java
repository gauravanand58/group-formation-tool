package CSCI5308.GroupFormationTool.AccessControl;

public class UserFactory extends UserAbstractFactory{
	public IUser createUserObject() {
		return new User();
	}
	
	public IUser loadUserWithBanner(String bannerID, IUserPersistence userDB) {
		return new User(bannerID, userDB);
	}
	
	public IUser loadUserWithID(long id, IUserPersistence userDB) {
		return new User(id, userDB);
	}
}