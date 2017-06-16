package com.kitri.board.service;

import java.util.HashMap;
import java.util.Map;

import com.kitri.board.dao.CommonDaoImpl;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageNavigation;

//singleton pattern ����
//1. private ������
//2. static ���� ����.
//3. static{} ��ü ����.
//4. �ڽ��� �����ϴ� get method����
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
		map.put("bcode", bcode + ""); // ���ڿ��� ����� �ֱ� ���� --> + ""; �� �־���
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
