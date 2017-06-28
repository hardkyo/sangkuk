<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/common/template/header.jsp" %>
<%
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
</head>
<body>
<center>
<form name="loginform" class="clogin" method="post" action="">
<input type="hidden" name="act" value="login">
<table width="500">
<tr>
	<td colspan="2" align="right">
	<input type="checkbox" name="idsv" value="idsave"<%=idck %>>아이디저장
	</td>
</tr>
<tr>
	<td class="td1">아이디</td>
	<td class="td3"><input type="text" name="id" id="id" value="<%=saveid%>"></td>
</tr>
<tr>
	<td class="td2">비밀번호</td>
	<td class="td4"><input type="password" name="pass" id="pass"></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="button" value="로그인" onclick="javascript:logincheck('clogin');">
	<input type="button" value="회원가입" onclick="javascript:joinmove();">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>
<jsp:include page="/common/template/footer.jsp"/>