package com.advsdc.group4.UserProfile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.util.DatabaseConnection;

public class SignUpDaoImpl implements ISignUpDao{
	
	
	@Override
	public boolean addUser(IUser user) {
		PreparedStatement preparedStatement;
		String usersQuery = "INSERT INTO Users (BannerID, FName, LName, Email) "+
				" VALUES (?,?,?,?)";
		Connection connection = DatabaseConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(usersQuery);
			preparedStatement.setString(1, user.getBannerID());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error while adding user in Users table");
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return addUserPassword(user) && addRoleCourseMap(user);
	}
	
	private boolean addUserPassword(IUser user) {
		PreparedStatement preparedStatement;
		String usersAuthQuery = "INSERT INTO UserAuth (UBannerID, UPassword) "+
				" VALUES (?,?)";
		Connection connection = DatabaseConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(usersAuthQuery);
			preparedStatement.setString(1, user.getBannerID());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error while adding user into UsersAuth table");
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean userExists(IUser user) {
		PreparedStatement preparedStatement;
		String sql = "SELECT * from Users where BannerID = ?";
		Connection connection = DatabaseConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getBannerID());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				return false;
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error while checking user in Users table");
			e.printStackTrace();
			return true;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private boolean addRoleCourseMap(IUser user) {
		String bannerID = user.getBannerID();
		int role = 5;
		int course = user.getRoleMap().get(5).get(0);
		PreparedStatement preparedStatement;
		String sql = "INSERT INTO User_Course_Assoc (UCBannerID, UCRoleID, UCCourseID) "+
				" VALUES (?,?,?)";
		Connection connection = DatabaseConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bannerID);
			preparedStatement.setInt(2, role);
			preparedStatement.setInt(3, course);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error while adding mapping in User_Course_Assoc table");
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public void loadUserWithID(String bannerID, IUser user) {
		// write search user code 
	}
}
