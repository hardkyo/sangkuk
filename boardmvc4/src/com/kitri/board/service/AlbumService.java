package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.AlbumDto;

public interface AlbumService {
	int writeArticle(AlbumDto albumDto); //ȸ�������̶� �ٸ��� ����.
	AlbumDto getArticle(int seq); // �� �ϳ� ������ 
	List<AlbumDto> listArticle(int bcode, int pg, String key, String word); // ����Ʈ
	
	
	int modifyArticle(AlbumDto albumDto); // ����
	int deleteArticle(int seq); // �����
}
