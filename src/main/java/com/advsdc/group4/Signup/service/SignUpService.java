package com.advsdc.group4.Signup.service;

import com.advsdc.group4.Model.IUser;

public interface SignUpService {
	public boolean addUserToDB(IUser user);

	public boolean userExists(IUser user);
}
