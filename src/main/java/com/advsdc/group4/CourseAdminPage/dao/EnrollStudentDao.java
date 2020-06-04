package com.advsdc.group4.CourseAdminPage.dao;
import java.util.List;

import com.advsdc.group4.Model.IUser;
public interface EnrollStudentDao {
	public boolean insertStudentsInDB(IUser user, int courseID);
	public List<String> getUser();
}
