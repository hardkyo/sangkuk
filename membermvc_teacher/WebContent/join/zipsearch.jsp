<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" 
    import="java.util.List,com.kitri.member.model.ZipDto"%>
<%
String root = request.getContextPath();

String dong = (String) request.getAttribute("sdong");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
function dongcheck(){
	if(document.getElementById("dong").value == "") {
		alert("�˻� �� �Է�!");
		return;
	} else {
		document.zipform.action = "<%=root%>/user";
		document.zipform.submit();
	}
}

function selectzip(z1, z2, address){
	opener.document.getElementById("zip1").value = z1;
	opener.document.getElementById("zip2").value = z2;
	opener.document.getElementById("addr1").value = address;
	
	self.close();
}
</script>
</head>
<body>
<center>
<form name="zipform" method="get" action="">
<input type="hidden" name="act" value="zipsearch">
<h3>�����ȣ�˻�</h3>
<table width="350">
<tr>
	<td class="td3">�˻��ҵ��� �Է��ϼ���<br>(��: ���ﵿ, ����)</td>
</tr>
<tr>
	<td class="td4">
	<input type="text" name="dong" id="dong" onkeypress="javascript:if(event.keyCode == 13){ dongcheck(); }">
	<input type="button" value="�˻�" id="btnsearch" onclick="javascript:dongcheck();">
	</td>
</tr>
<%
if(dong == null) {
%>
<tr>
	<td class="td4">
	���̸��� ��Ȯ�� �Է��ϼ���.
	</td>
</tr>
<%
} else {
	List<ZipDto> list = (List<ZipDto>) request.getAttribute("zipList");
	int size = list.size();
	if(size != 0) {
		for(int i=0;i<size;i++) {
			ZipDto zipDto = list.get(i);
%>
<tr>
	<td class="td4">
	<a href="javascript:selectzip('<%=zipDto.getZip1() %>', '<%=zipDto.getZip2() %>', '<%=zipDto.getSido() %> <%=zipDto.getGugun() %> <%=zipDto.getDong() %> <%=zipDto.getBunji() %>');">
	<%=zipDto.getZip1() %>-<%=zipDto.getZip2() %>
	<%=zipDto.getSido() %> <%=zipDto.getGugun() %> <%=zipDto.getDong() %> <%=zipDto.getBunji() %>
	</a>
	</td>
</tr>
<%
		}
	} else {
%>
<tr>
	<td class="td4">
	<b><%=dong %></b>�� ���� �˻� ����� �����ϴ�.
	</td>
</tr>
<%
	}
}
%>
</table>
</form>
</center>
</body>
</html>










