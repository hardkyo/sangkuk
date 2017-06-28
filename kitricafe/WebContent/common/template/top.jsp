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