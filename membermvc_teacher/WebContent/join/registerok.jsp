
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
<%=mmdto.getName() %>�� ȸ������ ȯ��!<br> 
���� �Ͻ� ������ �Ʒ��� �����ϴ�.<br>
<ul>
	<li>���̵� : <%=mmdto.getId() %>
	<li>�̸��� : <%=mmdto.getEmail1() %>@<%=mmdto.getEmail2() %>
	<li>��ȭ��ȣ : <%=mmdto.getTel1() %>-<%=mmdto.getTel2() %>-<%=mmdto.getTel3() %>
	<li>�ּ� : <%=mmdto.getAddr1() %> <%=mmdto.getAddr2() %>
</ul>
		<a href="<%=root %>/user?act=mvlogin">�α���</a> �� �̿밡��! 
</body>
</html>
<% } else {
%>
<script>
alert("�������� URL����");
document.location.href="<%=root%>";
</script>
<%	
}
%>
