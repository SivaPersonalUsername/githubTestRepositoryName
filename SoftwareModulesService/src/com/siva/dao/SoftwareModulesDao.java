package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siva.service.ConnectionFactory;
import com.siva.service.SoftwareModule;

public class SoftwareModulesDao {

	public SoftwareModule getSoftwareModuleById(int smid) {
		Connection con=ConnectionFactory.getConnection();
		SoftwareModule softwareModule=null;
		try {
			System.out.println("smid+++++++"+ smid);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from SOFTWARE_MODULES where SMID='"+smid+"'");
if(rs.next()) {
	softwareModule=new SoftwareModule();
	softwareModule.setSmid(rs.getInt(1));
	softwareModule.setUsername(rs.getString(2));
	softwareModule.setSm_name(rs.getString(3));
	softwareModule.setSm_des(rs.getString(4));
	softwareModule.setSm_version(rs.getInt(5));
}


		}catch (Exception e) {
			// TODO: handle exception
		}
		return softwareModule;
	}

	public List<SoftwareModule> fetchAll() {
		List<SoftwareModule>  softwareModulesList=new ArrayList<SoftwareModule>();
		
		String selectQuery="Select * from SOFTWARE_MODULES";
		Connection con=ConnectionFactory.getConnection();
		SoftwareModule softwareModule=null;
		try {
			System.out.println("fetchAll+++++++");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(selectQuery);
while(rs.next()) {
	softwareModule=new SoftwareModule();
	softwareModule.setSmid(rs.getInt(1));
	softwareModule.setUsername(rs.getString(2));
	softwareModule.setSm_name(rs.getString(3));
	softwareModule.setSm_des(rs.getString(4));
	softwareModule.setSm_version(rs.getInt(5));
	softwareModulesList.add(softwareModule);
}


		}catch (Exception e) {
			e.printStackTrace();
		}
		return softwareModulesList;
	}

	public int createModule(SoftwareModule softwareModule) {
		String insertQuery="INSERT INTO SOFTWARE_MODULES VALUES(?,?,?,?)";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement stmt=null;
		int i=0;
		try {
			System.out.println("INSERT QUERY ==="+insertQuery);
			stmt = con.prepareStatement(insertQuery);
			stmt.setString(1,softwareModule.getUsername());//1 specifies the first parameter in the query  
			stmt.setString(2,softwareModule.getSm_name()); 
			stmt.setString(3,softwareModule.getSm_des());
			stmt.setInt(4,softwareModule.getSm_version());
			
			i=stmt.executeUpdate();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 return i;
	}

}
