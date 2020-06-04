package com.advsdc.group4.UserProfile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.util.DatabaseConnection;


public class UserProfileDaoImpl implements IUserProfileDao{


	@Override
	public void loadUserWithID(String bannerID, IUser user) {
			Connection connection = null;
			PreparedStatement ps = null;
		try {
			connection =  DatabaseConnection.getConnection();
			ps =connection
					.prepareStatement("select * from Users where BannerID = ?;");
			ps.setString(1, bannerID);
			 ResultSet rs = ps.executeQuery(); 
			 if(rs.next()) {
				 user.setBannerID(bannerID);
				 user.setEmail(rs.getString("Email"));
				 user.setFirstName(rs.getString("FName"));
				 user.setLastName(rs.getString("LName"));
			 }

		} catch (SQLException e) {
			System.out.println("Error while loading user profile:"+ e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Error while closing connection");
			}
		}			
	}

}
