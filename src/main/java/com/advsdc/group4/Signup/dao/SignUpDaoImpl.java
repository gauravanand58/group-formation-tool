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
	public boolean addEntry(User user) {
		//add db entry logic
		PreparedStatement preparedStatement;
		String sql = "INSERT INTO Users (BannerID ,FName ,LName ,Email) "+
				" VALUES (?,?,?,?)";
		try {
			preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, user.getBannerID());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return true;
	}
}
