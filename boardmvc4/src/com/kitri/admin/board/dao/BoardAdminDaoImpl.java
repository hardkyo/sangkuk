package com.kitri.admin.board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.admin.board.model.*;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class BoardAdminDaoImpl implements BoardAdminDao {

	private static BoardAdminDao boardAdminDao;
	
	static {
		boardAdminDao = new BoardAdminDaoImpl();
	}
	
	private BoardAdminDaoImpl() {}
	
	public static BoardAdminDao getBoardAdminDao() {
		return boardAdminDao;
	}

	@Override
	public List<BoardListDto> boardList() {
		List<BoardListDto> list = new ArrayList<BoardListDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "select bl.bcode, c.cname, bl.bname, bl.btype, c.ccode, \n";
			sql += "	   decode(bl.btype, 5, 'reboard', \n";
			sql += "				 		6, 'album', \n";
			sql += "				 		7, 'bbs', \n";
			sql += "				 		'board') control \n";
			sql += "from board_list bl, category c \n";
			sql += "where bl.ccode = c.ccode";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardListDto boardListDto = new BoardListDto();
				boardListDto.setBcode(rs.getInt("bcode"));
				boardListDto.setCname(rs.getString("cname"));
				boardListDto.setBname(rs.getString("bname"));
				boardListDto.setBtype(rs.getInt("btype"));
				boardListDto.setCcode(rs.getInt("ccode"));
				boardListDto.setControl(rs.getString("control"));
				
				list.add(boardListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<CategoryDto> categoryList() {
		List<CategoryDto> list = new ArrayList<CategoryDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select ccode, cname \n"); 
			sql.append("from category \n"); 
			sql.append("order by ccode"); 
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CategoryDto categoryDto = new CategoryDto();
				categoryDto.setCcode(rs.getInt("ccode"));
				categoryDto.setCname(rs.getString("cname"));
				
				list.add(categoryDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public void categoryMake(String cname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into category (ccode, cname) \n");
			sql.append("values (category_cseq.nextval, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, cname);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public List<BoardTypeDto> boardTypeList() {
		List<BoardTypeDto> list = new ArrayList<BoardTypeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select btype, btype_name \n"); 
			sql.append("from board_type \n"); 
			sql.append("order by btype"); 
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardTypeDto boardTypeDto = new BoardTypeDto();
				boardTypeDto.setBtype(rs.getInt("btype"));
				boardTypeDto.setBtype_name(rs.getString("btype_name"));
				
				list.add(boardTypeDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public void boardMake(BoardListDto boardListDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into board_list (bcode, bname, ccode, btype) \n");
			sql.append("values (board_list_seq.nextval, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardListDto.getBname());
			pstmt.setInt(2, boardListDto.getCcode());
			pstmt.setInt(3, boardListDto.getBtype());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

}
















