package com.kitri.board.service;

import java.util.*;

import com.kitri.board.dao.CommonDaoImpl;
import com.kitri.board.dao.ReboardDaoImpl;
import com.kitri.board.model.ReboardDto;
import com.kitri.util.BoardConstance;

public class ReboardServiceImpl implements ReboardService {

	private static ReboardService reboardService;
	
	static {
		reboardService = new ReboardServiceImpl();
	}
	
	private ReboardServiceImpl() {}
	
	public static ReboardService getReboardService() {
		return reboardService;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		return ReboardDaoImpl.getReboardDao().writeArticle(reboardDto);
	}

	@Override
	public ReboardDto getArticle(int seq) {
		CommonDaoImpl.getCommonDao().updateHit(seq);
		return ReboardDaoImpl.getReboardDao().getArticle(seq);
	}

	@Override
	public List<ReboardDto> listArticle(int bcode, int pg, String key, String word) {
		int end = pg * BoardConstance.LIST_SIZE;
		int start = end - BoardConstance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode + "");
		map.put("key", key);
		map.put("word", word);
		map.put("start", start + "");
		map.put("end", end + "");
		return ReboardDaoImpl.getReboardDao().listArticle(map);
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return ReboardDaoImpl.getReboardDao().replyArticle(reboardDto);
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public int deleteArticle(int seq) {
		return 0;
	}

}
