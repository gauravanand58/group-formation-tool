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

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.util.DatabaseConnection;

public class UserHomeDaoImpl implements IUserHomeDao{

	@Override
	public void loadUserWithID(String bannerID, IUser user) {
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * from Users where BannerID = ?;";
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bannerID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user.setBannerID(bannerID);
				user.setEmail(resultSet.getString("Email"));
				user.setFirstName(resultSet.getString("FName"));
				user.setLastName(resultSet.getString("LName"));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Error while loading user from Users table");
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
	public void loadUserCourseMap(IUser user) {
		PreparedStatement preparedStatement = null;
		String userCourseSql = "SELECT * from User_Course_Assoc where UCBannerID = ?;";
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(userCourseSql);
			preparedStatement.setString(1, user.getBannerID());
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
			preparedStatement.close();
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

	
	
}
