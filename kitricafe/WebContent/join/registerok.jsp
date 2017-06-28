<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDetailDto"%>
<%@ include file="/common/template/header.jsp" %>
<%
MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("userInfo");
if(memberDetailDto != null) {
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<!-- 회원 가입 성공시 -->
<%=memberDetailDto.getName() %>님 회원가입을 환영 합니다.<br>
가입 하신 정보는 아래와 같습니다.<br>
<ul>
	<li>아이디 : <%=memberDetailDto.getId() %>
	<li>이메일 : <%=memberDetailDto.getEmail1() %>@<%=memberDetailDto.getEmail2() %>
	<li>전화번호 : <%=memberDetailDto.getTel1() %>-<%=memberDetailDto.getTel2() %>-<%=memberDetailDto.getTel3() %>
	<li>주소 : <%=memberDetailDto.getZip1() %>-<%=memberDetailDto.getZip2() %>
	<%=memberDetailDto.getAddr1() %> <%=memberDetailDto.getAddr2() %>
</ul>
로그인 후 서비스를 이용하실수 있습니다.<br>
<a href="<%=root %>/user?act=mvlogin">로그인</a>
</center>
</body>
</html>
<%
} else {
%>
<script>
alert("부적절한 URL접근입니다.");
document.location.href = "<%=root%>";
</script>
<%	
}
%>
<%@ include file="/common/template/footer.jsp" %>













