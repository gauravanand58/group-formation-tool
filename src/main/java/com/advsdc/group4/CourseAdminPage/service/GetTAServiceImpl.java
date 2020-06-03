package com.advsdc.group4.GetTA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advsdc.group4.GetTA.dao.GetTADao;
@Service
public class GetTAServiceImpl implements GetTAService{

	@Autowired
	GetTADao getTAdao;
	
	@Override
	public String displayInfo(String bannerID, int courseID) {
		String taInfo=getTAdao.getUser(bannerID, courseID);
		return taInfo;
	}

	@Override
	public Boolean enrollTA(String bannerID, int courseID) {
		Boolean enrolledTA=getTAdao.insertTA(bannerID, courseID);
		return enrolledTA;
	}

	
	
	
	}


