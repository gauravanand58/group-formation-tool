package com.advsdc.group4.CourseAdminPage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.util.DatabaseConnection;

public class EnrollStudentDaoImpl implements EnrollStudentDao {
	
	@Override
	public boolean insertStudentsInDB(IUser user, int courseID) {
		PreparedStatement ps;
		int resultSet;
		Boolean insertStatus=true;
		try {
			ps = DatabaseConnection.getConnection().prepareStatement("insert into Users values(?,?,?,?);");
			ps.setString(1, user.getBannerID());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			resultSet = ps.executeUpdate(); 
			 ps = DatabaseConnection.getConnection().prepareStatement("insert into User_Course_Assoc values(?,?,?);");
			 ps.setString(1, user.getBannerID());
			 ps.setInt(2, 4);
			 ps.setInt(3, courseID);
			 resultSet = ps.executeUpdate(); 
			 if(resultSet==0) {
				 insertStatus=false;
				 
			 }else {
				 ps = DatabaseConnection.getConnection().prepareStatement("insert into UserAuth(UBannerID,UPassword) values(?,?)");
				 ps.setString(1, user.getBannerID());
				 ps.setString(2, user.getPassword());
				 ps.executeUpdate();
				 insertStatus=true;
			 }
			 ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				DatabaseConnection.closeConnection();
		}
		
		return insertStatus;
	}
	@Override
	public List<String> getUser() {
		List<String> existingUsers = new ArrayList<String>();
		PreparedStatement ps;
		ResultSet resultSet;
		try {
			ps = DatabaseConnection.getConnection().prepareStatement("select BannerID from Users;");
			resultSet = ps.executeQuery(); 
			while(resultSet.next()) {
				existingUsers.add(resultSet.getString("BannerID"));
			}
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
				DatabaseConnection.closeConnection();
		}
		return existingUsers;
		
	}

}
