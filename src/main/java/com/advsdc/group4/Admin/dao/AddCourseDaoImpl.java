package com.advsdc.group4.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.advsdc.group4.BusinessObjectModels.Course;
import com.advsdc.group4.util.DatabaseConnection;

public class AddCourseDaoImpl implements AddCourseDao{
	Connection connection;
	String query;
	PreparedStatement statement;
	int rows;
	String returnMessage;

	@Override
	public String addCourse(Course course) {
		// TODO Auto-generated method stub
		query = "Insert into Course (CourseId, CourseName) values("+course.getCourseId()+",'"+course.getCourseName()+"');";
		connection = DatabaseConnection.getConnection();
		System.out.println("query"+query);
		try {
			statement = connection.prepareStatement(query);
//			statement.setString(1,course.getCourseId());
//			statement.setString(2,course.getCourseName());
			
			rows = statement.executeUpdate();
			if(rows > 0) {
				System.out.println("value added");
			}
		}
		catch (Exception e){
			System.out.println("error"+e.getMessage());
			e.printStackTrace();
		}
		
//		return returnMessage;
//		System.out.println("Dao Id"+course.getCourseId());
//		System.out.println("Dao Id"+course.getCourseName());
		return null;
	}

	@Override
	public String courseExist(Course course) {
		// TODO Auto-generated method stub
		return null;
	}
}
