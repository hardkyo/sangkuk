package com.kitri.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.BoardActionFactory;
import com.kitri.util.*;

@WebServlet("/reboard")
public class ReboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		// ��ȣ��� ���� -- > ������ ������, �Ķ��� �������� ����
		// bcode�� 0�ΰ�� >> ��� �Խ����� ���۸������
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		// ��� �Խ����� jsp����
		// bcode(�Խ��ǹ�ȣ), pg(��������ȣ), key(�˻�����), word(�˻���)
		// �� �ݵ�� ������ �Ѵ�.
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoding.urlFormat(word);
		System.out.println("	RC >>" + queryString);

		String path = "/index.jsp";
		if ("mvwrite".equals(act)) {
			path = "/reboard/write.jsp" + queryString;
			PageMove.redirect(path, request, response);
		} else if ("write".equals(act)) {
			path = BoardActionFactory.getReboardWriteAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("view".equals(act)) {
			//
			path = BoardActionFactory.getReboardViewAction().execute(request, response);
//			System.out.println(request.getAttribute("article"));
			PageMove.forward(path, request, response);
		} else if ("list".equals(act)) {
			path = BoardActionFactory.getReboardListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("mvreply".equals(act)) {
			path = BoardActionFactory.getReboardMoveReplyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("reply".equals(act)) {
			path = BoardActionFactory.getReboardReplyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("".equals(act)) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.DEFAULT_CHAR_SET);
		doGet(request, response);
	}

}
