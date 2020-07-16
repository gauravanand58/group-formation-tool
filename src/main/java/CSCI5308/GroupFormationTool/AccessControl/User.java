package CSCI5308.GroupFormationTool.AccessControl;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IUserPasswordHistoryRelationshipPersistance;
import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;

public class User implements IUser{
	private final static Logger logger = LoggerFactory.getLogger(User.class);
	
	private long id;
	private String password;
	private String bannerID;
	private String firstName;
	private String lastName;
	private String email;

	public User() {
		setDefaults();
	}

	public User(long id, IUserPersistence persistence) {
		setDefaults();
		persistence.loadUserByID(id, this);
	}

	public User(String bannerID, IUserPersistence persistence) {
		setDefaults();
		persistence.loadUserByBannerID(bannerID, this);
	}

	private void setDefaults() {
		id = -1;
		password = "";
		bannerID = "";
		firstName = "";
		lastName = "";
		email = "";
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getID() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
	}

	public String getBannerID() {
		return bannerID;
	}

	public String getBanner() {
		return bannerID;
	}

	public void setFirstName(String name) {
		firstName = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String name) {
		lastName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public boolean isValidUser() {
		return id != -1;
	}

	public boolean createUser(IUserPersistence userDB, IPasswordEncryption passwordEncryption,
			IUserNotifications notification) {
		String rawPassword = password;
		this.password = passwordEncryption.encryptPassword(this.password);
		boolean success = userDB.createUser(this);
		if (success && (null != notification)) {
			try {
				notification.sendUserLoginCredentials(this, rawPassword);
			} catch (MessagingException e) {
				logger.error("Failed to send login credentials to users"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Successfully created user and sent credentials");
		return success;
	}

	public boolean saveUserPasswordHistory(IUserPasswordHistoryRelationshipPersistance userPassRelationship) {
		return userPassRelationship.saveUserPassword(this);
	}

	public boolean updateUser(IUserPersistence userDB) {
		return userDB.updateUser(this);
	}

	public boolean validatePasswordHistory(String password,
			IUserPasswordHistoryRelationshipPersistance userPassRelationship,
			PasswordPolicyConfiguration passwordPolicyConfiguration, IPasswordEncryption passwordEncryption) {
		List<String> passwordHistory = userPassRelationship.loadAllUserPassword(this,
				passwordPolicyConfiguration.getPasswordHistoryCount());
		for (String pass : passwordHistory) {
			if (passwordEncryption.matches(password, pass)) {
				logger.info("Invalid password history");
				return false;
			}
		}
		logger.info("Valid password history");
		return true;
	}
}