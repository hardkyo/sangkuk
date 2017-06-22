package com.kitri.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReboardDto;

public interface ReboardDao {
	
	int writeArticle(ReboardDto reboardDto);
	ReboardDto getArticle(int seq);
	List<ReboardDto> listArticle(Map<String, String> map); //게시판이 어딘지 알기위해 bcode를 가져옴 -> 하나에 담아서 보내기 위해 Map에 저장
	int replyArticle(ReboardDto reboardDto);
	
	int modifyArticle(ReboardDto reboardDto);
	int deleteArticle(int seq); // seq -> 글번호
}
