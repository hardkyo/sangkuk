package com.kitri.board.service;

import com.kitri.util.PageNavigation;

public interface CommonService {

	int getNextSeq(); // 글번호 얻어내는 메소드
	
	PageNavigation makePageNavigation(int bcode, int pg, String key, String word); // pagenavigation에서 페이징 처리 해주는거 함

}