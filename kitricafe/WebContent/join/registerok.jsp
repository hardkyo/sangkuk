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
<!-- ȸ�� ���� ������ -->
<%=memberDetailDto.getName() %>�� ȸ�������� ȯ�� �մϴ�.<br>
���� �Ͻ� ������ �Ʒ��� �����ϴ�.<br>
<ul>
	<li>���̵� : <%=memberDetailDto.getId() %>
	<li>�̸��� : <%=memberDetailDto.getEmail1() %>@<%=memberDetailDto.getEmail2() %>
	<li>��ȭ��ȣ : <%=memberDetailDto.getTel1() %>-<%=memberDetailDto.getTel2() %>-<%=memberDetailDto.getTel3() %>
	<li>�ּ� : <%=memberDetailDto.getZip1() %>-<%=memberDetailDto.getZip2() %>
	<%=memberDetailDto.getAddr1() %> <%=memberDetailDto.getAddr2() %>
</ul>
�α��� �� ���񽺸� �̿��ϽǼ� �ֽ��ϴ�.<br>
<a href="<%=root %>/user?act=mvlogin">�α���</a>
</center>
</body>
</html>
<%
} else {
%>
<script>
alert("�������� URL�����Դϴ�.");
document.location.href = "<%=root%>";
</script>
<%	
}
%>
<%@ include file="/common/template/footer.jsp" %>













