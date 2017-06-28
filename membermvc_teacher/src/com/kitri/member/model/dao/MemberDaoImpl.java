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
			String sql = "select count(id) from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			// count = 1;
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
			sql += "select substr(zipcode,1,instr(zipcode,'-')-1) zip1, \n";
			sql += "	substr(zipcode , instr(zipcode,'-')+1) zip2, \n";
			sql += "	sido, gugun, dong, nvl(bunji,' ') bunji \n";
			sql += "from zipcode \n";
			sql += "where dong like '%'||?||'%' \n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipDto zipdto = new ZipDto();
				zipdto.setZip1(rs.getString("zip1"));
				zipdto.setZip2(rs.getString("zip2"));
				zipdto.setSido(rs.getString("sido"));
				zipdto.setGugun(rs.getString("gugun"));
				zipdto.setDong(rs.getString("dong"));
				zipdto.setBunji(rs.getString("bunji"));
				list.add(zipdto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public int register(MemberDetailDto mddto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "insert all \n";
			sql += "into member (id, name, pass, email1, email2) \n";
			sql += "values (?, ?, ?, ?, ?) \n";
			sql += "into member_detail (id, tel1, tel2, tel3, zip1, zip2, addr1, addr2,joindate) \n";
			sql += "values (?, ?, ?, ?, ?, ?, ?, ?,sysdate) \n";
			sql += "select * from dual";

			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			pstmt.setString(++idx, mddto.getId());
			pstmt.setString(++idx, mddto.getName());
			pstmt.setString(++idx, mddto.getPass());
			pstmt.setString(++idx, mddto.getEmail1());
			pstmt.setString(++idx, mddto.getEmail2());
			pstmt.setString(++idx, mddto.getId());
			pstmt.setString(++idx, mddto.getTel1());
			pstmt.setString(++idx, mddto.getTel2());
			pstmt.setString(++idx, mddto.getTel3());
			pstmt.setString(++idx, mddto.getZip1());
			pstmt.setString(++idx, mddto.getZip2());
			pstmt.setString(++idx, mddto.getAddr1());
			pstmt.setString(++idx, mddto.getAddr2());

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDto mdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "select * from member \n";
			sql += "where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpwd"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mdto = new MemberDto();
				mdto.setId(rs.getString("id"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail1(rs.getString("email1"));
				mdto.setEmail2(rs.getString("email2"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return mdto;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		MemberDetailDto mmdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "select * from member m, member_detail md \n";
			sql += "where m.id=md.id and m.id=?";
			;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mmdto = new MemberDetailDto();
				mmdto.setId(rs.getString("id"));
				mmdto.setName(rs.getString("name"));
				mmdto.setEmail1(rs.getString("email1"));
				mmdto.setEmail2(rs.getString("email2"));
				mmdto.setPass(rs.getString("pass"));
				mmdto.setAddr1(rs.getString("addr1"));
				mmdto.setAddr2(rs.getString("addr2"));
				mmdto.setTel1(rs.getString("tel1"));
				mmdto.setTel2(rs.getString("tel2"));
				mmdto.setTel3(rs.getString("tel3"));
				mmdto.setZip1(rs.getString("zip1"));
				mmdto.setZip2(rs.getString("zip2"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return mmdto;
	}

	@Override
	public int modify(MemberDetailDto mddto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "update member  \n";
			sql += "set pass=?,email1=?,email2=? \n";
			sql += "where id=?";

			pstmt = conn.prepareStatement(sql);
			int idx = 0;

			pstmt.setString(++idx, mddto.getPass());
			pstmt.setString(++idx, mddto.getEmail1());
			pstmt.setString(++idx, mddto.getEmail2());
			pstmt.setString(++idx, mddto.getId());
			cnt += pstmt.executeUpdate();

			sql = "";
			sql += "update member_detail  \n";
			sql += "set tel1=?,tel2=?,tel3=?,zip1=?,zip2=?,addr1=?,addr2=? \n";
			sql += "where id=?";
			pstmt = conn.prepareStatement(sql);
			idx = 0;
			pstmt.setString(++idx, mddto.getTel1());
			pstmt.setString(++idx, mddto.getTel2());
			pstmt.setString(++idx, mddto.getTel3());
			pstmt.setString(++idx, mddto.getZip1());
			pstmt.setString(++idx, mddto.getZip2());
			pstmt.setString(++idx, mddto.getAddr1());
			pstmt.setString(++idx, mddto.getAddr2());
			pstmt.setString(++idx, mddto.getId());
			cnt += pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}

	
//	@Override
//	public int modify(MemberDetailDto mddto) {
//		int cnt=0;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = "";
//			sql += "update member  \n";
//			sql += "set pass=?,email1=?,email2=? \n";
//		    sql += "where id=?";
//			
//			pstmt = conn.prepareStatement(sql);
//			int idx=0;
//
//			pstmt.setString(++idx, mddto.getPass());
//			pstmt.setString(++idx, mddto.getEmail1());
//			pstmt.setString(++idx, mddto.getEmail2());
//			pstmt.setString(++idx, mddto.getId());
//			cnt+=pstmt.executeUpdate();
//		} catch (Exception e) {
//
//		} finally {
//			DBClose.close(conn, pstmt);
//			}		
//		try {
//				conn = DBConnection.getConnection();
//				String sql = "";
//				sql += "update member_detail  \n";
//				sql += "set tel1=?,tel2=?,tel3=?,zip1=?,zip2=?,addr1=?,addr2=? \n";
//			    sql += "where id=?";
//				pstmt = conn.prepareStatement(sql);
//				int idx=0;
//				pstmt.setString(++idx, mddto.getTel1());
//				pstmt.setString(++idx, mddto.getTel2());
//				pstmt.setString(++idx, mddto.getTel3());
//				pstmt.setString(++idx, mddto.getZip1());
//				pstmt.setString(++idx, mddto.getZip2());
//				pstmt.setString(++idx, mddto.getAddr1());
//				pstmt.setString(++idx, mddto.getAddr2());
//				pstmt.setString(++idx, mddto.getId());
//				cnt+=pstmt.executeUpdate();
//				System.out.println(cnt);
//			} catch (Exception e) {
//
//			} finally {
//				DBClose.close(conn, pstmt);
//				}
//
//	
//		return cnt;
//	}
	@Override
	public int delete(String id) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "delete member  \n";
			sql += "where id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			cnt += pstmt.executeUpdate();
			
//			sql = "";
//			sql += "delete member  \n";
//			sql += "where id=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			cnt += pstmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			DBClose.close(conn, pstmt);
		}
		

		return cnt;
	}

}
