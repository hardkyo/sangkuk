package com.kitri.ajax.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class KeywordDao {

	public List<KeywordDto> searchKeyword(String keyword) {
		List<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * \n");
			sb.append("from naver  \n");
			sb.append("where case	 \n");
			sb.append("			when keyword < 'ㄱ' then upper(substr(keyword, 1, 1))  \n");
			sb.append("			when ascii('ㄱ') <= ascii(keyword) and ascii(keyword)<= ascii('ㅎ') then keyword  \n");
			sb.append("			when keyword < '나' then 'ㄱ' \n");
			sb.append("			when keyword < '다' then 'ㄴ' \n");
			sb.append("			when keyword < '라' then 'ㄷ' \n");
			sb.append("			when keyword < '마' then 'ㄹ' \n");
			sb.append("			when keyword < '바' then 'ㅁ' \n");
			sb.append("			when keyword < '사' then 'ㅂ' \n");
			sb.append("			when keyword < '아' then 'ㅅ' \n");
			sb.append("			when keyword < '자' then 'ㅇ' \n");
			sb.append("			when keyword < '차' then 'ㅈ' \n");
			sb.append("			when keyword < '카' then 'ㅊ' \n");
			sb.append("			when keyword < '타' then 'ㅋ' \n");
			sb.append("			when keyword < '파' then 'ㅌ' \n");
			sb.append("			when keyword < '하' then 'ㅍ' \n");
			sb.append("			else 'ㅎ' \n");
			sb.append("	end = upper(?) \n");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				KeywordDto keywordDto = new KeywordDto();
				keywordDto.setSeq(rs.getInt("seq"));
				keywordDto.setKeyword(rs.getString("keyword"));
				keywordDto.setHit(rs.getInt("hit"));
				
				list.add(keywordDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<KeywordDto> getCurrentRank() {
		List<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select rownum rank, a.seq, a.keyword, a.hit \n");
			sb.append("from ( \n");
			sb.append("		select seq, keyword, hit \n");
			sb.append("		from naver \n");
			sb.append("		order by hit desc \n");
			sb.append("		) a \n");
			sb.append("where rownum < 11 \n");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				KeywordDto keywordDto = new KeywordDto();
				keywordDto.setSeq(rs.getInt("seq"));
				keywordDto.setKeyword(rs.getString("keyword"));
				keywordDto.setHit(rs.getInt("hit"));
				keywordDto.setRank(rs.getInt("rank"));
				
				list.add(keywordDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	public void updateHit(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("merge into naver \n");
			sb.append("using dual \n");
			sb.append("on (keyword = ?) \n");
			sb.append("when matched then \n");
			sb.append("update set hit = hit + 1 \n");
			sb.append("when not matched then \n");
			sb.append("insert (seq, keyword, hit) \n");
			sb.append("values (naver_seq.nextval, ?, 1) \n");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}	
	}

	
	
}
