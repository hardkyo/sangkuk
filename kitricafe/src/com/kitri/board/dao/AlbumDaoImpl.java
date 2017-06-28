package com.kitri.board.dao;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.kitri.board.model.AlbumDto;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class AlbumDaoImpl implements AlbumDao {
	
	private static AlbumDao albumDao;
	
	static {
		albumDao = new AlbumDaoImpl();
	}

	private AlbumDaoImpl() {}
	
	public static AlbumDao getAlbumDao() {
		return albumDao;
	}

	@Override
	public int writeArticle(AlbumDto albumDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all \n");
			sql.append("	into board (seq, name, id, email, subject, content, hit, logtime, bcode) \n");
			sql.append("	values(?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			sql.append("	into album (aseq, seq, orign_picture, save_picture, savefolder, type) \n");
			sql.append("	values (album_aseq.nextval, ?, ?, ?, ?, 0) \n");
			sql.append("select * from dual \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, albumDto.getSeq());
			pstmt.setString(++idx, albumDto.getName());
			pstmt.setString(++idx, albumDto.getId());
			pstmt.setString(++idx, albumDto.getEmail());
			pstmt.setString(++idx, albumDto.getSubject());
			pstmt.setString(++idx, albumDto.getContent());
			pstmt.setInt(++idx, albumDto.getBcode());
			pstmt.setInt(++idx, albumDto.getSeq());
			pstmt.setString(++idx, albumDto.getOrignPicture());
			pstmt.setString(++idx, albumDto.getSavePicture());
			pstmt.setString(++idx, albumDto.getSaveFolder());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public AlbumDto getArticle(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumDto> listArticle(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyArticle(AlbumDto albumDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArticle(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
