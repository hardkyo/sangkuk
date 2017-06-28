package com.kitri.ajax.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.ajax.model.KeywordDao;
import com.kitri.ajax.model.KeywordDto;

@WebServlet("/rank")
public class CurrentRank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private KeywordDao keywordDao;
	
	public void init() {
		keywordDao = new KeywordDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-store");   
		response.setHeader("Pragma","no-cache");   
		response.setDateHeader("Expires",0);   
		if (request.getProtocol().equals("HTTP/1.1")) 
		        response.setHeader("Cache-Control", "no-cache"); 
		
		List<KeywordDto> list = keywordDao.getCurrentRank();
		request.setAttribute("rank", list);
		RequestDispatcher disp = request.getRequestDispatcher("/ranklist.jsp");
		disp.forward(request, response);
	}

}
















