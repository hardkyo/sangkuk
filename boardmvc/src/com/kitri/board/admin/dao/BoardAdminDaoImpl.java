package com.kitri.board.admin.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class BoardAdminDaoImpl implements BoardAdminDao {
	// 싱글톤 - 외부에서 생성못한다. 내부에서 만든다. 하나만 만든다. 외부에서 접근때문에 게터.

	private static BoardAdminDao boardAdminDao; // 2. 프라이빗 스테이틱 전역변수 만든다.

	static {
		boardAdminDao = new BoardAdminDaoImpl(); // 3. 스테이틱블록을 이용해 생성자 호출
	}

	public static BoardAdminDao getBoardAdminDao() { // 4. 게터 만든다.
		return boardAdminDao;
	}

	private BoardAdminDaoImpl() {
	} // 1. 생성자를 프라이빗으로

	@Override
	public List<BoardListDto> boardList() {
		List<BoardListDto> list = new ArrayList<BoardListDto>(); //list 객체생성
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
