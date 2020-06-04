package com.advsdc.group4.UserProfile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.advsdc.group4.Model.IUserAuth;
import com.advsdc.group4.Model.UserAuth;
import com.advsdc.group4.util.DatabaseConnection;
import com.advsdc.group4.util.PasswordEncoder;


public class UserAuthDaoImpl implements IUserAuthDao{

	@Override
	public void loadUserAuth(String bannerID, IUserAuth userAuth) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection =  DatabaseConnection.getConnection();
			ps =connection
					.prepareStatement("select * from UserAuth where UBannerID = ? ;");
			ps.setString(1, bannerID);
			 ResultSet rs = ps.executeQuery(); 
			 if(rs.next()) {
				 userAuth.setBannerID(bannerID);
				 userAuth.setPassword(rs.getString("UPassword"));
				 userAuth.setOtp(rs.getString("OtpCode"));
				 userAuth.setTimestamp(rs.getTimestamp("timeStamp"));
			 }
			 ps.close();
			 connection.close();
		} catch (SQLException e) {
			System.out.println("Error while loading user details:"+ e);
		} finally {
			DatabaseConnection.closeConnection();
		}	
	}

	@Override
	public int saveOtp(UserAuth userAuth) {
		Connection connection = null;
		 PreparedStatement ps;
		 int rs = 0;
		try {
			
			String query = "UPDATE UserAuth SET OtpCode= ? , timeStamp =CURRENT_TIMESTAMP() WHERE UBannerID = ? ;";
			connection =  DatabaseConnection.getConnection();
			ps =connection
					.prepareStatement(query);
			ps.setString(1, userAuth.getOtp());
			ps.setString(2, userAuth.getBannerID());
			rs = ps.executeUpdate(); 
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error while updating user details:"+ e);
		} finally {
			DatabaseConnection.closeConnection();
		}	
		
		return rs;		
	}

	@Override
	public int userResetPassword(UserAuth userAuth) {
		Connection connection = null;
		 PreparedStatement ps;
		 int rs = 0;
			try {
				
				String query = "UPDATE UserAuth SET UPassword = ?, OtpCode = '' WHERE UBannerID = ? ;";
				connection =  DatabaseConnection.getConnection();
				ps =connection
						.prepareStatement(query);
				ps.setString(1, userAuth.getPassword());
				ps.setString(2, userAuth.getBannerID());
				rs= ps.executeUpdate(); 
				ps.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error while updating user details:"+ e);
			} finally {
				DatabaseConnection.closeConnection();
			}	
		return rs;	
				
	}

	@Override
	public boolean validateUserCredentials(String username, String password) {
		Connection connection = null;
		 PreparedStatement ps;
			try {
				
				String query = "Select UBannerID, UPassword from UserAuth where UBannerID = ? ;";
				connection =  DatabaseConnection.getConnection();
				ps =connection
						.prepareStatement(query);
				ps.setString(1, username);
				ResultSet result= ps.executeQuery(); 
				if(result.next()) {
					PasswordEncoder encoder = new PasswordEncoder();
					if(encoder.match(password, result.getString("UPassword"))) {
						return true;
					}
					return false;
				}
				ps.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error while validating user details:"+ e);
			} finally {
				DatabaseConnection.closeConnection();
			}	
		return false;	
				
	}

	@Override
	public List<String> fetchUserRoles(String username) {
		Connection connection = null;
		 PreparedStatement ps;
		 List<String> roles = new ArrayList<String>();
			try {
				
				String query = "select BannerID as username, RoleName  from Users join User_Course_Assoc on UCBannerID=BannerID join Role on UCRoleID = ID where BannerID= ? ;";
				connection =  DatabaseConnection.getConnection();
				ps =connection
						.prepareStatement(query);
				ps.setString(1, username);
				ResultSet result= ps.executeQuery(); 
				while(result.next()) {
					roles.add(result.getString("RoleName"));
				}
				ps.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error while retrieving user roles:"+ e);
			} finally {
				DatabaseConnection.closeConnection();
			}	
		return roles;	
				
	}
	
	
}
