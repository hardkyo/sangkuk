package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.ReBoardServiceImpl;
import com.kitri.util.NumberCheck;
// service에서 dto 얻어오기
public class ReboardViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. data get (request(subject제목, content내용, bcode게시판번호), session(이름,
		// 아이디, 이메일)
		// (db ( 글번호 ))
		// 2. logic ( service -> dao ) select
		// 1의 data를 이용하여 Dto 만들기 service에 전송
		// 3. 2의 결과에 따라 view page 결정.
		
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		if (seq != 0) { // 글번호가 0이 아닐때만 특정 글을 보여줌 
			ReboardDto reboardDto = ReBoardServiceImpl.getReboardService().getArticle(seq);

			request.setAttribute("article", reboardDto);
		}
		return "reboard/view.jsp";
	}

}
