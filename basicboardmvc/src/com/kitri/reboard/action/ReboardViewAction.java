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
	// 		request(�۹�ȣ)
	// service ���� DTo ����
	// 2. logic (service >> dao) select
	// 1�� data�� �̿��Ͽ� �۹�ȣ�� ���� -> service�� ����.
	// 3. 2�� ����� ���� view page ����.

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
