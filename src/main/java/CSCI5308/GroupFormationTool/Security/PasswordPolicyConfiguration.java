package CSCI5308.GroupFormationTool.Security;


public class PasswordPolicyConfiguration {
	private static PasswordPolicyConfiguration uniqueInstance = null;

	private int maxLength; 
	private int minLength; 
	private int minUpperChar; 
	private int minLowerChar; 
	private int minSplChar;
	private String notAllowedChar;
	private int passwordHistoryCount;
	private static String passwordPolicies;
	

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMinUpperChar() {
		return minUpperChar;
	}

	public void setMinUpperChar(int minUpperChar) {
		this.minUpperChar = minUpperChar;
	}

	public int getMinLowerChar() {
		return minLowerChar;
	}

	public void setMinLowerChar(int minLowerChar) {
		this.minLowerChar = minLowerChar;
	}

	public int getMinSplChar() {
		return minSplChar;
	}

	public void setMinSplChar(int minSplChar) {
		this.minSplChar = minSplChar;
	}

	public String getNotAllowedChar() {
		return notAllowedChar;
	}

	public void setNotAllowedChar(String notAllowedChar) {
		this.notAllowedChar = notAllowedChar;
	}

	public int getPasswordHistoryCount() {
		return passwordHistoryCount;
	}

	public void setPasswordHistoryCount(int passwordHistoryCount) {
		this.passwordHistoryCount = passwordHistoryCount;
	}
	
	private PasswordPolicyConfiguration(IPasswordPolicyPersistance persistance){		
		persistance.loadUserPasswordPolicies(this);
	}
	
	public static String getPasswordPolicies() {
		passwordPolicies = "Password should meet the following conditions. <br> <ul>";
		if (uniqueInstance.minLength!=-1)
			passwordPolicies += "<li> atleast "+uniqueInstance.minLength+ " character length.</li>";
		
		if (uniqueInstance.maxLength!=-1) 
			passwordPolicies += "<li> maximum "+uniqueInstance.maxLength+ " character length.</li>";
		
		if (uniqueInstance.minUpperChar!=-1)
			passwordPolicies += "<li> atleast "+uniqueInstance.minUpperChar+ " uppercase character.</li>";
		
		if (uniqueInstance.minLowerChar!=-1)
			passwordPolicies += "<li> atleast "+uniqueInstance.minLowerChar+ " lowercase character.</li>";
		
		if (uniqueInstance.minSplChar!=-1)
			passwordPolicies += "<li> atleast "+uniqueInstance.minSplChar+ " special character.</li>";

		if (uniqueInstance.notAllowedChar!=null)
			passwordPolicies += "<li> should not contain "+uniqueInstance.notAllowedChar+ " characters.</li>";
		
		passwordPolicies +="</ul>";

		return passwordPolicies;
	}
	

	public static PasswordPolicyConfiguration instance(IPasswordPolicyPersistance persistance)
	{
		// Using lazy initialization, this is the one and only place that the System
		// object will be instantiated.
		if (null == uniqueInstance)
		{
			uniqueInstance = new PasswordPolicyConfiguration(persistance);
		}
		return uniqueInstance;
	}
	
	public static boolean isValidPassword(String password) {
		int upperCount = 0;
		int lowerCount = 0;
		int symbolCount = 0;
		
		String tempPassword = password;
		upperCount = password.length() - tempPassword.replaceAll("[A-Z]", "").length();
		
		tempPassword = password;
		lowerCount = password.length() - tempPassword.replaceAll("[a-z]", "").length();
		
		tempPassword = password;
		symbolCount = password.length() - tempPassword.replaceAll("[^a-z|^A-Z]", "").length();
		
		System.out.println("ddd:"+upperCount+","+lowerCount+","+symbolCount);		
		
		
		char[] invalidChars = uniqueInstance.notAllowedChar.toCharArray();
		
		// checks for max length and min length for a password
		if( (uniqueInstance.maxLength!=-1 && password.length()> uniqueInstance.maxLength) 
				|| (uniqueInstance.minLength!=-1 && password.length() < uniqueInstance.minLength)) {
			return false;
		}
		
		if( uniqueInstance.minLowerChar!=-1 && lowerCount < uniqueInstance.minLowerChar) {
			return false;
		}
		
		if( uniqueInstance.minUpperChar!=-1 && upperCount < uniqueInstance.minUpperChar) {
			return false;
		}
		
		if( uniqueInstance.minSplChar!=-1 && symbolCount < uniqueInstance.minSplChar) {
			return false;
		}
		
		
		// checks for invalid characters in password
		for(int i = 0; i < invalidChars.length; i++) {
			if( password.contains(String.valueOf(invalidChars[i])) ) {
				return false;
			}
		}
			
		return true;
	}

	

}
