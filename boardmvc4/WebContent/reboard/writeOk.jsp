<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.kitri.util.*"%>
	<%@ include file="/common/public.jsp"%>
<%
String seq = (String) request.getAttribute("seq");
if (seq != null) { 
//viewArticle은 list에서 글 눌렀을 때도 사용되는 함수이기때문에  인자값으로 seq를 받은다음에 보내야함
%>
<table width="100%" cellpadding="6" cellspacing="2" border="0"
	bgcolor="#ffffff" style="border: #e1e1e1 solid 1px">
	<tr>
		<td class="bg_board_title" width="100%"><img
			src="<%=root%>/img/board/icon_arrow_08.gif" width="3" height="11"
			border="0" align="absmiddle" hspace="6" vspace="6"> <b>게시판</b>
		</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#e1e1e1"
			style="overflow: hidden; padding: 0px;"></td>
	</tr>
	<tr>
		<td class="bg_menu" width="100%" style="padding: 25px" height="35"
			align="center"><b>게시물이 등록되었습니다.</b><br>
		<br>

		<div align="center">
		<a href="javascript:viewArticle('<%=seq%>');">
		<img src="<%=root%>/img/board/b_wirtecf.gif" width="91" height="21" border="0" align="absmiddle" alt="작성한 글 확인" hspace="10">
			</a>
			<a href="javascript:listArticle('<%=pg%>');">
			<img src="<%=root%>/img/board/poll_listbu1.gif"
			width="62" height="21" border="0" align="absmiddle" alt="목록보기"
			hspace="10"></a>
			</div>
		</td>
	</tr>
</table>
<br>
</body>
</html>
<%
} else {
%>
	<script>
	alert("부적절한 URL접근입니다.");
	document.location.href = "<%=root%>";
	</script>
<%
}
%>