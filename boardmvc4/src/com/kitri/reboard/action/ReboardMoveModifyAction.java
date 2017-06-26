package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.ReBoardServiceImpl;
import com.kitri.util.NumberCheck;

public class ReboardMoveModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		if (seq != 0) { // 글번호가 0이 아닐때만 특정 글을 보여줌 
			ReboardDto reboardDto = ReBoardServiceImpl.getReboardService().getArticle(seq);

			request.setAttribute("article", reboardDto);
		}
		return "reboard/modify.jsp";
	}


}
