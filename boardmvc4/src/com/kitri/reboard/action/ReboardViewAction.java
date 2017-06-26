package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.ReBoardServiceImpl;
import com.kitri.util.NumberCheck;
// service���� dto ������
public class ReboardViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. data get (request(subject����, content����, bcode�Խ��ǹ�ȣ), session(�̸�,
		// ���̵�, �̸���)
		// (db ( �۹�ȣ ))
		// 2. logic ( service -> dao ) select
		// 1�� data�� �̿��Ͽ� Dto ����� service�� ����
		// 3. 2�� ����� ���� view page ����.
		
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		if (seq != 0) { // �۹�ȣ�� 0�� �ƴҶ��� Ư�� ���� ������ 
			ReboardDto reboardDto = ReBoardServiceImpl.getReboardService().getArticle(seq);

			request.setAttribute("article", reboardDto);
		}
		return "reboard/view.jsp";
	}

}
