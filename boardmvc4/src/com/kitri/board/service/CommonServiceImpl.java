package com.kitri.board.service;

import java.util.HashMap;
import java.util.Map;

import com.kitri.board.dao.CommonDaoImpl;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageNavigation;

// 1. private 생성자
// 2. static 변수 선언
// 3. static{} 객체 생성
// 4. 자신을 리턴하는 get method 생성
public class CommonServiceImpl implements CommonService {

	private static CommonService commonService; // interface 타입으로 잡기

	private CommonServiceImpl(){};

	static {

		commonService = new CommonServiceImpl();
	}

	@Override
	public int getNextSeq() {

		return CommonDaoImpl.getCommonDao().getNextSeq();
	}

	public static CommonService getCommonService() {
		return commonService;
	}

	@Override
	public PageNavigation makePageNavigation(int bcode, int pg, String key, String word) {
		// 주 목적은 네비게이션 만드는것
		PageNavigation pageNavigation = new PageNavigation();
		
		 // root는 서비스에서 완성할 수 없음
		int newArticleCount = CommonDaoImpl.getCommonDao().newArticleCount(bcode); // db
		pageNavigation.setNewArticleCount(newArticleCount);
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode +"");
		map.put("key", key);
		map.put("word", word); // 전체 글 수 는 나중에 key와 word가 필요하다
		int totalArticleCount = CommonDaoImpl.getCommonDao().totalArticleCount(map); // db
		pageNavigation.setTotalArticleCount(totalArticleCount);
//		int totalPageCount = totalArticleCount%BoardConstance.LIST_SIZE == 0 ? totalArticleCount/BoardConstance.LIST_SIZE : totalArticleCount/BoardConstance.LIST_SIZE + 1; // logic totalArticle, list_size(20)
		int totalPageCount = (totalArticleCount - 1) / BoardConstance.LIST_SIZE + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setNowFirst(pg <= BoardConstance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount-1) / BoardConstance.PAGE_SIZE * BoardConstance.PAGE_SIZE < pg ); // 0으로 나누어 떨어지는 것은 1로 빼주면 됨
		pageNavigation.setPageNo(pg);
//		pageNavigation.setNavigator(); // listaction에서 호출해야함 ( root값이 아직 설정 안되었기때문에 여기서 하면 root값에 null이 들어감
		
		return pageNavigation;
	}
}