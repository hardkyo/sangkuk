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
//	      request(����, ����, �Խ��ǹ�ȣ), 
//	      session(�̸�, ���̵�, �̸���)
//	      db (�۹�ȣ)
//	2. logic (service >> dao) insert
//	   1�� data�� �̿��Ͽ�  Dto����� service�� ����.
//	3. 2�� ����� ���� view page ����.
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();//session ����
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session���� MemberDto get
		
		String path = "/index.jsp";
		if(memberDto != null) {//�α��� �ߴٸ�.
			int seq = CommonServiceImpl.getCommonService().getNextSeq();//�۹�ȣ ���
			
			ReboardDto reboardDto = new ReboardDto();
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2());
			reboardDto.setSubject(request.getParameter("subject"));
			reboardDto.setContent(request.getParameter("content"));
			reboardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode")));
			reboardDto.setRef(seq);//������ ��� ref(�׷��ȣ)�� seq�� ���Լ���.
			
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
