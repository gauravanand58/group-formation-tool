package com.advsdc.group4.CourseAdminPage.service;

import com.advsdc.group4.Model.IUser;

public interface GetTAService {
	public String displayInfo(IUser user,int courseID);
	public Boolean enrollTA(IUser user,int courseID);
}		
