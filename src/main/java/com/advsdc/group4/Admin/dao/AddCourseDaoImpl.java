package com.advsdc.group4.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.util.DatabaseConnection;

public class AddCourseDaoImpl implements AddCourseDao {
	Connection connection;
	String query;
	PreparedStatement statement;
	int rows;
	String returnMessage;
	ResultSet courseResult;

	private static final Logger logger = LogManager.getLogger(DeleteCourseDaoImpl.class);

	@Override
	public String addCourse(Course course) {
		query = "Insert into Course (CourseDescription, CourseName) values('" + course.getCourseDescription() + "','"
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
			logger.error(e);
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		return message;
	}

}
