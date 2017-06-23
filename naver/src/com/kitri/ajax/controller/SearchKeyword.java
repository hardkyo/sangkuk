package com.kitri.ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.ajax.model.KeywordDao;
import com.kitri.util.Encoding;

@WebServlet("/search")
public class SearchKeyword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private KeywordDao keywordDao;
	
	public void init() {
		keywordDao = new KeywordDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = Encoding.isoToEuc(request.getParameter("keyword"));
//		System.out.println(">>>>>>" + keyword);
		keywordDao.updateHit(keyword);
		response.sendRedirect(request.getContextPath() + "/index.html");
	}

}















