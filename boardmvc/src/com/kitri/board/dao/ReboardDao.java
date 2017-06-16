package com.kitri.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReboardDto;

public interface ReboardDao {
	
	int writeArticle(ReboardDto reboardDto);
	ReboardDto getArticle(int seq);
	List<ReboardDto> listArticle(Map<String, String> map); //�Խ����� ����� �˱����� bcode�� ������ -> �ϳ��� ��Ƽ� ������ ���� Map�� ����
	int replyArticle(ReboardDto reboardDto);
	
	int modifyArticle(ReboardDto reboardDto);
	int deleteArticle(int seq); // seq -> �۹�ȣ
}
