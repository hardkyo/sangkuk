<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>게시판 관리자</h3>
<a href="<%=root%>/boardadmin?act=mvmakecategory">카테고리생성</a><br>
<a href="<%=root%>/boardadmin?act=mvmakeboard">게시판생성</a><br>
</center>
</body>
</html>