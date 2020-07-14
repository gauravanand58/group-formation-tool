package CSCI5308.GroupFormationTool.AccessControl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IUserPasswordHistoryRelationshipPersistance;
import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;

public class User {
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
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

	public void setDefaults() {
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

	private static boolean isStringNullOrEmpty(String s) {
		if (null == s) {
			return true;
		}
		return s.isEmpty();
	}

	public static boolean isBannerIDValid(String bannerID) {
		return isStringNullOrEmpty(bannerID)==false;
	}

	public static boolean isFirstNameValid(String name) {
		return isStringNullOrEmpty(name)==false;
	}

	public static boolean isLastNameValid(String name) {
		return isStringNullOrEmpty(name)==false;
	}

	public static boolean isEmailValid(String email) {
		if (isStringNullOrEmpty(email)) {
			return false;
		}
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
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

	public static boolean isValidPassword(String password, PasswordPolicyConfiguration uniqueInstance) {
		int upperCount = 0;
		int lowerCount = 0;
		int symbolCount = 0;

		String tempPassword = password;
		upperCount = password.length() - tempPassword.replaceAll("[A-Z]", "").length();

		tempPassword = password;
		lowerCount = password.length() - tempPassword.replaceAll("[a-z]", "").length();

		tempPassword = password;
		symbolCount = password.length() - tempPassword.replaceAll("[^a-z|^A-Z]", "").length();

		char[] invalidChars = uniqueInstance.getNotAllowedChar().toCharArray();

		if ((uniqueInstance.getMaxLength() != -1 && password.length() > uniqueInstance.getMaxLength())
				|| (uniqueInstance.getMinLength() != -1 && password.length() < uniqueInstance.getMinLength())) {
			logger.info("Invalid password length");
			return false;
		}

		if (uniqueInstance.getMinLowerChar() != -1 && lowerCount < uniqueInstance.getMinLowerChar()) {
			logger.info("Invalid password lower char");
			return false;
		}

		if (uniqueInstance.getMinUpperChar() != -1 && upperCount < uniqueInstance.getMinUpperChar()) {
			logger.info("Invalid password upper char");
			return false;
		}

		if (uniqueInstance.getMinSplChar() != -1 && symbolCount < uniqueInstance.getMinSplChar()) {
			logger.info("Invalid password special char");
			return false;
		}

		for (int i = 0; i < invalidChars.length; i++) {
			if (password.contains(String.valueOf(invalidChars[i]))) {
				logger.info("Password contains invalid char");
				return false;
			}
		}
		logger.info("Valid password");
		return true;
	}
}