package com.kitri.board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.BoardActionFactory;
import com.kitri.reboard.action.ReboardViewAction;
import com.kitri.util.*;


@WebServlet("/reboard")
public class ReboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // ��ũ�� �������� ��, 0 = ��� �Խ����� ��� �۸������
		int pg = NumberCheck.nullToOne(request.getParameter("pg")); // �������� 0��° �������� ���⶧���� 1�� �ʱ�ȭ
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		if (request.getMethod().equals("GET")) {
			word = Encoding.isoToEuc(word);
		} // post�϶��� encoding�������� get����϶��� �ϱ� 
		
		// ���� ���������� ó���ؾ��ϱ� ������ action�� �ƴ϶� controller���� ó����
		// ��� jsp���� bcode, pg, key, word�� �ݵ�� ������ �Ѵ�.
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoding.urlFormat(word); // ���������� �ȵǰ�, &������ �ȵ�
		// ������Ʈ���� word�� euc-kr�� ���� �ٷ� ������ �ȵ�
		// queryString���� �ִ°� ���� �ٸ��� �޾ƿ;��Ҷ��� request�� ���
		System.out.println("RC >>>> "+ queryString); // ���� ���� �� �߿��� �κ�
		String path = "/index.jsp";
		
		if("mvwrite".equals(act)) {
			path ="/reboard/write.jsp" + queryString;
			PageMove.redirect(path, request, response);
		} else if("write".equals(act)) {
			path = BoardActionFactory.getReboardWriteAction().execute(request, response); // factory�� action��ü �������
			
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("view".equals(act)) {
			path = BoardActionFactory.getReboardViewAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("list".equals(act)) {
			path = BoardActionFactory.getReboardListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("mvreply".equals(act)) {
			path = BoardActionFactory.getReboardMoveReplyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("reply".equals(act)) {
			path = BoardActionFactory.getReboardReplyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("mvmodify".equals(act)) {
			path = BoardActionFactory.getReboardMoveModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("modify".equals(act)) {
			path = BoardActionFactory.getReboardModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("delete".equals(act)) {
			path = BoardActionFactory.getReboardDeleteAction().execute(request, response);
			PageMove.redirect(path, request, response);
		} else {
			path = "/index.jsp";
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.DEFAULT_CHAR_SET);
		doGet(request,response);
	}
}
