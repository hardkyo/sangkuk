package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

public class UserDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public UserDao() { // ���� mysql ��������.
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹� ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String userID, String userPassword) {

		String sql = "select userPassword from user where userID = ?";
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("userPassword").equals(userPassword)) {
					System.out.println(rs.next());
					return 1; // �α��� ����
				} else {
					return 0; // ��й�ȣ ����ġ
				}
			}
			return -1; // ���̵����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // �����ͺ��̽� ����
		// finally {
		//
		// try {
		// if (rs != null) {
		// rs.close();
		// }
		// if (pstmt != null) {
		// pstmt.close();
		// }
		// if (conn != null) {
		// conn.close();
		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }

	}
	
	public int join(User user){
		String sql = "insert into user values(?,?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ���� 
	}

}
