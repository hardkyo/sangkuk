package com.kitri.board.service;

import java.util.List;

import com.kitri.board.dao.AlbumDaoImpl;
import com.kitri.board.model.AlbumDto;

public class AlbumServiceImpl implements AlbumService {

	private static AlbumService albumService;
	
	static {
		albumService = new AlbumServiceImpl();
	}
	
	private AlbumServiceImpl() {}
	
	public static AlbumService getAlbumService() {
		return albumService;
	}

	@Override
	public int writeArticle(AlbumDto albumDto) {
		
		return AlbumDaoImpl.getAlbumDao().writeArticle(albumDto);
	}

	@Override
	public AlbumDto getArticle(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumDto> listArticle(int bcode, int pg, String key, String word) {
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
