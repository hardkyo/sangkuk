package com.kitri.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.member.model.service.MemberService;
import com.kitri.member.model.service.MemberServiceImpl;


@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;
	
	public void init() {
		memberService = new MemberServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "/index.jsp";
		
		if ("mvjoin".equals(act)) {
			path = "/join/member.jsp";
		}else if ("mvlogin".equals(act)) {
			path = "/login/login.jsp";
		}else if ("mvidck".equals(act)) {
			path = "/join/idcheck.jsp";
		}else if ("idsearch".equals(act)) {
			String sid = request.getParameter("id");
			int count = memberService.idcheck(sid);
			path = "/join/idcheck.jsp?sid=" + sid + "&count=" + count;
		}else if ("".equals(act)) {
		
		}else if ("".equals(act)) {
			
		}
		
		response.sendRedirect(root + path); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
