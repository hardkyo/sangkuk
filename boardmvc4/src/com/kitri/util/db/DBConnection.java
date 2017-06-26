package com.kitri.util.db;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class DBConnection {
/*
//	JDBC 1.0
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 완료!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.31:1521:orcl", "kitri", "kitri");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","kitri","kitri");
			System.out.println("DB 연결 완료!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
 */
	
//	JDBC 2.0 >> Connection Pool
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Context ctx = new InitialContext(); // ctx = 윈도우 탐색기라고 생각
			Context rootCtx = (Context) ctx.lookup("java:comp/env"); // root Context
			DataSource ds = (DataSource) rootCtx.lookup("jdbc/kitri"); // Resource Name
			conn = ds.getConnection();
		} catch (NamingException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return conn;
	}
}
