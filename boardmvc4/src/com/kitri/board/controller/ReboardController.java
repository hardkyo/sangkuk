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
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // 링크가 지워졌을 때, 0 = 모든 게시판의 모든 글목록으로
		int pg = NumberCheck.nullToOne(request.getParameter("pg")); // 페이지는 0번째 페이지가 없기때문에 1로 초기화
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		if (request.getMethod().equals("GET")) {
			word = Encoding.isoToEuc(word);
		} // post일때는 encoding하지말고 get방식일때만 하기 
		
		// 공통 페이지에서 처리해야하기 때문에 action이 아니라 controller에서 처리함
		// 모든 jsp에는 bcode, pg, key, word를 반드시 보내야 한다.
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoding.urlFormat(word); // 공백있으면 안되고, &없으면 안됨
		// 쿼리스트링에 word를 euc-kr로 만들어서 바로 보내면 안됨
		// queryString에ㅔ 있는거 말고 다른걸 받아와야할때는 request에 담기
		System.out.println("RC >>>> "+ queryString); // 오류 잡을 때 중요한 부분
		String path = "/index.jsp";
		
		if("mvwrite".equals(act)) {
			path ="/reboard/write.jsp" + queryString;
			PageMove.redirect(path, request, response);
		} else if("write".equals(act)) {
			path = BoardActionFactory.getReboardWriteAction().execute(request, response); // factory는 action객체 만들어줌
			
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
