<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.List,com.kitri.admin.board.model.BoardListDto"%>
<%
List<BoardListDto> menulist = (List<BoardListDto>) application.getAttribute("boardmenu");
if(menulist != null) {
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#boardmenu p.category_name").click(function() {
		$(this).next("div.board_name").slideDown(500).siblings("div.board_name").slideUp("slow");
	});
});
</script>
<style type="text/css">
body {
	margin: 10px auto;
}

.board_list {
	width: 300px;
}

.category_name {
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	margin: 2px;
	font-weight: bold;
	text-align: left;
	background-color: #919191;
}

.board_name {
	display : none;
	text-align: left;
}

.board_name a {
	display: block;
	color: #a2a2a2;
	background: #e3e3e3;
	padding-left: 10px;
	text-decoration: none;
}

.board_name a:hover {
	color: #000000;
	text-decoration: underline;
}
</style>
</head>
<body>
<center>
<div align="right">
<a href="<%=root%>/boardadmin?act=mvadmin">������</a>
</div>
<div class="board_list" id="boardmenu">
<%
int size = menulist.size();
int ccode = 0;
for(int i=0;i<size;i++) {
	BoardListDto boardListDto = menulist.get(i);
	if(ccode != boardListDto.getCcode()) {
		ccode = boardListDto.getCcode();
%>
<p class="category_name"><%=boardListDto.getCname()%></p>
<div class="board_name">
<%
	}
%>
<a href="<%=root%>/<%=boardListDto.getControl() %>?act=list&bcode=<%=boardListDto.getBcode() %>&pg=1&key=&word=">
<img src="<%=root%>/img/board/ico-m-<%=boardListDto.getBtype() %>.gif">
<%=boardListDto.getBname() %>
</a>
<%
	if(i < size - 1) {
		if(ccode != menulist.get(i + 1).getCcode()) {
%>
</div>
<%
		}
	}
}
%>
</div>
</div>
</center>
</body>
</html>
<%
} else {
	response.sendRedirect(root + "/boardadmin?act=boardlist");
}
%>