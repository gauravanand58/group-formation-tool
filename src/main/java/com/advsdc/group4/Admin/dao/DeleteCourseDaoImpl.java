package com.advsdc.group4.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.advsdc.group4.Model.Course;
import com.advsdc.group4.util.DatabaseConnection;

public class DeleteCourseDaoImpl implements DeleteCourseDao {
	Connection connection;
	String query;
	PreparedStatement statement;
	int rows;
	Statement selectStatement;
	String returnMessage;
	ResultSet courseResult;

	private static final Logger logger = LogManager.getLogger(DeleteCourseDaoImpl.class);

	public ArrayList<Course> viewCourse() {
		ArrayList<Course> courseList = new ArrayList<Course>();
		connection = DatabaseConnection.getConnection();
		try {
			selectStatement = connection.createStatement();
			query = "Select CourseID, CourseName, CourseDescription from Course";
			courseResult = selectStatement.executeQuery(query);
			Course course;
			while (courseResult.next()) {
				course = new Course();
				course.setCourseID(courseResult.getInt("CourseID"));
				course.setCourseName(courseResult.getString("CourseName"));
				course.setCourseDescription(courseResult.getString("CourseDescription"));
				courseList.add(course);
			}
		} catch (SQLException e) {
			logger.error(e);

		} finally {
			try {
				if (selectStatement != null) {
					selectStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				logger.error(e);
			}
		}

		return courseList;
	}

	@Override
	public String deleteCourse(ArrayList courseDelList) {

		Iterator<String> iterator = courseDelList.iterator();
		connection = DatabaseConnection.getConnection();
		String message = null;
		while (iterator.hasNext()) {
			String courseCurrent = iterator.next();
			query = "DELETE FROM User_Course_Assoc WHERE UCCourseID='" + courseCurrent + "';";

			try {
				statement = connection.prepareStatement(query);
				statement.executeUpdate();
				query = "DELETE FROM Course WHERE CourseID='" + courseCurrent + "';";
				statement = connection.prepareStatement(query);
				rows = statement.executeUpdate();
				if (rows > 0) {
					message = "Course Deleted Successfully";
				}
			} catch (Exception e) {
				logger.error(e);
				message = "Unable to delete course, please select again";
			} finally {
				try {
					if (statement != null) {
						statement.close();
					}
					if (connection != null) {
						connection.close();
					}

				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

		return message;

	}
}
