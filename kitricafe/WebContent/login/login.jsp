<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();

Cookie cookie[] = request.getCookies();
String saveid = "";
String idck = "";
if(cookie != null) {
	int len = cookie.length;
	for(int i=0;i<len;i++) {
		if("kid_sid".equals(cookie[i].getName())) {
			saveid = cookie[i].getValue();
			idck = " checked=\"checked\"";
			break;
		}
	}
}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
function logincheck(formclass){
	var form = document.getElementsByClassName(formclass)[0];
	if(form.id.value  == "") {
		alert("���̵� �Է�!");
		return;
	} else if(form.pass.value == "") {
		alert("��й�ȣ �Է�!");
		return;
	} else {
		form.action = "<%=root %>/user";
		form.submit();
	}
}
function joinmove(){
	document.location.href = "<%=root %>/user?act=mvjoin";
}
</script>
</head>
<body>
<center>
<form name="loginform" class="llogin" method="post" action="">
<input type="hidden" name="act" value="login">
<table>
<tr>
	<td colspan="2" align="right">
	<input type="checkbox" name="idsv" value="idsave"<%=idck %>>���̵�����
	</td>
</tr>
<tr>
	<td class="td1">���̵�</td>
	<td class="td3"><input type="text" name="id" id="id" value="<%=saveid%>"></td>
</tr>
<tr>
	<td class="td2">��й�ȣ</td>
	<td class="td4"><input type="password" name="pass" id="pass"></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="button" value="�α���" onclick="javascript:logincheck('llogin');">
	<input type="button" value="ȸ������" onclick="javascript:joinmove();">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>