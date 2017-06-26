package com.kitri.board.dao;

import java.sql.*;
import java.util.*;

import com.kitri.board.model.ReboardDto;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class ReBoardDaoImpl implements ReBoardDao {

	private static ReBoardDao reboardDao;

	static {
		reboardDao = new ReBoardDaoImpl();
	}

	private ReBoardDaoImpl() {
	};

	public static ReBoardDao getReboardDao() {
		return reboardDao;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all \n");
			sql.append("	into board (seq, name, id, email, subject, content, hit, logtime, bcode) \n");
			sql.append("	values(?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			sql.append("	into reboard (rseq, seq, ref, lev, step, pseq, reply) \n");
			sql.append("	values(reboard_rseq.nextval, ?, ?, 0, 0, 0, 0) \n");
			sql.append("select * from dual");
//			System.out.println(reboardDto.getBcode());
			// 10 �ȳ��ϼ���. 0 0 ( level, step )
			// 11 Re : ���ο�. 1 10 ( level, step )
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
			sql.append("select b.seq, b.id, b.name, b.email, b.subject, \n");
			sql.append("			 b.content, b.hit, b.logtime, b.bcode, \n");
			sql.append("			 r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply \n");
			sql.append("			 from board b, reboard r \n");
			sql.append("			 where b.seq = r.seq \n");
			sql.append("			 and b.seq = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // �� �ϳ��� �����ų� �������ų�
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
			};
		
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
	         sql.append("select b.* \n");
	         sql.append("from ( \n");
	         sql.append("   select rownum rn, a.* \n");
	         sql.append("   from ( \n");
	         sql.append("      select b.seq,b.name,b.id,b.email,b.subject, \n");
	         sql.append("            b.content,b.hit, \n");
	         sql.append("            decode(to_char(sysdate,'yymmdd'),to_char(logtime,'yymmdd'),  \n");
	         sql.append("               to_char(logtime,'hh24:mi:ss'),to_char(logtime,'yy.mm.dd')) logtime \n");
	         sql.append("               ,b.bcode,r.rseq,r.ref,r.lev,r.step,r.pseq,r.reply \n");
	         sql.append("      from board b , reboard r \n");
	         sql.append("      where b.seq=r.seq \n");
	         sql.append("      and b.bcode=? \n");
	         // ������, �۾���, �۹�ȣ
	         String key = map.get("key");
	         String word = map.get("word");
//	         System.out.println("word >>>>>>" + word);
	         if (!key.isEmpty() && !word.isEmpty()) {
	        	 if (key.equals("subject")) {
	        		 sql.append("	   and subject like '%' ||?|| '%'\n");
	        	 } else {
	        		 sql.append("	   and b." + key + "=? \n");
	        		 // b. �ϴ� ������ seq�� ������ �� seq�� board���� �ְ�, reboard���� �ֱ� ������ ���̺���� Ȯ���ϰ� ���������
	        	 }
	         }
	         sql.append("      order by r.ref desc, r.step \n");
	         sql.append("         ) a \n");
	         sql.append("      where rownum <=? \n");
	         sql.append("      ) b \n");
	         sql.append("   where b.rn>?");
	        int idx = 0;
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(++idx, map.get("bcode"));
	         if (!key.isEmpty() && !word.isEmpty())
	        	 pstmt.setString(++idx, word);
			pstmt.setString(++idx, map.get("end"));
			pstmt.setString(++idx,map.get("start"));
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
				
//				System.out.println(reboardDto.getHit());
				list.add(reboardDto);
			};
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}


	@Override
	public int replyArticle(ReboardDto reboardDto) {
		int cnt = 0;
		ReboardDto parentDto = this.getArticle(reboardDto.getPseq()); // ������ ��������
		if (parentDto != null) { // ������ �ִ��� ������ Ȯ�� 
			Connection conn = null;
			PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false); // �ڵ�Ŀ�� �ȵǰ� �� 
			
			StringBuffer update_step = new StringBuffer(); // step���� �ٲٱ� 
			update_step.append("update reboard \n");
			update_step.append("set step = step + 1 \n");
			update_step.append("where ref = ? and step > ? \n"); // step�� ���ϱ����� ref�� ���� ���غ��°� ����. �� ���� �����͸� ���� �Ŀ� step �� ����
			pstmt = conn.prepareStatement(update_step.toString());
			pstmt.setInt(1, parentDto.getRef()); // ������ ref
			pstmt.setInt(2, parentDto.getStep()); // ������ step
			pstmt.executeUpdate();
			pstmt.close();
			
			StringBuffer insert_reply = new StringBuffer(); // insert ���
			insert_reply.append("insert all \n");
			insert_reply.append("	into board (seq, name, id, email, subject, content, hit, logtime, bcode) \n");
			insert_reply.append("	values(?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			insert_reply.append("	into reboard (rseq, seq, ref, lev, step, pseq, reply) \n");
			insert_reply.append("	values(reboard_rseq.nextval, ?, ?, ?, ?, ?, 0) \n");
			insert_reply.append("select * from dual");
			pstmt = conn.prepareStatement(insert_reply.toString());
			int idx = 0;
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setString(++idx, reboardDto.getName());
			pstmt.setString(++idx, reboardDto.getId());
			pstmt.setString(++idx, reboardDto.getEmail());
			pstmt.setString(++idx, reboardDto.getSubject());
			pstmt.setString(++idx, reboardDto.getContent());
			pstmt.setInt(++idx, reboardDto.getBcode());
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setInt(++idx, parentDto.getRef()); // ������ ����
			pstmt.setInt(++idx, parentDto.getLev()+1);
			pstmt.setInt(++idx, parentDto.getStep()+1);
			pstmt.setInt(++idx, reboardDto.getPseq());
			pstmt.executeUpdate();
			pstmt.close();
			
			StringBuffer update_reply = new StringBuffer(); // ��� ���� ����
			update_reply.append("update reboard \n");
			update_reply.append("set reply = reply + 1 \n");
			update_reply.append("where seq = ? \n");
			pstmt = conn.prepareStatement(update_reply.toString());
			pstmt.setInt(1, parentDto.getSeq()); // reboardDto.getPseq() = parentDto.getSeq()
			pstmt.executeUpdate();
			
			conn.commit(); // Ŀ���ϱ�
			cnt = 1; // ���� �ϼ��Ǽ� Ŀ�Ե� �Ŀ� cnt�� 0�� �ƴϰ� �Ѱ��ֱ� 
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				conn.rollback(); // ������ ������ �ϳ��� ������ �ȵǸ� rollback���� ����
				cnt = 0; // ���߿� �ϳ��� ������ ó���� �ȵǸ� cnt�� 0���� �ʱ�ȭ ����� OK ȭ������ ��������
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			} 
		} finally {
			DBClose.close(conn, pstmt);
		}
		}
		return cnt;
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("update board set subject =?, content =? \n");
			sql.append("where seq = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, reboardDto.getSubject());
			pstmt.setString(2, reboardDto.getContent());
			pstmt.setInt(3, reboardDto.getSeq());
			cnt = pstmt.executeUpdate();
			System.out.println(reboardDto.getSeq());
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}

	@Override
	public int deleteArticle(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		System.out.println(">>>>>>>>>>>>>>>>>>>"+seq);
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			StringBuffer reboard_sql = new StringBuffer();
			reboard_sql.append("delete reboard where seq = ? and reply = 0");
			pstmt = conn.prepareStatement(reboard_sql.toString());
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			pstmt.close();
			
			StringBuffer board_sql = new StringBuffer();
			board_sql.append("delete board where seq = ?");
			pstmt = conn.prepareStatement(board_sql.toString());
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();

			
			conn.commit();
			cnt = 1;
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}


}