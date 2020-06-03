package com.advsdc.group4.CourseAdminPage.service;

import org.springframework.web.multipart.MultipartFile;

public interface EnrollStudentService {
	public Boolean readCSV(MultipartFile file,int courseID);
}
