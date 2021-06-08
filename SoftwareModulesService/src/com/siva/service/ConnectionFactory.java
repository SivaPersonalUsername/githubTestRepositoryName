package com.siva.service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;


public class ConnectionFactory {


	private static String dbUrl="jdbc:sqlserver://localhost:1433;databaseName=testdb";
	private static String dbUname="sa";
	private static String dbPassword="Welcome1";
	private static String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	
	

	
	private static void listDrivers() {
	    Enumeration<Driver> driverList = DriverManager.getDrivers();
	    while (driverList.hasMoreElements()) {
	      Driver driverClass = (Driver) driverList.nextElement();
	      System.out.println(" +++++driverClass+++++++++  "+driverClass.getClass().getName());
	    }
	  }
	public static Connection getConnection() {
		
		listDrivers();
		loadDriver(dbDriver);
	   
		Connection con=null;
		try {
			con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}


	private static void loadDriver(String dbDriver2) {
		try {
			Class.forName(dbDriver2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
