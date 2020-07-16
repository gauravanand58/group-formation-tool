package CSCI5308.GroupFormationTool.AccessControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IUserPasswordHistoryRelationshipPersistance;
import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;

public interface IUser {
	public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	public final static Logger logger = LoggerFactory.getLogger(User.class);

	public void setID(long id);

	public long getID();

	public void setId(long id);

	public long getId();

	public void setPassword(String password);

	public String getPassword();

	public void setBannerID(String bannerID);

	public String getBannerID();

	public String getBanner();

	public void setFirstName(String name);

	public String getFirstName();

	public void setLastName(String name);

	public String getLastName();

	public void setEmail(String email);

	public String getEmail();

	public boolean isValidUser();

	public boolean createUser(IUserPersistence userDB, IPasswordEncryption passwordEncryption,
			IUserNotifications notification);

	public boolean saveUserPasswordHistory(IUserPasswordHistoryRelationshipPersistance userPassRelationship);

	public boolean updateUser(IUserPersistence userDB);

	public static boolean isStringNullOrEmpty(String s) {
		if (null == s) {
			return true;
		}
		return s.isEmpty();
	}

	public static boolean isBannerIDValid(String bannerID) {
		return isStringNullOrEmpty(bannerID) == false;
	}

	public static boolean isFirstNameValid(String name) {
		return isStringNullOrEmpty(name) == false;
	}

	public static boolean isLastNameValid(String name) {
		return isStringNullOrEmpty(name) == false;
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
			PasswordPolicyConfiguration passwordPolicyConfiguration, IPasswordEncryption passwordEncryption);

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
