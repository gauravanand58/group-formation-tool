package CSCI5308.GroupFormationTool.Security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class UserPasswordHistoryRelationshipDB implements IUserPasswordHistoryRelationshipPersistance {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean saveUserPassword(User user) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spSaveUserPasswordHistory(?)");
			proc.setParameter(1, user.getBannerID());
			proc.execute();

		} catch (SQLException e) {
			logger.error("spSaveUserPasswordHistory throws SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	@Override
	public List<String> loadAllUserPassword(User user, int limit) {
		List<String> userPasswords = new ArrayList<String>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadUserPasswordHistory(?,?)");
			proc.setParameter(1, user.getID());
			proc.setParameter(2, limit);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					userPasswords.add(results.getString("password"));
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadUserPasswordHistory throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return userPasswords;
	}
}
