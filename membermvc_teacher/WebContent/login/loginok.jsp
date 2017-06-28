<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDto"%>
    <%
    String root = request.getContextPath();
    
    MemberDto mdto = (MemberDto) session.getAttribute("loginInfo");
    if(mdto!=null) {
    %>
    <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
function isDelete() {
	if(confirm("정말탈퇴할꺼야?")) {
	document.location.href="<%=root%>/user?act=delete";		
	}
	
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%=mdto.getName()%>(<a href="mailto:<%=mdto.getEmail1() %>@<%=mdto.getEmail2() %>"><%=mdto.getId() %></a>)님 안녕하세요<br>
<a href="<%=root%>/user?act=logout">로그아웃</a><br>
<a href="<%=root%>/user?act=mvmodify">회원정보수정</a><br>
<a href="javascript:isDelete();">회원탈퇴</a><br>
<a href="<%=root%>/user?act=maillist">메일보기</a><br>
</body>
</html>
<% } else {
	response.sendRedirect(root+"/user?act=mvlogin");

}%>