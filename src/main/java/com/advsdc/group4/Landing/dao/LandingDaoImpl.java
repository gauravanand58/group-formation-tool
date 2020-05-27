package com.advsdc.group4.Landing.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advsdc.group4.Landing.util.DatabaseConnection;

@Service
public class LandingDaoImpl implements LandingDao{
	@Autowired  
	DatabaseConnection data;
	@Override
	public String testDb() {
		 PreparedStatement ps;
		 String subTitle = "";
		try {
			ps = data.getConnection().prepareStatement("select * from Role;");
			 ResultSet rs = ps.executeQuery(); 
			 while(rs.next()) {
				 subTitle += rs.getString("RoleName")+" ";
			 }
			 System.out.println("inside try");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return subTitle;
		
	}

}
