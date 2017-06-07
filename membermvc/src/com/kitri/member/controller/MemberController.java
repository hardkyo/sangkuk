package com.kitri.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "/index.jsp";
		
		if ("mvjoin".equals(act)) { // null 포인트 익셉션 발생 안함
			path = "/join/member.jsp";
		} else if ("mvlogin".equals(act)) {
			path = "/login/login.jsp";
		} else if ("mvidck".equals(act)) {
			path = "/join/idcheck.jsp";
		} else if ("mvzip".equals(act)) {
			path = "/join/zipsearch.jsp";
		} else if ("".equals(act)) {

		}
		
		response.sendRedirect(root + path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
