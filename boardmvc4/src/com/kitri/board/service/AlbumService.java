package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.AlbumDto;

public interface AlbumService {
	int writeArticle(AlbumDto albumDto); //회원가입이랑 다를거 없음.
	AlbumDto getArticle(int seq); // 글 하나 얻어오기 
	List<AlbumDto> listArticle(int bcode, int pg, String key, String word); // 리스트
	
	
	int modifyArticle(AlbumDto albumDto); // 수정
	int deleteArticle(int seq); // 지우기
}
