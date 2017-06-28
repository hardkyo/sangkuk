<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List,com.kitri.admin.board.model.*"%>
<%
String root = request.getContextPath();

List<CategoryDto> clist = (List<CategoryDto>) request.getAttribute("clist");
List<BoardTypeDto> btlist = (List<BoardTypeDto>) request.getAttribute("btlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>게시판 생성</h3>
<form name="boardform" method="get" action="">
<select name="ccode">
<%
for(CategoryDto categoryDto : clist) {
%>
<option value="<%=categoryDto.getCcode()%>">
<%=categoryDto.getCname()%>
<%	
}
%>
</select>
<select name="btype">
<%
for(BoardTypeDto boardTypeDto : btlist) {
%>
<option value="<%=boardTypeDto.getBtype()%>">
<%=boardTypeDto.getBtypeName()%>
<%	
}
%>
</select>
<input type="hidden" name="act" value="makeboard">
게시판이름
<input type="text" name="bname">
<input type="submit" value="게시판생성">
</form>
</center>
</body>
</html>











