package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		int count = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(id) \n";
			sql += "from member \n";
			sql += "where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
//			count = 1;
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return count;
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		List<ZipDto> list = new ArrayList<ZipDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "select	substr(zipcode, 1, instr(zipcode, '-') - 1) zip1, \n";
			sql += "	substr(zipcode, instr(zipcode, '-') + 1) zip2, \n";
			sql += "	sido, gugun, dong, nvl(bunji, ' ') bunji \n";
			sql += "from zipcode \n";
			sql += "where dong like '%'||?||'%' \n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipDto zipDto = new ZipDto();
				zipDto.setZip1(rs.getString("zip1"));
				zipDto.setZip2(rs.getString("zip2"));
				zipDto.setSido(rs.getString("sido"));
				zipDto.setGugun(rs.getString("gugun"));
				zipDto.setDong(rs.getString("dong"));
				zipDto.setBunji(rs.getString("bunji"));
				
				list.add(zipDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "insert all \n";
			sql += "	into member (id, name, pass, email1, email2) \n";
			sql += "	values (?, ?, ?, ?, ?) \n";
			sql += "	into member_detail (id, tel1, tel2, tel3, zip1, zip2, addr1, addr2, joindate) \n";
			sql += "	values (?, ?, ?, ?, ?, ?, ?, ?, sysdate) \n";
			sql += "select * from dual \n";
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getEmail1());
			pstmt.setString(++idx, memberDetailDto.getEmail2());
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			pstmt.setString(++idx, memberDetailDto.getZip1());
			pstmt.setString(++idx, memberDetailDto.getZip2());
			pstmt.setString(++idx, memberDetailDto.getAddr1());
			pstmt.setString(++idx, memberDetailDto.getAddr2());
			cnt = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "select id, name, email1, email2 \n";
			sql += "from member \n";
			sql += "where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpwd"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmail1(rs.getString("email1"));
				memberDto.setEmail2(rs.getString("email2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDto;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}














