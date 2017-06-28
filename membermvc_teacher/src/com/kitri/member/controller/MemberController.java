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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "/index.jsp";
		boolean flag = false;
		if ("mvjoin".equals(act)) {
			path = "/join/member.jsp";
		} else if ("mvlogin".equals(act)) {
			path = "/login/login.jsp";
		} else if ("mvidck".equals(act)) {
			path = "/join/idcheck.jsp";
		} else if ("mvzip".equals(act)) {
			path = "/join/zipsearch.jsp";
		} else if ("idsearch".equals(act)) {
			String sid = request.getParameter("id");
			int count = memberService.idCheck(sid);
			path = "/join/idcheck.jsp?sid=" + sid + "&count=" + count;
		} else if ("zipsearch".equals(act)) {
			String sdong = Encoding.isoToEuc(request.getParameter("dong"));
			List<ZipDto> list = memberService.zipSearch(sdong);
			path = "/join/zipsearch.jsp?";
			request.setAttribute("sdong", sdong);
			request.setAttribute("zipList", list);
			flag= true;
		} else if ("register".equals(act)) {
			MemberDetailDto mddto = new MemberDetailDto();
			mddto.setId(request.getParameter("id"));
			mddto.setName(request.getParameter("name"));
			mddto.setPass(request.getParameter("pass"));
			mddto.setEmail1(request.getParameter("email1"));
			mddto.setEmail2(request.getParameter("email2"));
			mddto.setZip1(request.getParameter("zip1"));
			mddto.setZip2(request.getParameter("zip2"));
			mddto.setAddr1(request.getParameter("addr1"));
			mddto.setAddr2(request.getParameter("addr2"));
			mddto.setTel1(request.getParameter("tel1"));
			mddto.setTel2(request.getParameter("tel2"));
			mddto.setTel3(request.getParameter("tel3"));
			int cnt = memberService.register(mddto);
			if(cnt !=0) {
				path="/join/registerok.jsp";
				request.setAttribute("userinfo", mddto);
				flag= true;
			} else {
				path="/join/registerfail.jsp";
			}
		} else if ("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			MemberDto mdto= memberService.login(id, pass);
			if(mdto != null) {
				String idsv = request.getParameter("idsv");
				if("idsave".equals(idsv)){ //아이디저장 체크
					Cookie cookie = new Cookie("kitri_sid", id);
					cookie.setMaxAge(60*60*24*365*1000);
					cookie.setPath(root);
					response.addCookie(cookie);
				} else { //아이디저장 체크 해제
				    Cookie cookie[] = request.getCookies();
				    if(cookie !=null) {
				   	 	int len = cookie.length;
				    	for(int i=0;i<len;i++) {
				    		if("kitri_sid".equals(cookie[i].getName())) {
				    			cookie[i].setMaxAge(0);
				    			cookie[i].setPath(root);
				    			response.addCookie(cookie[i]);
				    			
				    			break;
				    		}
				    	}
				    }
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", mdto);
				
				path="/login/loginok.jsp";
//				request.setAttribute("loginInfo", mdto);
//				flag=true;
			} else {
				path="/login/loginfail.jsp";
			}
		} else if ("logout".equals(act)) {
			HttpSession session = request.getSession();
//			session.setAttribute("loginInfo", null);
//			session.removeAttribute("loginInfo");
			session.invalidate(); //초기화,세션안의 정보 모두제거 주
			path = "/login/login.jsp";
			
		} else if ("mvmodify".equals(act)) {
		    MemberDto mdto = (MemberDto) request.getSession().getAttribute("loginInfo");
//			HttpSession session = request.getSession();
//			MemberDto mdto = (MemberDto) session.getAttribute("loginInfo");
		    if(mdto!=null) {
				String id = mdto.getId();
				MemberDetailDto mmdto= memberService.getMember(id);
				if(mmdto!=null) {
					path= "/join/modify.jsp";
					request.setAttribute("modify", mmdto);
					flag=true;	
					
				} 
		    } else {	
				path= "/login/login.jsp";
				
			}
		} else if ("modify".equals(act)) {
		    MemberDto mdto = (MemberDto) request.getSession().getAttribute("loginInfo");
		    if(mdto!=null) {
			MemberDetailDto mddto = new MemberDetailDto();
			mddto.setId(mdto.getId());
			mddto.setPass(request.getParameter("pass"));
			mddto.setEmail1(request.getParameter("email1"));
			mddto.setEmail2(request.getParameter("email2"));
			mddto.setZip1(request.getParameter("zip1"));
			mddto.setZip2(request.getParameter("zip2"));
			mddto.setAddr1(request.getParameter("addr1"));
			mddto.setAddr2(request.getParameter("addr2"));
			mddto.setTel1(request.getParameter("tel1"));
			mddto.setTel2(request.getParameter("tel2"));
			mddto.setTel3(request.getParameter("tel3"));
			int cnt = memberService.modify(mddto);
				if(cnt !=0) {
					path="/join/modifyok.jsp";
					request.setAttribute("modifyinfo", mddto);
					flag= true;
				}
			} else {
				path="/join/modifyfail.jsp";
			}
		} else if ("delete".equals(act)) {
		    MemberDto mdto = (MemberDto) request.getSession().getAttribute("loginInfo");
		    String id =mdto.getId();
			int cnt = memberService.delete(id);
			if(cnt!=0){
				path="/join/deleteok.jsp";
			} else {
				path="/join/deletefail.jsp";
			}
		} else if ("maillist".equals(act)) {
			path = "/mail/maillist.jsp";
		} 
		if (flag) {
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		} else {
			response.sendRedirect(root + path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request,response);
	}

}
