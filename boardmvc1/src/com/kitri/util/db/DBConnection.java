package com.kitri.util.db;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class DBConnection {

//	JDBC 1.0
//	static {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Connection getConnection() {
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.31:1521:orcl", "kitri", "kitri");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
//	JDBC 2.0 >> Connection Pool
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			Context rootCtx = (Context) ctx.lookup("java:comp/env/");
			DataSource ds = (DataSource) rootCtx.lookup("jdbc/kitri");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
