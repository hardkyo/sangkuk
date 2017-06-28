<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table width="200">
<tr>
	<td height="200">
<%
if(memberDto == null) {
%>
	<jsp:include page="/login/login.jsp"/>
<%
} else {
%>
	<jsp:include page="/login/loginok.jsp"/>
<%	
}
%>
	</td>
</tr>
<tr>
	<td>
	<%@ include file="/admin/boardmenu.jsp" %>
	</td>
</tr>
</table>