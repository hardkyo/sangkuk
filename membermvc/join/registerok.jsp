<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();

String name = (String) request.getAttribute("name");
String id = (String) request.getAttribute("id");
String email = (String) request.getAttribute("email");
String tel = (String) request.getAttribute("tel");
String address = (String) request.getAttribute("address");
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
<%=name %>님 회원가입을 환영 합니다.<br>
가입 하신 정보는 아래와 같습니다.<br>
<ul>
	<li>아이디 : <%=id %>
	<li>이메일 : <%=email %>
	<li>전화번호 : <%=tel %>
	<li>주소 : <%=address %>
</ul>
로그인 후 서비스를 이용하실수 있습니다.<br>
<a href="<%=root %>/login/login.jsp">로그인</a>
<jsp:include page="/login/login.jsp"></jsp:include>
</center>
</body>
</html>















