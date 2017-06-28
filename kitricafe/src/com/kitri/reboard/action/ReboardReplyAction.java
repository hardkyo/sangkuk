package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.CommonServiceImpl;
import com.kitri.board.service.ReboardServiceImpl;
import com.kitri.member.model.MemberDto;
import com.kitri.util.NumberCheck;

public class ReboardReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();//session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session에서 MemberDto get
		
		String path = "/index.jsp";
		if(memberDto != null) {//로그인 했다면.
			int seq = CommonServiceImpl.getCommonService().getNextSeq();//글번호 얻기
			
			ReboardDto reboardDto = new ReboardDto();
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2());
			reboardDto.setSubject(request.getParameter("subject"));
			reboardDto.setContent(request.getParameter("content"));
			reboardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode")));
//			reboardDto.setRef(Integer.parseInt(request.getParameter("ref")));//답글일 경우 원글의 ref 같게설정.
//			reboardDto.setLev(Integer.parseInt(request.getParameter("lev")));
//			reboardDto.setStep(Integer.parseInt(request.getParameter("step")));
			reboardDto.setPseq(Integer.parseInt(request.getParameter("pseq")));
						
			int cnt = ReboardServiceImpl.getReboardService().replyArticle(reboardDto);
			if(cnt != 0) {
				request.setAttribute("seq", seq + "");
				path = "/reboard/writeOk.jsp";
			} else {
				path = "/reboard/writeFail.jsp";
			}
		}
		
		return path;
	}

}
