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
	
	

	

}
