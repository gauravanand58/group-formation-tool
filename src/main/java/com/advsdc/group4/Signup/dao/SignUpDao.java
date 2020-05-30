package com.advsdc.group4.Signup.dao;

import com.advsdc.group4.Model.User;

public interface SignUpDao {
	public boolean addUser(User user);

	public boolean userExists(User user);
}
