package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.ReboardDto;

public interface ReboardService {

	int writeArticle(ReboardDto reboardDto);
	ReboardDto getArticle(int seq);
	List<ReboardDto> listArticle(int bcode, int pg, String key, String word);
	int replyArticle(ReboardDto reboardDto);
	
	int modifyArticle(ReboardDto reboardDto);
	int deleteArticle(int seq);
	
}
