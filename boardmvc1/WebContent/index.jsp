<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDto"%>
<%
	String root = request.getContextPath();

	MemberDto memberDto = new MemberDto();
	
	memberDto.setId("tnwls0625");
	memberDto.setName("¹Ú¼öÁø");
	memberDto.setEmail1("psujin831");
	memberDto.setEmail2("gmail.com");

	session.setAttribute("loginInfo", memberDto);

	response.sendRedirect(root + "/boardadmin?act=boardlist");
%>
