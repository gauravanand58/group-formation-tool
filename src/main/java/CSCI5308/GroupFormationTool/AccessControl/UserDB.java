package CSCI5308.GroupFormationTool.AccessControl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class UserDB implements IUserPersistence {
	private long userID;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void loadUserByID(long id, IUser user) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadUser(?)");
			proc.setParameter(1, id);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userID = results.getLong(1);
					String bannerID = results.getString(2);
					String password = results.getString(3);
					String firstName = results.getString(4);
					String lastName = results.getString(5);
					String email = results.getString(6);
					user.setID(userID);
					logger.debug("Loaded user with user ID"+userID);
					user.setBannerID(bannerID);
					user.setPassword(password);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setEmail(email);
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadUser throws SQLException "+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	}

	public void loadUserByBannerID(String bannerID, IUser user) {
		CallStoredProcedure proc = null;
		long userID = -1;
		try {
			proc = new CallStoredProcedure("spFindUserByBannerID(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					userID = results.getLong(1);
				}
			}
		} catch (SQLException e) {
			logger.error("spFindUserByBannerID throws SQLException "+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}

		if (userID > -1) {
			loadUserByID(userID, user);
		}
	}

	public boolean createUser(IUser user) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spCreateUser(?, ?, ?, ?, ?, ?)");
			proc.setParameter(1, user.getBannerID());
			proc.setParameter(2, user.getPassword());
			proc.setParameter(3, user.getFirstName());
			proc.setParameter(4, user.getLastName());
			proc.setParameter(5, user.getEmail());
			proc.registerOutputParameterLong(6);
			proc.execute();
		} catch (SQLException e) {
			logger.error("spCreateUser throws SQLException "+e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.debug("Created user with bannerID"+user.getBanner());
		return true;
	}

	public boolean updateUser(IUser user) {
		return false;
	}

	public long checkUserByBannerID(String bannerID) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spcheckInstructorByBannerID(?,?)");
			proc.setParameter(1, bannerID);
			proc.registerOutputParameterLong(2);
			proc.execute();
			userID = proc.getStatement().getLong(2);
		} catch (SQLException e) {
			logger.error("spcheckInstructorByBannerID throws SQLException "+e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return userID;
	}
}