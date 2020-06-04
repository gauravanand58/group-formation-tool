package com.advsdc.group4.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.util.DatabaseConnection;

public class AddCourseDaoImpl implements AddCourseDao {
	Connection connection;
	String query;
	PreparedStatement statement;
	int rows;
	String returnMessage;
	ResultSet courseResult;

	@Override
	public String addCourse(Course course) {
		query = "Insert into Course (CourseId, CourseName) values(" + course.getCourseId() + ",'"
				+ course.getCourseName() + "');";
		connection = DatabaseConnection.getConnection();
		System.out.println("query" + query);
		String message = null;
		try {
			statement = connection.prepareStatement(query);

			rows = statement.executeUpdate();
			if (rows > 0) {
				message = "Course added successfully";
			}
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			message = "Course with same course ID already exists";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

}
