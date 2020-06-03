package com.advsdc.group4.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.advsdc.group4.BusinessObjectModels.Course;
import com.advsdc.group4.util.DatabaseConnection;

public class DeleteCourseDaoImpl implements DeleteCourseDao {
	Connection connection;
	String query;
	PreparedStatement statement;
	int rows;
	Statement selectStatement;
	String returnMessage;
	ResultSet courseResult;

	public ArrayList<Course> viewCourse() {
		ArrayList<Course> courseList = new ArrayList<Course>();
		connection = DatabaseConnection.getConnection();
		try {
			selectStatement = connection.createStatement();
			query = "Select CourseId, CourseName from Course";
			courseResult = selectStatement.executeQuery(query);
			Course cObj;
			while (courseResult.next()) {
				cObj = new Course();
				cObj.setCourseId(courseResult.getString("CourseId"));
				cObj.setCourseName(courseResult.getString("CourseName"));
				courseList.add(cObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				selectStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			query = "DELETE FROM Course WHERE CourseId ='" + iterator.next() + "';";
			try {
				statement = connection.prepareStatement(query);
				rows = statement.executeUpdate();	
				if(rows>0) {
					message = "Course Deleted Successfully";
				}
			} catch (Exception e) {
				message = "Unable to delete course, please select again";
			}
		}
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;

	}
}
