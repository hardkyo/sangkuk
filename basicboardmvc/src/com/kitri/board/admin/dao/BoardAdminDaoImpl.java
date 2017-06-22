package com.kitri.board.admin.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class BoardAdminDaoImpl implements BoardAdminDao {
	// �̱��� - �ܺο��� �������Ѵ�. ���ο��� �����. �ϳ��� �����. �ܺο��� ���ٶ����� ����.

	private static BoardAdminDao boardAdminDao; // 2. �����̺� ������ƽ �������� �����.

	static {
		boardAdminDao = new BoardAdminDaoImpl(); // 3. ������ƽ����� �̿��� ������ ȣ��
	}

	public static BoardAdminDao getBoardAdminDao() { // 4. ���� �����.
		return boardAdminDao;
	}

	private BoardAdminDaoImpl() {
	} // 1. �����ڸ� �����̺�����

	@Override
	public List<BoardListDto> boardList() {
		List<BoardListDto> list = new ArrayList<BoardListDto>(); //list ��ü����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "select bl.bcode, c.cname, bl.bname, bl.btype, c.ccode, ";
			sql+= "decode(bl.btype, 5, 'reboard',\n";
			sql+= " 				6, 'album',\n";		
			sql+= "					7, 'bbs', \n";		
			sql+= "					'board') control \n";		
			sql+= "from board_list bl, category c \n";
			sql+= " where bl.ccode = c.ccode \n";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardListDto bdto = new BoardListDto();
				bdto.setBcode(rs.getInt("bcode"));
				bdto.setBname(rs.getString("bname"));
				bdto.setBtype(rs.getInt("btype"));
				bdto.setCcode(rs.getInt("ccode"));
				bdto.setCname(rs.getString("cname"));
				bdto.setControl(rs.getString("control"));
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

}
