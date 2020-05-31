package com.advsdc.group4.UserProfile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.IUserAuth;
import com.advsdc.group4.util.DatabaseConnection;

public class UserProfileDaoImpl implements IUserProfileDao{

	@Override
	public void loadUserWithID(String bannerID, IUser user) {
		PreparedStatement ps;
		 
		try {
			ps = DatabaseConnection.getConnection()
					.prepareStatement("select * from Users where BannerID=?;");
			ps.setString(1, bannerID);
			 ResultSet rs = ps.executeQuery(); 
			 if(rs.next()) {
				 user.setEmail(rs.getString("Email"));
				 user.setFirstName(rs.getString("FName"));
				 user.setLastName(rs.getString("LName"));
			 }
		} catch (SQLException e) {
			System.out.println("Error while validating user:"+ e);
		} 		
	}

}
