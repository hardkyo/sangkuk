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
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
function dongcheck(){
	if(document.getElementById("dong").value == "") {
		alert("검색 동 입력!");
		return;
	} else {
		document.zipform.action = "";
		document.zipform.submit();
	}
}

function selectzip(z1, z2, address){

}
</script>
</head>
<body>
<center>
<form name="zipform" method="get" action="">
<input type="hidden" name="act" value="zipsearch">
<h3>우편번호검색</h3>
<table width="350">
<tr>
	<td class="td3">검색할동을 입력하세요<br>(예: 역삼동, 신촌)</td>
</tr>
<tr>
	<td class="td4">
	<input type="text" name="dong" id="dong" onkeypress="javascript:if(event.keyCode == 13){ dongcheck(); }">
	<input type="button" value="검색" id="btnsearch" onclick="javascript:dongcheck();">
	</td>
</tr>
<tr>
	<td class="td4">
	검색 결과가 없습니다.<br>
	동이름을 정확히 입력하세요.
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>










