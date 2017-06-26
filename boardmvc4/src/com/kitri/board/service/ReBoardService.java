package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.ReboardDto;

public interface ReBoardService {

	int writeArticle(ReboardDto reboardDto); //회원가입이랑 다를거 없음.
	ReboardDto getArticle(int seq); // 글 하나 얻어오기 
	List<ReboardDto> listArticle(int bcode, int pg, String key, String word); // 리스트
	int replyArticle(ReboardDto reboardDto); // 답글
	
	int modifyArticle(ReboardDto reboardDto); // 수정
	int deleteArticle(int seq); // 지우기
	
/*
10 aaaa 	10 0 0 0 0 >> 그룹번호 / 레벨 / 스텝 / 원글번호 / 답변갯수  
11   bbbb	10 1 1 10 0
 */
}