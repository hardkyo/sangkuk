<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List,com.kitri.admin.board.model.CategoryDto"%>
<%
String root = request.getContextPath();

List<CategoryDto> list = (List<CategoryDto>) request.getAttribute("clist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>ī�װ� ����</h3>
<form name="categoryform" method="get"	action="">
<input type="hidden" name="act" value="makecategory">
ī�װ��̸�
<input type="text" name="">
<input type="submit" value="ī�װ�����">
</form>
<ul>
<%
for(CategoryDto categoryDto : list) {
%>
<li><%=categoryDto.getCname() %>
<%	
}
%>
</ul>
</center>
</body>
</html>