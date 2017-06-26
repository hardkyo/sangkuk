package com.kitri.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.AlbumDto;

public interface AlbumDao {
	int writeArticle(AlbumDto albumDto); //ȸ�������̶� �ٸ��� ����.
	AlbumDto getArticle(int seq); // �� �ϳ� ������ 
	List<AlbumDto> listArticle(Map<String, String> map); // ����Ʈ
	
	
	int modifyArticle(AlbumDto albumDto); // ����
	int deleteArticle(int seq); // �����
}
