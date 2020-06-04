package com.advsdc.group4.Model;



public class Role implements IRole{
	int roleID;
	String roleName;
	
	public Role(){}
	

	
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
