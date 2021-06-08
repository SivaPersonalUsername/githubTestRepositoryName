package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

import com.bean.LoginBean;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class LoginDao {
	private static String dbUrl="jdbc:sqlserver://localhost:1433;databaseName=testdb";
	private static String dbUname="sa";
	private static String dbPassword="Welcome1";
	private static String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	
	public boolean validate(LoginBean loginBean) {

		listDrivers();
		loadDriver(dbDriver);
		Connection con=getConnection();
		boolean isValidUser=false;
		String sql_query="select * from login where userName=? and password=?";
		PreparedStatement ps;
		try {
			System.out.println("sql_query::"+sql_query);
			ps=con.prepareStatement(sql_query);
			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getPassword());
			
			ResultSet rs=ps.executeQuery();
			isValidUser=rs.next();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isValidUser;
	}

	
	private static void listDrivers() {
	    Enumeration<Driver> driverList = DriverManager.getDrivers();
	    while (driverList.hasMoreElements()) {
	      Driver driverClass = (Driver) driverList.nextElement();
	      System.out.println(" +++++driverClass+++++++++  "+driverClass.getClass().getName());
	    }
	  }
	private Connection getConnection() {
		
	      
	   
		Connection con=null;
		try {
			con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}


	private void loadDriver(String dbDriver2) {
		try {
			Class.forName(dbDriver2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
