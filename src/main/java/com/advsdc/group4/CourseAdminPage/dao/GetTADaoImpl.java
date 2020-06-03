package com.advsdc.group4.GetTA.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advsdc.group4.Landing.util.DatabaseConnection;

@Service
public class GetTADaoImpl implements GetTADao{
	@Autowired
	DatabaseConnection data;
	
	@Override
	public String getUser(String bannerID,int courseID) {
		PreparedStatement ps;
		 String taInfo = "";
		 Boolean validEnroll=true;
		try {
			ps = data.getConnection().prepareStatement("select * from Users where BannerID='"+bannerID+"';");
			 ResultSet rs = ps.executeQuery(); 
			 if(rs.next()) {
				 ps = data.getConnection().prepareStatement("select * from User_Course_Assoc where UCBannerID='"+bannerID+"' and UCCourseID="+courseID+";");
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
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		if (taInfo=="") {
			return null;
		}else {
			return taInfo;
		}
	}

	@Override
	public Boolean insertTA(String bannerID, int courseID) {
		PreparedStatement ps;
		int rs=0;
		try {
			ps = data.getConnection().prepareStatement("insert into User_Course_Assoc values('"+bannerID+"',3,"+courseID+");");
			rs = ps.executeUpdate(); 
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
		if(rs==0) {
			return false;
		}else {
			return true;
		} 

	}
}
