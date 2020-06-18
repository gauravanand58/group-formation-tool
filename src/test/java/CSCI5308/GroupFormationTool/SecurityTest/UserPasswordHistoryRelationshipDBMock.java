package CSCI5308.GroupFormationTool.SecurityTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Security.IUserPasswordHistoryRelationshipPersistance;

public class UserPasswordHistoryRelationshipDBMock implements IUserPasswordHistoryRelationshipPersistance {

	@Override
	public boolean saveUserPassword(User user) {
		if (user.getID() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<String> loadAllUserPassword(User user, int limit) {
		List<String> passwords = new ArrayList<String>();
		if (user.getID() == 2) {
			passwords.add("encrypted");
		}
		return passwords;
	}
}