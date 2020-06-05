package com.advsdc.group4.CourseAdminPage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.util.DatabaseConnection;


public class GetTADaoImpl implements GetTADao{

	
	@Override
	public String getUser(IUser user,int courseID) {
		PreparedStatement ps = null;
		 String taInfo = "";
		 Boolean validEnroll=true;
		try {
			ps = DatabaseConnection.getConnection().prepareStatement("select * from Users where BannerID=?;");
			ps.setString(1, user.getBannerID());
			 ResultSet rs = ps.executeQuery(); 
			 if(rs.next()) {
				 ps = DatabaseConnection.getConnection().prepareStatement("select * from User_Course_Assoc where UCBannerID=? and UCCourseID=?;");
				 ps.setString(1, user.getBannerID());
				 ps.setInt(2, courseID);
				 ResultSet rs1 = ps.executeQuery(); 
				 while(rs1.next()) {
					 if(rs1.getInt("UCRoleID")==4 || rs1.getInt("UCRoleID")==3) {
//						 taInfo +=  rs1.getString("UCBannerID")+"already exists has Student/TA for the course "+rs1.getInt("UCCourseID");
						 taInfo="";
						 validEnroll=false;
						 break;
					 }
				 }
				 if(validEnroll) {
				 taInfo += rs.getString("FName")+" "+rs.getString("LName")+"("+rs.getString("BannerID")+")";
				 }
			 }	 
			 else {
//				 taInfo += "No user exists with banner ID:"+bannerID;
				 taInfo="";
			 }
			 ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
				DatabaseConnection.closeConnection();
		}
		if (taInfo=="") {
			return null;
		}else {
			return taInfo;
		}
	}

	@Override
	public Boolean insertTA(IUser user, int courseID) {
		PreparedStatement ps = null;
		int rs=0;
		try {
			ps = DatabaseConnection.getConnection().prepareStatement("insert into User_Course_Assoc values(?,3,?);");
			ps.setString(1, user.getBannerID());
			ps.setInt(2, courseID);
			rs = ps.executeUpdate(); 
			ps.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
			DatabaseConnection.closeConnection();
		
	}
		if(rs==0) {
			return false;
		}else {
			return true;
		} 

	}
}
