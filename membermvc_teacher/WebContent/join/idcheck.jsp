<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String root = request.getContextPath();
String sid = request.getParameter("sid");

%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
function idcheck(){
	if(document.getElementById("id").value == "") {
		alert("검색 아이디 입력!");
		return;
	} else {
		document.idform.action = "<%=root%>/user";
		document.idform.submit();
	}
}

function iduse(id){
	opener.document.getElementById("id").value=id;
	self.close();
}
</script>
</head>
<body>
<center>
<form name="idform" method="get" action="" onsubmit="return false;">
<input type="hidden" name="act" value="idsearch">
<h3>아이디 중복 검사</h3>
<table width="350">
<tr>
	<td class="td3">검색할 아이디를 입력하세요</td>
</tr>
<tr>
	<td class="td4" style="text-align: center">
	<input type="text" name="id" id="id" onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
	<input type="button" value="검색" onclick="javascript:idcheck();">
	</td>
</tr>
<%
if(sid==null) {

%>
<tr>
	<td class="td4">
	검색할 아이디를 정확히 입력한 후 검색 버튼을 클릭하세요..
	</td>
</tr>
<%} else { 
	int count = Integer.parseInt(request.getParameter("count"));
	if(count==0) {
%>
<tr>
	<td class="td4">
	<b><%=sid %></b>는 사용가능한아이디.
	<input type="button" value="사용" onclick="javascript:iduse('<%=sid%>');">
	</td>
</tr>
<% } else { %>
<tr>
	<td class="td4">
	<b><%=sid %></b>는 사용중 <br>
	다른 아이디로 검색
	</td>
</tr>
<%
	}
}
%>
</table>
</form>
</center>
</body>
</html>