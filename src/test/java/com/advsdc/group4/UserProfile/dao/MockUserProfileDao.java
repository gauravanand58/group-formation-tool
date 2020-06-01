package com.advsdc.group4.UserProfile.dao;

import com.advsdc.group4.Model.IUser;

public class MockUserProfileDao implements IUserProfileDao {
	private String firstName;
	private String lastName;
	private String email;
	private String bannerID;
	
	public MockUserProfileDao() {
		setToDefault();
	}

	@Override
	public void loadUserWithID(String bannerID, IUser user) {
		user.setBannerID(bannerID);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);	
	}
	
	public void setToDefault()
	{
		firstName = "Srikrishna";
		lastName = "Sasidharan";
		email = "srikrishna.sasidharan@dal.ca";
		bannerID = "B00835818";
	}

}
