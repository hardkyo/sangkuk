
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDetailDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
String root = request.getContextPath();
MemberDetailDto mmdto= (MemberDetailDto) request.getAttribute("userinfo");
if(mmdto!=null){
%>
<%=mmdto.getName() %>님 회원가입 환영!<br> 
가입 하신 정보는 아래와 같습니다.<br>
<ul>
	<li>아이디 : <%=mmdto.getId() %>
	<li>이메일 : <%=mmdto.getEmail1() %>@<%=mmdto.getEmail2() %>
	<li>전화번호 : <%=mmdto.getTel1() %>-<%=mmdto.getTel2() %>-<%=mmdto.getTel3() %>
	<li>주소 : <%=mmdto.getAddr1() %> <%=mmdto.getAddr2() %>
</ul>
		<a href="<%=root %>/user?act=mvlogin">로그인</a> 후 이용가능! 
</body>
</html>
<% } else {
%>
<script>
alert("부적절한 URL접근");
document.location.href="<%=root%>";
</script>
<%	
}
%>
