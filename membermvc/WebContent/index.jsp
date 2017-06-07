<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String root = request.getContextPath();
	System.out.println(root);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h3>MVC Pattern을 이용한 &lt;회원가입 &gt; &amp; &apos; 로그인 &quot;</h3>
	<a href = "<%=root%>/user?act=mvjoin">회원가입</a><br> 
	<a href = "<%=root%>/user?act=mvlogin">로그인</a> 
	</center>
</body>
</html>