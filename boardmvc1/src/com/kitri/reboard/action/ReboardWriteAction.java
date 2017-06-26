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

public class ReboardWriteAction implements Action {

//	1. data get (
//	      request(제목, 내용, 게시판번호), 
//	      session(이름, 아이디, 이메일)
//	      db (글번호)
//	2. logic (service >> dao) insert
//	   1의 data를 이용하여  Dto만들어 service에 전송.
//	3. 2의 결과에 따라 view page 결정.
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
			reboardDto.setRef(seq);//새글일 경우 ref(그룹번호)를 seq와 같게설정.
			
			int cnt = ReboardServiceImpl.getReboardService().writeArticle(reboardDto);
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
