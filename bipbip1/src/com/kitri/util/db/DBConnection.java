package com.kitri.util.db;

import java.sql.*;

public class DBConnection {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("����̹��ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		 Connection conn = null;
		 try {
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kitri","kitri");
//			System.out.println("db���Ἲ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
