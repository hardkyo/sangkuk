<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
String root = request.getContextPath();

    Cookie cookie[] = request.getCookies();
    String saveid = "";
    String idck="";
    if(cookie !=null) {
   	 	int len = cookie.length;
    	for(int i=0;i<len;i++) {
    		if("kitri_sid".equals(cookie[i].getName())) {
    			saveid = cookie[i].getValue();
    			idck="checked=\"checked\"";
    			break;
    		}
    	}
    }
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
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
function logincheck(){
	if(document.getElementById("id").value  == "") {
		alert("아이디 입력!");
		return;
	} else if(document.getElementById("pass").value == "") {
		alert("비밀번호 입력!");
		return;
	} else {
		document.loginform.action = "<%=root%>/user";
		document.loginform.submit();
	}
}
function joinmove(){
	document.location.href="<%=root%>/user?act=mvjoin";
}
</script>	
</head>
<body>
<center>
<form name="loginform" method="post" action="">
<input type="hidden" name="act" value="login">
<table>
<tr>
	<td colspan="2" align="right">
	<input type="checkbox" name="idsv" value="idsave" <%=idck %>> 아이디저장
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
	<input type="button" value="로그인" onclick="javascript:logincheck();">
	<input type="button" value="회원가입" onclick="javascript:joinmove();">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>