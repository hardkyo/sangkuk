package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.CommonServiceImpl;
import com.kitri.board.service.ReBoardServiceImpl;
import com.kitri.member.model.MemberDto;
import com.kitri.util.NumberCheck;

public class ReboardDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); // session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //원래는 login.jsp지만 없으므로 index
		
		if (memberDto != null) { // 로그인을 했다면
//			int seq = CommonServiceImpl.getCommonService().getNextSeq(); // 글 번호 얻기 db에서
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			int cnt = ReBoardServiceImpl.getReboardService().deleteArticle(seq);
			if (cnt != 0) {
				path = "/index.jsp";
			} else
				path = "/reboard/view.jsp";
		} 
		return path;
	}
}
