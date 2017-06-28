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
	<a href="<%=root%>/user?act=mvjoin">회원가입</a>
	<a href="<%=root%>/user?act=mvlogin">로그인</a>
<%
} else {
%>
	<a href="<%=root%>/user?act=logout">로그아웃</a>
	<a href="<%=root%>/user?act=mvmodify">회원정보수정</a>
	<a href="javascript:isDelete();">회원탈퇴</a>
	<a href="<%=root%>/user?act=maillist">메일보기</a>
<%	
}
%>
	</td>
</tr>
</table>