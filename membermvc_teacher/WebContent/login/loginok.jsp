<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.member.model.MemberDto"%>
    <%
    String root = request.getContextPath();
    
    MemberDto mdto = (MemberDto) session.getAttribute("loginInfo");
    if(mdto!=null) {
    %>
    <!-- �������� �ּ�ȭ�� �ֽ� CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- �ΰ����� �׸� -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- �������� �ּ�ȭ�� �ֽ� �ڹٽ�ũ��Ʈ -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
function isDelete() {
	if(confirm("����Ż���Ҳ���?")) {
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
<%=mdto.getName()%>(<a href="mailto:<%=mdto.getEmail1() %>@<%=mdto.getEmail2() %>"><%=mdto.getId() %></a>)�� �ȳ��ϼ���<br>
<a href="<%=root%>/user?act=logout">�α׾ƿ�</a><br>
<a href="<%=root%>/user?act=mvmodify">ȸ����������</a><br>
<a href="javascript:isDelete();">ȸ��Ż��</a><br>
<a href="<%=root%>/user?act=maillist">���Ϻ���</a><br>
</body>
</html>
<% } else {
	response.sendRedirect(root+"/user?act=mvlogin");

}%>