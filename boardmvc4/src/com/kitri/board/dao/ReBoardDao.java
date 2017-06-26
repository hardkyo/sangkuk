package com.kitri.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReboardDto;

public interface ReBoardDao {
	
	int writeArticle(ReboardDto reboardDto);
	ReboardDto getArticle(int seq); // �� �ϳ� ������ 
	List<ReboardDto> listArticle(Map<String, String> map); // ����Ʈ => ���ڰ��� �������ε� Dto�� ���� ���� �� Map���� ����
	int replyArticle(ReboardDto reboardDto); // ���
	
	int modifyArticle(ReboardDto reboardDto); // ����
	int deleteArticle(int seq); // �����
}
