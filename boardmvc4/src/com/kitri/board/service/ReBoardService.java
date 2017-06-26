package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.ReboardDto;

public interface ReBoardService {

	int writeArticle(ReboardDto reboardDto); //ȸ�������̶� �ٸ��� ����.
	ReboardDto getArticle(int seq); // �� �ϳ� ������ 
	List<ReboardDto> listArticle(int bcode, int pg, String key, String word); // ����Ʈ
	int replyArticle(ReboardDto reboardDto); // ���
	
	int modifyArticle(ReboardDto reboardDto); // ����
	int deleteArticle(int seq); // �����
	
/*
10 aaaa 	10 0 0 0 0 >> �׷��ȣ / ���� / ���� / ���۹�ȣ / �亯����  
11   bbbb	10 1 1 10 0
 */
}