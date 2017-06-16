package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.ReboardServiceImpl;
import com.kitri.util.NumberCheck;

public class ReboardMoveReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		if (seq != 0) {
			ReboardDto reboardDto = ReboardServiceImpl.getReboardService().getArticle(seq); 
			request.setAttribute("article", reboardDto);
//			System.out.println((ReboardDto)request.getAttribute("article").);
//			System.out.println(reboardDto.getContent());
		}

		return "/reboard/reply.jsp";
		
	}

}
