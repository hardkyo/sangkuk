<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<table width="1000">
<tr>
	<td colspan="2" height="60" align="center">
	<a href="<%=root%>"><img src="<%=root%>/img/logo.png"></a>
	</td>
</tr>
<tr>
	<td width="600" align="center">
	<form name="searchform" method="get" action="/naver/search">
	<table width="510">
	<tr>
		<td valign="top" align="center">
		<table width="350">
		<tr>
			<td align="center" valign="middle">
			<input type="text" name="keyword" id="keyword" size="35"
				style="border: #00cc33 3px solid; height: 38px;"
				onkeydown="javascript:getkeyword();"><input type="image" src="/naver/img/search.png" align="middle"
				border="0" style="padding-bottom: 10px;" height="47px">
			</td>
		</tr>
		<tr>
			<td>
			<div id="search" style="display: none; border: #939699 1px solid;">
				<div id="searchlist"></div>
			</div>
			</td>
		</tr>
		</table>
		</td>
	</tr>
	</table>
	</form>
	</td>
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