<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="com.kitri.member.model.*"%>
<%
String root = request.getContextPath();

MemberDto memberDto = new MemberDto();
memberDto.setId("admin");
memberDto.setName("admin");
memberDto.setEmail1("admin");
memberDto.setEmail2("admin.co.kr");

session.setAttribute("loginInfo", memberDto);

response.sendRedirect(root + "/admin?act=main");
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">