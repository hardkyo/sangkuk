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
<h3>카테고리 생성</h3>
<form name="categoryform" method="get"	action="">
<input type="hidden" name="act" value="makecategory">
카테고리이름
<input type="text" name="">
<input type="submit" value="카테고리생성">
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