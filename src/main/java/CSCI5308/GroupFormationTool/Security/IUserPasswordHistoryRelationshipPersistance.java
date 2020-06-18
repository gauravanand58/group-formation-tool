package CSCI5308.GroupFormationTool.Security;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IUserPasswordHistoryRelationshipPersistance {
	public boolean saveUserPassword(User user);

	public List<String> loadAllUserPassword(User user, int limit);

}