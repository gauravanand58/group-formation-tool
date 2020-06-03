package com.advsdc.group4.CourseAdminPage.service;

import com.advsdc.group4.CourseAdminPage.dao.GetTADao;
import com.advsdc.group4.CourseAdminPage.dao.GetTADaoImpl;
import com.advsdc.group4.Model.IUser;

public class GetTAServiceImpl implements GetTAService{

	GetTADao getTAdao;
	public GetTAServiceImpl() {
		getTAdao=new GetTADaoImpl();
	}
	
	@Override
	public String displayInfo(IUser user, int courseID) {
		String taInfo=getTAdao.getUser(user, courseID);
		return taInfo;
	}

	@Override
	public Boolean enrollTA(IUser user, int courseID) {
		Boolean enrolledTA=getTAdao.insertTA(user, courseID);
		return enrolledTA;
	}

	
	
	
	}


