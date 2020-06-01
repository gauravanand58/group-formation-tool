package com.advsdc.group4.Signup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.util.DatabaseConnection;

public class SignUpDaoImpl implements SignUpDao{
	
	DatabaseConnection databaseConnection;
	
	public SignUpDaoImpl() {
		databaseConnection = new DatabaseConnection();
	}
	
	@Override
	public boolean addUser(IUser user) {
		PreparedStatement preparedStatement;
		String usersQuery = "INSERT INTO Users (BannerID, FName, LName, Email) "+
				" VALUES (?,?,?,?)";
		Connection connection = databaseConnection.getConnection();
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
		return (addUserPassword(user) && addUserCourseAssociation(user));
	}
	
	private boolean addUserCourseAssociation(IUser user) {
		PreparedStatement preparedStatement;
		String userCourseQuery = "INSERT INTO User_Course_Assoc (UCBannerID, UCRoleID, UCCourseID) "+
				" VALUES (?,?,?)";
		Connection connection = databaseConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(userCourseQuery);
			preparedStatement.setString(1, user.getBannerID());
			preparedStatement.setInt(2, user.getRole());
			preparedStatement.setInt(3, 0);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error while adding user into UserCourse Assoc table");
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
	
	private boolean addUserPassword(IUser user) {
		PreparedStatement preparedStatement;
		String usersAuthQuery = "INSERT INTO UserAuth (UBannerID, UPassword) "+
				" VALUES (?,?)";
		Connection connection = databaseConnection.getConnection();
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
		Connection connection = databaseConnection.getConnection();
		try {
			System.out.println("DB " + databaseConnection);
			System.out.println(" : " + databaseConnection.getConnection());
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

	@Override
	public void loadUserWithID(String bannerID, IUser user) {
		// write search user code 
	}
}
