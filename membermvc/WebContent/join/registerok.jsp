<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String root = request.getContentType();

	String name = (String) request.getAttribute("name");
	String id = (String) request.getAttribute("id");
	String email = (String) request.getAttribute("email");
	String tel = (String) request.getAttribute("tel");
	String address = (String) request.getAttribute("address");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%=name%>�� ȸ������ ȯ���մϴ� <br> �α��� �� ���񽺸� �̿��Ͻ� �� �ֽ��ϴ�. <br> <a
			href="<%=root%>/login/login.jsp">�α���</a>

		<ul>
			<li>���̵�: <%=id%>
			<li>�̸� : <%=name %>
			<li>�̸���: <%=email%>
			<li>��ȭ��ȣ: <%=tel%>
			<li>�ּ�: <%=address%>
		</ul>
	</center>
</body>
</html>