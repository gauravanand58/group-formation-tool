package com.advsdc.group4.UserProfile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.advsdc.group4.Model.IUserAuth;
import com.advsdc.group4.util.DatabaseConnection;

public class UserAuthDaoImpl implements IUserAuthDao{

	@Override
	public void loadUserAuth(String bannerID, IUserAuth userAuth) {
		PreparedStatement ps;
		try {
			ps = DatabaseConnection.getConnection()
					.prepareStatement("select * from UserAuth where BannerID=?;");
			ps.setString(1, bannerID);
			 ResultSet rs = ps.executeQuery(); 
			 if(rs.next()) {
				 userAuth.setPassword(rs.getString("UPassword"));
				 userAuth.setOtp(rs.getString("OtpCode"));
				 userAuth.setTimestamp(rs.getTimestamp("timeStamp"));
			 }
		} catch (SQLException e) {
			System.out.println("Error while validating user:"+ e);
		} 		
	}
}
