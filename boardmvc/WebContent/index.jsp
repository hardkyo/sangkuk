<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDto"%>
<%
	String root = request.getContextPath();

	MemberDto memberDto = new MemberDto(); // ���� ���� ����־� ���� �α��� ���·� ����. 
	memberDto.setId("sangkuk");
	memberDto.setName("����");
	memberDto.setEmail1("java");
	memberDto.setEmail2("naver.com");
	
	session.setAttribute("loginInfo", memberDto);

	response.sendRedirect(root + "/boardadmin?act=boardlist");
%>
