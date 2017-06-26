package com.kitri.board.service;

import java.util.*;

import com.kitri.board.dao.CommonDaoImpl;
import com.kitri.board.dao.ReBoardDaoImpl;
import com.kitri.board.model.ReboardDto;
import com.kitri.util.BoardConstance;

public class ReBoardServiceImpl implements ReBoardService {
	// 변수가 제일 먼저, 그다음 static 블록이 있으면 static 블록, 그리고 생성자, 메소드 순서
	// business logic layer
	private static ReBoardService reboardService;

	static {
		reboardService = new ReBoardServiceImpl();
	}

	private ReBoardServiceImpl() {
	};

	public static ReBoardService getReboardService() {
		return reboardService;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		return ReBoardDaoImpl.getReboardDao().writeArticle(reboardDto);
	}

	@Override
	public ReboardDto getArticle(int seq) {
		CommonDaoImpl.getCommonDao().updateHit(seq);
		return ReBoardDaoImpl.getReboardDao().getArticle(seq);
	}

	@Override
	public List<ReboardDto> listArticle(int bcode, int pg, String key, String word) {
		int end = pg * BoardConstance.LIST_SIZE;
		int start = end - BoardConstance.LIST_SIZE; 
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode + "");
		map.put("key", key);
		map.put("word", word);
		map.put("start", start +""); // 페이지 첫번호와 마지막번호를 계산하기 위해서 start와 end 만듦
		map.put("end", end +"");
		return ReBoardDaoImpl.getReboardDao().listArticle(map);
	}
	
	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return ReBoardDaoImpl.getReboardDao().replyArticle(reboardDto);
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return ReBoardDaoImpl.getReboardDao().modifyArticle(reboardDto);
	}

	@Override
	public int deleteArticle(int seq) {
		return ReBoardDaoImpl.getReboardDao().deleteArticle(seq);
	}

}