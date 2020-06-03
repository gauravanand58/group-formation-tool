package com.advsdc.group4.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.util.DatabaseConnection;

public class AssignInstructorDaoImpl implements AssignInstructorDao {
	Connection connection;
	String query;
	PreparedStatement statement;
	Statement selectStatement;
	int rows;
	String returnMessage;
	ResultSet userResult;
	
	private static final Logger logger = LogManager.getLogger(DeleteCourseDaoImpl.class);

	@Override
	public ArrayList<User> viewUsers() {
		User user;
		ArrayList<User> userList = new ArrayList<User>();
		connection = DatabaseConnection.getConnection();
		try {
			selectStatement = connection.createStatement();
			query = "Select BannerID, FName, LName from users";
			userResult = selectStatement.executeQuery(query);		
			while (userResult.next()) {
				user = new User();
				user.setbId(userResult.getString("BannerID"));
				user.setfName(userResult.getString("FName"));
				user.setlName(userResult.getString("LName"));
				userList.add(user);
			}
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				selectStatement.close();
				connection.close();
			} catch (SQLException e) {
				logger.error(e);
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
		try {
			statement = connection.prepareStatement(query);

			rows = statement.executeUpdate();
			if (rows > 0) {
				message = "Instructor added successfully";
			}

		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			message = "Selected instructor already added for selected course";
		} catch (Exception e) {

			logger.error(e);
		}
		return message;
	}

}
