package com.kitri.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.AlbumDto;

public interface AlbumDao {

	int writeArticle(AlbumDto albumDto);
	AlbumDto getArticle(int seq);
	List<AlbumDto> listArticle(Map<String, String> map);
	
	int modifyArticle(AlbumDto albumDto);
	int deleteArticle(int seq);
	
}
