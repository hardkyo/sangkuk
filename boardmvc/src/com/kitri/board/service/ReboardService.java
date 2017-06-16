package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.ReboardDto;

public interface ReboardService {
		
	int writeArticle(ReboardDto reboardDto);
	ReboardDto getArticle(int seq);
	List<ReboardDto> listArticle(int bcode, int pg, String key, String word); //�Խ����� ����� �˱����� bcode�� ������
	int replyArticle(ReboardDto reboardDto);
	
	int modifyArticle(ReboardDto reboardDto);
	int deleteArticle(int seq); // seq -> �۹�ȣ
	
	
 }

//10 aaaaaa   10 0 0 0 1
//11 	bbbbbbb 10 1 1 10 0