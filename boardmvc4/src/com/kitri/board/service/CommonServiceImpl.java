package com.kitri.board.service;

import java.util.HashMap;
import java.util.Map;

import com.kitri.board.dao.CommonDaoImpl;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageNavigation;

// 1. private ������
// 2. static ���� ����
// 3. static{} ��ü ����
// 4. �ڽ��� �����ϴ� get method ����
public class CommonServiceImpl implements CommonService {

	private static CommonService commonService; // interface Ÿ������ ���

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
		// �� ������ �׺���̼� ����°�
		PageNavigation pageNavigation = new PageNavigation();
		
		 // root�� ���񽺿��� �ϼ��� �� ����
		int newArticleCount = CommonDaoImpl.getCommonDao().newArticleCount(bcode); // db
		pageNavigation.setNewArticleCount(newArticleCount);
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode +"");
		map.put("key", key);
		map.put("word", word); // ��ü �� �� �� ���߿� key�� word�� �ʿ��ϴ�
		int totalArticleCount = CommonDaoImpl.getCommonDao().totalArticleCount(map); // db
		pageNavigation.setTotalArticleCount(totalArticleCount);
//		int totalPageCount = totalArticleCount%BoardConstance.LIST_SIZE == 0 ? totalArticleCount/BoardConstance.LIST_SIZE : totalArticleCount/BoardConstance.LIST_SIZE + 1; // logic totalArticle, list_size(20)
		int totalPageCount = (totalArticleCount - 1) / BoardConstance.LIST_SIZE + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setNowFirst(pg <= BoardConstance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount-1) / BoardConstance.PAGE_SIZE * BoardConstance.PAGE_SIZE < pg ); // 0���� ������ �������� ���� 1�� ���ָ� ��
		pageNavigation.setPageNo(pg);
//		pageNavigation.setNavigator(); // listaction���� ȣ���ؾ��� ( root���� ���� ���� �ȵǾ��⶧���� ���⼭ �ϸ� root���� null�� ��
		
		return pageNavigation;
	}
}