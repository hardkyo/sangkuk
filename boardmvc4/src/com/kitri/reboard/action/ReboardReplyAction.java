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
		
		HttpSession session = request.getSession(); // session ����
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //������ login.jsp���� �����Ƿ� index
		
		if (memberDto != null) { // �α����� �ߴٸ�
			int seq = CommonServiceImpl.getCommonService().getNextSeq(); // �� ��ȣ ��� db����
			
			ReboardDto reboardDto = new ReboardDto();
			reboardDto.setSeq(seq); // �۹�ȣ ������ ������ �ۼ��� �� Ȯ���� ������ ��, �ۼ��� ���� ������ �� ��ȣ�� �ʿ���
			reboardDto.setId(memberDto.getId()); // session
			reboardDto.setName(memberDto.getName()); // session
			reboardDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2()); // session
			reboardDto.setSubject(request.getParameter("subject")); // parameter
			reboardDto.setContent(request.getParameter("content")); // parameter
			reboardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode"))); // parameter
//			reboardDto.setRef(Integer.parseInt(request.getParameter("ref"))); // ����϶��� ������ ref�� �Ȱ��� �ؾ���
//			reboardDto.setLev(Integer.parseInt(request.getParameter("lev")));
//			reboardDto.setStep(Integer.parseInt(request.getParameter("step"))); 
			reboardDto.setPseq(Integer.parseInt(request.getParameter("pseq"))); // ������ �۹�ȣ�� �� ����������
			// ref, lev, step, pseq nullToZero �Ǵ� one�� ���ϴ� ������ ��״� ���� �߸� �������� ������ ���°� �±⶧���� ����ȯ�� ��
			
			int cnt = ReBoardServiceImpl.getReboardService().replyArticle(reboardDto);
			if (cnt != 0) {
				// bcode, pg, key, word�� queryString���� �ѱ��, �������� request�� session�� �޾Ƽ� �ѱ���
				request.setAttribute("seq", seq +""); // ����ȯ�ϱ� �������ϱ�...
				path = "reboard/writeOk.jsp"; // �ּҴ� �빮�� �ҹ��� ������, �۹�ȣ ���������� ( �ۼ��� �� Ȯ�� ), bcode, pg, key, word
				
			} else
				path = "reboard/writeFail.jsp";
		} 
		return path;
	}

}
