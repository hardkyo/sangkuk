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
function logincheck(){
	if(document.getElementById("id").value  == "") {
		alert("���̵� �Է�!");
		return;
	} else if(document.getElementById("pass").value == "") {
		alert("��й�ȣ �Է�!");
		return;
	} else {
		document.loginform.action = "<%=root %>/login/loginprocess.jsp";
		document.loginform.submit();
	}
}
function joinmove(){
	document.location.href = "<%=root %>/user?act=mvjoin";
}
</script>
</head>
<body>
<center>
<form name="loginform" method="post" action="">
<table>
<tr>
	<td class="td1">���̵�</td>
	<td class="td3"><input type="text" name="id" id="id"></td>
</tr>
<tr>
	<td class="td2">��й�ȣ</td>
	<td class="td4"><input type="password" name="pass" id="pass"></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="button" value="�α���" onclick="javascript:logincheck();">
	<input type="button" value="ȸ������" onclick="javascript:joinmove();">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>