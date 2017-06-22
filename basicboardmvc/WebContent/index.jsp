<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDto"%>
<%
	String root = request.getContextPath();

	MemberDto memberDto = new MemberDto(); // 고정 값을 집어넣어 강제 로그인 상태로 만듬. 
	memberDto.setId("java2");
	memberDto.setName("안효인");
	memberDto.setEmail1("java");
	memberDto.setEmail2("naver.com");
	
	session.setAttribute("loginInfo", memberDto);

	response.sendRedirect(root + "/boardadmin?act=boardlist");
%>
