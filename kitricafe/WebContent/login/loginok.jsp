<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
if(memberDto != null) {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function isDelete() {
	if(confirm("���� Ż��???")) {
		document.location.href = "<%=root%>/user?act=delete";
	}
}
</script>
</head>
<body>
<center>
<%=memberDto.getName() %>(<a href="mailto:<%=memberDto.getEmail1() %>@<%=memberDto.getEmail2() %>"><%=memberDto.getId() %></a>)�� �ȳ��ϼ���.<br>
<a href="<%=root%>/user?act=logout">�α׾ƿ�</a><br>
</center>
</body>
</html>
<%
} else {
	response.sendRedirect(root + "/user?act=mvlogin");
}
%>




