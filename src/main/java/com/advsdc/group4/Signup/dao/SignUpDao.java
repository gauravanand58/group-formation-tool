package com.advsdc.group4.Signup.dao;


import com.advsdc.group4.Model.IUser;

public interface SignUpDao {
	public boolean addUser(IUser user);

	public boolean userExists(IUser user);
}
