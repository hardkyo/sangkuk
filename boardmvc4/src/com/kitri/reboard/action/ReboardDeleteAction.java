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
		HttpSession session = request.getSession(); // session ����
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //������ login.jsp���� �����Ƿ� index
		
		if (memberDto != null) { // �α����� �ߴٸ�
//			int seq = CommonServiceImpl.getCommonService().getNextSeq(); // �� ��ȣ ��� db����
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
