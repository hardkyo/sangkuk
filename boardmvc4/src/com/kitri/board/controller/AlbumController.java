package com.kitri.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.util.*;


@WebServlet("/album")
public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // ��ũ�� �������� ��, 0 = ��� �Խ����� ��� �۸������
		int pg = NumberCheck.nullToOne(request.getParameter("pg")); // �������� 0��° �������� ���⶧���� 1�� �ʱ�ȭ
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoding.urlFormat(word);
		if (request.getMethod().equals("GET")) {
			word = Encoding.isoToEuc(word);
		} // post�϶��� encoding�������� get����϶��� �ϱ� 
		String path = "/index.jsp";
		if("mvwrite".equals(act)) {
			path = "/album/write.jsp";
			path += queryString;
			PageMove.redirect(path, request, response);
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.DEFAULT_CHAR_SET);
		doGet(request,response);
	}

}
