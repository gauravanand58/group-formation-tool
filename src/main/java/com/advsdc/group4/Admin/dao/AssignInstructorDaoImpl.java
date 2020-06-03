package com.advsdc.group4.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.advsdc.group4.BusinessObjectModels.Course;
import com.advsdc.group4.BusinessObjectModels.User;
import com.advsdc.group4.util.DatabaseConnection;

public class AssignInstructorDaoImpl implements AssignInstructorDao {
	Connection connection;
	String query;
	PreparedStatement statement;
	Statement selectStatement;
	int rows;
	String returnMessage;
	ResultSet userResult;

	@Override
	public ArrayList<User> viewUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		connection = DatabaseConnection.getConnection();
		try {
			selectStatement = connection.createStatement();
			query = "Select BannerID, FName, LName from users";
			userResult = selectStatement.executeQuery(query);
			User uObj;
			while (userResult.next()) {
				uObj = new User();
				uObj.setbId(userResult.getString("BannerID"));
				uObj.setfName(userResult.getString("FName"));
				uObj.setlName(userResult.getString("LName"));
				userList.add(uObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				selectStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return userList;
	}

	@Override
	public String assignInstructor(String courseId, String bId) {
		String message = null;
		query = "insert into user_course_assoc (UCBannerID , UCRoleID, UCCourseId) values('" + bId + "', '2','"
				+ courseId + "');";
		connection = DatabaseConnection.getConnection();
		System.out.println("query" + query);
		try {
			statement = connection.prepareStatement(query);

			rows = statement.executeUpdate();
			if (rows > 0) {
				message = "Instructor added successfully";
			}

		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			message = "Selected instructor already added for selected course";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return message;
	}

}
