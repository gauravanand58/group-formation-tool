package com.advsdc.group4.UserHome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.advsdc.group4.Model.Course;
import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.util.DatabaseConnection;

public class UserHomeDaoImpl implements IUserHomeDao{

	@Override
	public void loadUserCourseMap(String bannerID, IUser user) {
		PreparedStatement preparedStatement = null;
		String userCourseSql = "SELECT * from User_Course_Assoc where UCBannerID = ?;";
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(userCourseSql);
			preparedStatement.setString(1, bannerID);
			ResultSet mapResultSet = preparedStatement.executeQuery();
			Map<Integer, List<Integer>> roleMap = new HashMap<>();
			int roleID, courseID;
			while(mapResultSet.next()) {
				roleID = mapResultSet.getInt("UCRoleID");
				courseID = mapResultSet.getInt("UCCourseID");;
				if(roleMap.containsKey(roleID)) {
					roleMap.get(roleID).add(courseID);
				} else {
					List<Integer> list = new LinkedList<>();
					list.add(courseID);
					roleMap.put(roleID, list);
				}
			}
			System.out.println(Arrays.asList(roleMap));
			user.setRoleMap(roleMap);
		} catch (SQLException e) {
			System.out.println("Error while checking user in Users table");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public List<Course> getAllCourses() {
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * from Course";
		Connection connection = null;
		List<Course> courseList = new LinkedList<Course>();
		try {
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			ResultSet mapResultSet = preparedStatement.executeQuery();
			int courseID;
			String courseName, courseDescription;
			while(mapResultSet.next()) {
				courseID = mapResultSet.getInt("CourseID");
				courseName = mapResultSet.getString("CourseName");
				courseDescription = mapResultSet.getString("CourseDescription");
				Course course = new Course(courseID, courseName, courseDescription);
				courseList.add(course);
			}
		} catch (SQLException e) {
			System.out.println("Error while checking user in Users table");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return courseList;
	}

	@Override
	public String getCourseName(int courseID) {
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * from Course where CourseID = ?;";
		Connection connection = null;
		String courseName = null;
		try {
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, courseID);
			ResultSet mapResultSet = preparedStatement.executeQuery();
			if(mapResultSet.next()) {
				courseName = mapResultSet.getString("CourseName");
			}
		} catch (SQLException e) {
			System.out.println("Error while checking user in Users table");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return courseName;
	}
}
