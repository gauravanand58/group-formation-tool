package com.advsdc.group4.UserProfile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.advsdc.group4.Model.IUserAuth;
import com.advsdc.group4.Model.UserAuth;
import com.advsdc.group4.util.DatabaseConnection;


public class UserAuthDaoImpl implements IUserAuthDao{

	@Override
	public void loadUserAuth(String bannerID, IUserAuth userAuth) {
		PreparedStatement ps;
		try {
			ps = DatabaseConnection.getConnection()
					.prepareStatement("select * from UserAuth where UBannerID = ? ;");
			ps.setString(1, bannerID);
			 ResultSet rs = ps.executeQuery(); 
			 if(rs.next()) {
				 userAuth.setBannerID(bannerID);
				 userAuth.setPassword(rs.getString("UPassword"));
				 userAuth.setOtp(rs.getString("OtpCode"));
				 userAuth.setTimestamp(rs.getTimestamp("timeStamp"));
			 }

		} catch (SQLException e) {
			System.out.println("Error while loading user details:"+ e);
		} finally {
			DatabaseConnection.closeConnection();
		}	
	}

	@Override
	public int saveOtp(UserAuth userAuth) {
		 PreparedStatement ps;
		 int rs = 0;
		try {
			
			String query = "UPDATE UserAuth SET OtpCode= ? , timeStamp =CURRENT_TIMESTAMP() WHERE UBannerID = ? ;";
			ps = DatabaseConnection.getConnection()
					.prepareStatement(query);
			ps.setString(1, userAuth.getOtp());
			ps.setString(2, userAuth.getBannerID());
			rs = ps.executeUpdate(); 


		} catch (SQLException e) {
			System.out.println("Error while updating user details:"+ e);
		} finally {
			DatabaseConnection.closeConnection();
		}	
		
		return rs;		
	}

	@Override
	public int userResetPassword(UserAuth userAuth) {

		 PreparedStatement ps;
		 int rs = 0;
			try {
				
				String query = "UPDATE UserAuth SET UPassword = ?, OtpCode = '' WHERE UBannerID = ? ;";
				ps = DatabaseConnection.getConnection()
						.prepareStatement(query);
				ps.setString(1, userAuth.getPassword());
				ps.setString(2, userAuth.getBannerID());
				rs= ps.executeUpdate(); 

			} catch (SQLException e) {
				System.out.println("Error while updating user details:"+ e);
			} finally {
				DatabaseConnection.closeConnection();
			}	
		return rs;	
				
	}
	
	
}
