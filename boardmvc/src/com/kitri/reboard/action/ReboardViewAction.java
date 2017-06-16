package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.ReboardServiceImpl;
import com.kitri.util.NumberCheck;

public class ReboardViewAction implements Action {

	// 1. data get (
	// 		request(글번호)
	// service 에서 DTo 얻어옴
	// 2. logic (service >> dao) select
	// 1의 data를 이용하여 글번호를 보냄 -> service에 전송.
	// 3. 2의 결과에 따라 view page 결정.

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

		return "/reboard/view.jsp";
	}

}
