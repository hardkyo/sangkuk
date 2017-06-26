package com.kitri.reboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.CommonServiceImpl;
import com.kitri.board.service.ReBoardServiceImpl;
import com.kitri.util.*;

public class ReboardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������ �ް�
		// �������� �Ͻ�Ű��
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // ��ũ�� �������� ��, 0 = ��� �Խ����� ��� �۸������
		int pg = NumberCheck.nullToOne(request.getParameter("pg")); // �������� 0��° �������� ���⶧���� 1�� �ʱ�ȭ
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word")); // ���� �˻��� �갡 �ϴ°Ŵϱ� �굵 �ѱ�ó��
		// �� ���
		List<ReboardDto> list = ReBoardServiceImpl.getReboardService().listArticle(bcode, pg, key, word);
		request.setAttribute("articleList", list);
		
		// ����¡ó��
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(bcode, pg, key, word);
		// root�� ���⼭ ������
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		return "/reboard/list.jsp";
	}

}