package com.kitri.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReboardDto;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class ReboardDaoImpl implements ReboardDao {

	private static ReboardDao reboardDao;
	
	static {
		reboardDao = new ReboardDaoImpl();
	}
	
	private ReboardDaoImpl() {}
	
	public static ReboardDao getReboardDao() {
		return reboardDao;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
//			System.out.println(reboardDto.getBcode());
			StringBuffer sql = new StringBuffer();
			sql.append("insert all \n");
			sql.append("	into board (seq, name, id, email, subject, content, hit, logtime, bcode) \n");
			sql.append("	values(?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			sql.append("	into reboard (rseq, seq, ref, lev, step, pseq, reply) \n");
			sql.append("	values (reboard_rseq.nextval, ?, ?, 0, 0, 0, 0) \n");
			sql.append("select * from dual \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setString(++idx, reboardDto.getName());
			pstmt.setString(++idx, reboardDto.getId());
			pstmt.setString(++idx, reboardDto.getEmail());
			pstmt.setString(++idx, reboardDto.getSubject());
			pstmt.setString(++idx, reboardDto.getContent());
			pstmt.setInt(++idx, reboardDto.getBcode());
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setInt(++idx, reboardDto.getRef());
			cnt = pstmt.executeUpdate();
//			System.err.println(reboardDto.getContent()+ "ffffffffffffffff");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public ReboardDto getArticle(int seq) {
		ReboardDto reboardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select 	b.seq, b.id, b.name, b.email, b.subject, \n");
			sql.append("b.content, b.hit, b.logtime, b.bcode, \n");
			sql.append("r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply \n");
			sql.append("from board b, reboard r \n");
			sql.append("where b.seq = r.seq \n");
			sql.append("and b.seq = ?"); //seq -> 글번호
			pstmt = conn.prepareStatement(sql.toString());
//			System.out.println(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
//			rs.next();
			if (rs.next()) {	
				reboardDto = new ReboardDto();
				reboardDto.setSeq(rs.getInt("seq"));
				reboardDto.setId(rs.getString("id"));
				reboardDto.setName(rs.getString("name"));
				reboardDto.setEmail(rs.getString("email"));
				reboardDto.setSubject(rs.getString("subject"));
				reboardDto.setContent(rs.getString("content"));
				reboardDto.setHit(rs.getInt("hit"));
				reboardDto.setLogtime(rs.getString("logtime"));
				reboardDto.setBcode(rs.getInt("bcode"));
				reboardDto.setRseq(rs.getInt("rseq"));
				reboardDto.setRef(rs.getInt("ref"));
				reboardDto.setLev(rs.getInt("lev"));
				reboardDto.setStep(rs.getInt("step"));
				reboardDto.setPseq(rs.getInt("pseq"));
				reboardDto.setReply(rs.getInt("reply"));
//				System.out.println(reboardDto.getContent());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return reboardDto;
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> map) {
		List<ReboardDto> list = new ArrayList<ReboardDto>(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.*\n");
			sql.append("from(\n");
			sql.append("  select rownum rn, a.*\n");
			sql.append("  from(\n");
			sql.append("      select  b.seq, b.id, b.name, b.email, b.subject, \n");
			sql.append("              b.content, b.hit, b.bcode, \n");
			sql.append("              decode(to_char(logtime, 'yymmdd'),\n");
			sql.append("                      to_char(sysdate, 'yymmdd'),to_char(logtime, 'hh24:mi:ss'),\n");
			sql.append("                      to_char(logtime, 'yy.mm.dd')) logtime,    \n");
			sql.append("              r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply \n");
			sql.append("      from board b, reboard r \n");
			sql.append("      where b.seq = r.seq \n");
			sql.append("      and b.bcode = ?\n");
			
			
			String key = map.get("key");
			String word = map.get("word");
			if (!key.isEmpty() && !word.isEmpty()) {
				// 제목 > like
				// 글쓴이 , 글번호 > =
				if (key.equals("subject")) {					
					sql.append("      and subject like '%' ||?||'%'  \n");
				}else
					sql.append("      and b." + key + " = ? \n");
			}
			sql.append("      ORDER BY seq desc\n");
			sql.append("      )a\n");
			sql.append("    where rownum <= ?\n");
			sql.append("    )b\n");
			sql.append("where b.rn > ?\n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx =0;
			pstmt.setString(++idx, map.get("bcode"));
			if (!key.isEmpty() && !word.isEmpty())
				pstmt.setString(++idx, word);
			pstmt.setString(++idx, map.get("end"));
			pstmt.setString(++idx, map.get("start"));
			rs = pstmt.executeQuery();
			while(rs.next()){
				ReboardDto reboardDto = new ReboardDto();
				reboardDto.setSeq(rs.getInt("seq"));
				reboardDto.setId(rs.getString("id"));
				reboardDto.setName(rs.getString("name"));
				reboardDto.setEmail(rs.getString("email"));
				reboardDto.setSubject(rs.getString("subject"));
				reboardDto.setContent(rs.getString("content"));
				reboardDto.setHit(rs.getInt("hit"));
				reboardDto.setLogtime(rs.getString("logtime"));
				reboardDto.setBcode(rs.getInt("bcode"));
				reboardDto.setRseq(rs.getInt("rseq"));
				reboardDto.setRef(rs.getInt("ref"));
				reboardDto.setLev(rs.getInt("lev"));
				reboardDto.setStep(rs.getInt("step"));
				reboardDto.setPseq(rs.getInt("pseq"));
				reboardDto.setReply(rs.getInt("reply"));
				
				list.add(reboardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public int deleteArticle(int seq) {
		return 0;
	}


	
	
}










