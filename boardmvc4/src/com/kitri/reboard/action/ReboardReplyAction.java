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

public class ReboardReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(); // session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //원래는 login.jsp지만 없으므로 index
		
		if (memberDto != null) { // 로그인을 했다면
			int seq = CommonServiceImpl.getCommonService().getNextSeq(); // 글 번호 얻기 db에서
			
			ReboardDto reboardDto = new ReboardDto();
			reboardDto.setSeq(seq); // 글번호 얻어오는 이유는 작성한 글 확인을 눌렀을 때, 작성한 글을 보려면 글 번호가 필요함
			reboardDto.setId(memberDto.getId()); // session
			reboardDto.setName(memberDto.getName()); // session
			reboardDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2()); // session
			reboardDto.setSubject(request.getParameter("subject")); // parameter
			reboardDto.setContent(request.getParameter("content")); // parameter
			reboardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode"))); // parameter
//			reboardDto.setRef(Integer.parseInt(request.getParameter("ref"))); // 답글일때는 원글의 ref와 똑같이 해야함
//			reboardDto.setLev(Integer.parseInt(request.getParameter("lev")));
//			reboardDto.setStep(Integer.parseInt(request.getParameter("step"))); 
			reboardDto.setPseq(Integer.parseInt(request.getParameter("pseq"))); // 원글의 글번호는 꼭 가져가야함
			// ref, lev, step, pseq nullToZero 또는 one을 안하는 이유는 얘네는 값을 잘못 가져오면 에러가 나는게 맞기때문에 형변환만 함
			
			int cnt = ReBoardServiceImpl.getReboardService().replyArticle(reboardDto);
			if (cnt != 0) {
				// bcode, pg, key, word는 queryString으로 넘기고, 나머지는 request나 session에 받아서 넘기자
				request.setAttribute("seq", seq +""); // 형변환하기 귀찮으니까...
				path = "reboard/writeOk.jsp"; // 주소는 대문자 소문자 구분함, 글번호 가져가야함 ( 작성한 글 확인 ), bcode, pg, key, word
				
			} else
				path = "reboard/writeFail.jsp";
		} 
		return path;
	}

}
