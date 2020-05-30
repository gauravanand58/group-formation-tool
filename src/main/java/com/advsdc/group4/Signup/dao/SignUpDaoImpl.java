package com.advsdc.group4.Signup.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advsdc.group4.Landing.util.DatabaseConnection;
import com.advsdc.group4.Model.User;

@Repository
public class SignUpDaoImpl implements SignUpDao{
	
	@Autowired
	DatabaseConnection databaseConnection;
	
	@Override
	public boolean addUser(User user) {
		PreparedStatement preparedStatement;
		String usersQuery = "INSERT INTO Users (BannerID, FName, LName, Email) "+
				" VALUES (?,?,?,?)";
		try {
			preparedStatement = databaseConnection.getConnection().prepareStatement(usersQuery);
			preparedStatement.setString(1, user.getBannerID());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Error while adding user in Users table");
			e.printStackTrace();
			return false;
		}
		return (addUserPassword(user) && addUserCourseAssociation(user));
	}
	
	private boolean addUserCourseAssociation(User user) {
		PreparedStatement preparedStatement;
		String userCourseQuery = "INSERT INTO User_Course_Assoc (UCBannerID, UCRoleID, UCCourseID) "+
				" VALUES (?,?,?)";
		try {
			preparedStatement = databaseConnection.getConnection().prepareStatement(userCourseQuery);
			preparedStatement.setString(1, user.getBannerID());
			preparedStatement.setInt(2, user.getRole());
			preparedStatement.setInt(3, 0);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Error while adding user into UserCourse Assoc table");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean addUserPassword(User user) {
		PreparedStatement preparedStatement;
		String usersAuthQuery = "INSERT INTO UserAuth (UBannerID, UPassword) "+
				" VALUES (?,?)";
		try {
			preparedStatement = databaseConnection.getConnection().prepareStatement(usersAuthQuery);
			preparedStatement.setString(1, user.getBannerID());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Error while adding user into UsersAuth table");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean userExists(User user) {
		PreparedStatement preparedStatement;
		String sql = "SELECT * from Users where BannerID = ?";
		try {
			preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, user.getBannerID());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				return false;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Error while checking user in Users table");
			e.printStackTrace();
			return true;
		}
		return true;
	}
}
