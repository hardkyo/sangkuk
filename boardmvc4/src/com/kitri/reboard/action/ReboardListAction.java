package com.kitri.reboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.CommonServiceImpl;
import com.kitri.board.service.ReBoardServiceImpl;
import com.kitri.util.*;

public class ReboardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터 받고
		// 서비스한테 일시키고
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // 링크가 지워졌을 때, 0 = 모든 게시판의 모든 글목록으로
		int pg = NumberCheck.nullToOne(request.getParameter("pg")); // 페이지는 0번째 페이지가 없기때문에 1로 초기화
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word")); // 실제 검색은 얘가 하는거니까 얘도 한글처리
		// 글 목록
		List<ReboardDto> list = ReBoardServiceImpl.getReboardService().listArticle(bcode, pg, key, word);
		request.setAttribute("articleList", list);
		
		// 페이징처리
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(bcode, pg, key, word);
		// root는 여기서 가져옴
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		return "/reboard/list.jsp";
	}

}