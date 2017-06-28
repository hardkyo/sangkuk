package com.kitri.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.*;
import com.kitri.member.model.service.MemberService;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.Encoding;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;
	
	public void init() {
		memberService = new MemberServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getMethod().equals("POST"))
//		request.setCharacterEncoding("EUC-KR");
		System.out.println(request.getHeader("referer"));
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		boolean flag = false;
		if("mvjoin".equals(act)) {
			path = "/join/member.jsp";
		} else if("mvlogin".equals(act)) {
			path = "/login/center_login.jsp";
		} else if("mvidck".equals(act)) {
			path = "/join/idcheck.jsp";
		} else if("mvzip".equals(act)) {
			path = "/join/zipsearch.jsp";
		} else if("idsearch".equals(act)) {
			String sid = request.getParameter("id");
			int count = memberService.idCheck(sid);
			path = "/join/idcheckresult.jsp?sid=" + sid + "&count=" + count;
		} else if("zipsearch".equals(act)) {
			String sdong = Encoding.isoToEuc(request.getParameter("dong"));
			System.out.println("검색동 ::: " + sdong);
			List<ZipDto> list = memberService.zipSearch(sdong);
			System.out.println("검색동 갯수 : " + list.size());
			path = "/join/zipsearch.jsp";
			request.setAttribute("sdong", sdong);
			request.setAttribute("zipList", list);
			flag = true;
		} else if("register".equals(act)) {
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setEmail1(request.getParameter("email1"));
			memberDetailDto.setEmail2(request.getParameter("email2"));
			memberDetailDto.setZip1(request.getParameter("zip1"));
			memberDetailDto.setZip2(request.getParameter("zip2"));
			memberDetailDto.setAddr1(request.getParameter("addr1"));
			memberDetailDto.setAddr2(request.getParameter("addr2"));
			memberDetailDto.setTel1(request.getParameter("tel1"));
			memberDetailDto.setTel2(request.getParameter("tel2"));
			memberDetailDto.setTel3(request.getParameter("tel3"));
			int cnt = memberService.register(memberDetailDto);
			if(cnt != 0) {
				path = "/join/registerok.jsp";
				request.setAttribute("userInfo", memberDetailDto);
				flag = true;
			} else {
				path = "/join/registerfail.jsp";
			}
		} else if("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			MemberDto memberDto = memberService.login(id, pass);
			if(memberDto != null) {
				
				//////////////////// Cookie ///////////////////////
				String idsv = request.getParameter("idsv");
				if("idsave".equals(idsv)) {//아이디저장 체크
					Cookie cookie = new Cookie("kid_sid", id);
					cookie.setMaxAge(60*60*24*365);
					cookie.setPath(root);
					
					response.addCookie(cookie);
//					Cookie cookie2 = new Cookie("kid_spwd", pass);
//					cookie2.setMaxAge(60*60*24*365);
//					cookie2.setPath(root);
//					
//					response.addCookie(cookie2);
				} else {//아이디저장 체크X
					Cookie cookie[] = request.getCookies();
					if(cookie != null) {
						int len = cookie.length;
						for(int i=0;i<len;i++) {
							if("kid_sid".equals(cookie[i].getName())) {
								cookie[i].setMaxAge(0);
								cookie[i].setPath(root);
								response.addCookie(cookie[i]);
								break;
							}
						}
					}
				}
				////////////////////Cookie ///////////////////////
				
				//////////////////// session ///////////////////////
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", memberDto);
				//////////////////// session ///////////////////////
				
				path = "/index.jsp";
//				request.setAttribute("loginInfo", memberDto);
//				flag = true;
			} else {
				path = "/login/loginfail.jsp";
			}
		} else if("logout".equals(act)) {
			HttpSession session = request.getSession();
//			session.setAttribute("loginInfo", null);
//			session.removeAttribute("loginInfo");
			session.invalidate();
			
			path = "/index.jsp";
		} else if("mvmodify".equals(act)) {
			
			path = "/join/modify.jsp";
		} else if("modify".equals(act)) {
			
		} else if("delete".equals(act)) {
			
		} else if("maillist".equals(act)) {
			path = "/mail/maillist.jsp";
		}
		
		if(flag) {
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		} else {
			response.sendRedirect(root + path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}

/*
 * * Cookie & Session
 * 1. Cookie				: client 	String(*.txt file)
 * Cookie cookie = new Cookie(S, S);
 * cookie.setMaxAge(60*60*24*365*10);//만료날짜
 * cookie.setDomain("www.naver.com");
 * cookie.setPath("/membermvc");
 * 
 * response.addCookie(cookie);
 * 
 * 
 * 2. session(HttpSession)	: server	Object(memory)
 * 
 * 
 */











