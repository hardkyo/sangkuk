<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	String root = request.getContentType();

	String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "euc-kr");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
		<!-- ���̵�, ��й�ȣ, �̸��� ��ġ�ϸ� -->
		<%=name%>�� �ȳ��ϼ���. <br> �α��� ���񽺸� ����� �� �ֽ��ϴ�.
	</center>
</body>
</html>