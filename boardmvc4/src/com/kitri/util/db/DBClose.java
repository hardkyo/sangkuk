package com.kitri.util.db;

import java.sql.*;

public class DBClose {
	public static void close(Connection conn, Statement stmt) {
		try { // rs stmt conn 순서대로 닫아주기
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try { // rs stmt conn 순서대로 닫아주기
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try { // rs stmt conn 순서대로 닫아주기
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try { // rs stmt conn 순서대로 닫아주기
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
