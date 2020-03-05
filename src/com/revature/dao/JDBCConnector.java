package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

public class JDBCConnector {
	private static Connection conn;
	private static String url, root, passwd;
	
	public JDBCConnector() {
		super();
		init();
	}
	
	public static Connection getConn() {
		if (conn == null) {
			setConn();
		}
		return conn;
	}
	
	private static void setConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url, root, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			JDBCConnector.init();
			Connection testConn = getConn();
			PreparedStatement st = testConn.prepareStatement("SELECT * FROM YIPYIP");
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("YIPYIP"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static void init() {
		url = System.getenv("JavaBank_URL");
		root = System.getenv("JavaBank_Login");
		passwd = System.getenv("JavaBank_Password");
		
		conn = getConn();
	}
}
