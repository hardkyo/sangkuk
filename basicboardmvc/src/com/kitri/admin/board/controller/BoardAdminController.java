package com.kitri.admin.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.admin.board.action.BoardListAction;
import com.kitri.factory.BoardAdminActionFactory;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageMove;

@WebServlet("/boardadmin")
public class BoardAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act=request.getParameter("act");
		String path="/index.jsp";
		
		
		if("boardlist".equals(act)){
			path=BoardAdminActionFactory.getBoardListAction().execute(request,response);
			PageMove.forward(path, request, response);
		}else if("".equals(act)){
			
		}else if("".equals(act)){
			
		}else if("".equals(act)){
			
		}else if("".equals(act)){
			
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.DEFAULT_CHAR_SET);
		doGet(request, response);
	}

}
