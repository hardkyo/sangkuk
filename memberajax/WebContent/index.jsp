<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();
String ua = request.getHeader("User-Agent");
System.out.println(ua);
if(ua.contains("Android")) {
	System.out.println("�ȵ���̵�� ����");
} else if(ua.contains("iPhone")) {
	System.out.println("�������� ����");
} else {
	System.out.println("PC�� ����");
}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function openpop(){
	window.open("<%=root%>/popup/pop1.jsp","idck","top=200, left=300, width=400, height=180, menubar=no, status=no, toolbar=no, location=no, scrollbars=no");
}
</script>
</head>
<%
//if(��Ű�ִٸ�) {
%>
<body>
<%	
//} else {
%>
<body onload="javascript:openpop();">
<%
//}
%>
<center>
<h3>MVC Pattern�� �̿��� &lt;ȸ������&gt; &amp; &apos;�α���&quot;</h3>
<a href="<%=root %>/user?act=mvjoin">ȸ������</a><br>
<a href="<%=root %>/user?act=mvlogin">�α���</a>
</center>
</body>
</html>












