package com.kitri.board.service;

import java.util.HashMap;
import java.util.Map;

import com.kitri.board.dao.CommonDaoImpl;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageNavigation;

//singleton pattern 적용
//1. private 생성자
//2. static 변수 선언.
//3. static{} 객체 생성.
//4. 자신을 리턴하는 get method생성
public class CommonServiceImpl implements CommonService {

	private static CommonService CommonService;
	
	static {
		CommonService = new CommonServiceImpl();
	}
	
	private CommonServiceImpl() {}
	
	public static CommonService getCommonService() {
		return CommonService;
	}

	@Override
	public int getNextSeq() {
		return CommonDaoImpl.getCommonDao().getNextSeq();
	}

	@Override
	public PageNavigation makePageNavigation(int bcode, int pg, String key, String word) {
		PageNavigation pageNavigation = new PageNavigation();
		
		int newArticleCount = CommonDaoImpl.getCommonDao().newArticleCount(bcode);
		pageNavigation.setNewArticleCount(newArticleCount);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode + ""); // 문자열로 만들어 주기 위해 --> + ""; 를 넣어줌
		map.put("key", key);
		map.put("word", word);	
		int totalArticleCount=CommonDaoImpl.getCommonDao().totalArticleCount(map);
		pageNavigation.setTotalArticleCount(totalArticleCount);
		
//		int totalPageCount = totalArticleCount % BoardConstance.LIST_SIZE == 0 
//		? totalArticleCount / BoardConstance.LIST_SIZE : totalArticleCount / BoardConstance.LIST_SIZE + 1;
		int totalPageCount = (totalArticleCount - 1) / BoardConstance.LIST_SIZE +1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setNowFirst(pg <= BoardConstance.PAGE_SIZE);
		pageNavigation.setNowEnd(totalPageCount / BoardConstance.PAGE_SIZE * BoardConstance.PAGE_SIZE < pg);
		pageNavigation.setPageNo(pg);
		pageNavigation.setNavigator();
		
		return pageNavigation;
	}

}
