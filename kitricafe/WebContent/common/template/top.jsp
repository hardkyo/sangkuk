<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<table width="1000">
<tr>
	<td height="60" align="center">
	<a href="<%=root%>"><img src="<%=root%>/img/logo.png"></a>
	</td>
</tr>
<tr>
	<td align="right">
<%
if(memberDto == null) {
%>
	<a href="<%=root%>/user?act=mvjoin">ȸ������</a>
	<a href="<%=root%>/user?act=mvlogin">�α���</a>
<%
} else {
%>
	<a href="<%=root%>/user?act=logout">�α׾ƿ�</a>
	<a href="<%=root%>/user?act=mvmodify">ȸ����������</a>
	<a href="javascript:isDelete();">ȸ��Ż��</a>
	<a href="<%=root%>/user?act=maillist">���Ϻ���</a>
<%	
}
%>
	</td>
</tr>
</table>