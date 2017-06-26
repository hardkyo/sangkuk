package com.kitri.reboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.CommonServiceImpl;
import com.kitri.board.service.ReboardServiceImpl;
import com.kitri.util.*;

public class ReboardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		
		//臂格废
		List<ReboardDto> list = ReboardServiceImpl.getReboardService().listArticle(bcode, pg, key, word);
		request.setAttribute("articleList", list);
		
		//其捞隆贸府
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(bcode, pg, key, word);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return "/reboard/list.jsp";
	}

}








