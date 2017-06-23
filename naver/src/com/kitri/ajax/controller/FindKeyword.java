package com.kitri.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.ajax.model.KeywordDao;
import com.kitri.ajax.model.KeywordDto;
import com.kitri.util.Encoding;

@WebServlet("/findkeyword")
public class FindKeyword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<KeywordDto> list;
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
		
		String first = request.getParameter("first");
		String keyword = Encoding.isoToUtf(request.getParameter("keyword"));
//		System.out.println(keyword + " :::::::::::::: " + first);
		
		String result = "";
		if("first".equals(first)) {
//			System.out.println("db에서 얻어와라....");
			list = keywordDao.searchKeyword(keyword);
			int len = list.size();
			result = len + "|";
			for(int i=0;i<len;i++) {
				KeywordDto keywordDto = list.get(i);
				result += keywordDto.getKeyword();
				if(i < len - 1)
					result += ",";
			}
//			3|자바,제주도,재미
		} else {
//			System.out.println("list에서 얻어와라....");
			List<String> resultList = new ArrayList<String>();
			int len = list.size();
			for(int i=0;i<len;i++) {
				String kw = list.get(i).getKeyword();
				if(kw.toUpperCase().startsWith(keyword.toUpperCase())) {
					resultList.add(kw);
				}
			}
			
			int len2 = resultList.size();
			result = len2 + "|";
			for(int i=0;i<len2;i++) {
				result += resultList.get(i);
				if(i < len2 - 1)
					result += ",";
			}
//			1|자바
		}
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
