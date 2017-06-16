<%@page import="com.sun.org.glassfish.gmbal.IncludeSubclass"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="com.kitri.util.PageNavigation,java.util.List,com.kitri.board.model.ReboardDto"%>

<%@ include file="/common/public.jsp"%>
<%
	List<ReboardDto> list = (List<ReboardDto>) request.getAttribute("articleList");
	if (list != null) {
		PageNavigation navigator = (PageNavigation) request.getAttribute("navigator");
%>
<script type="text/javascript">
function searchArticle() {
	if (document.searchForm.word.value == "") {
		alert("검색어를 입력하시오");
		return;
	}else {
		document.searchForm.action ="<%=root%>/reboard";
		document.searchForm.submit();
		}
}
</script>
<!-- title start -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td><img src="<%=root%>/img/board/m_icon_board.gif" width="9"
			height="9" border="0" align="absmiddle" style="margin-top: -2px">
			<b>자유게시판</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; 자유로운
			글을 올리는 공간입니다<br></td>
		<td align="right"></td>
	</tr>
	<tr>
		<td colspan="2" height="19"></td>
	</tr>
</table>
<!-- title end -->

<!-- bbs start -->
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr valign="bottom">
		<td nowrap><a href="javascript:moveWrite();"><img
				src="<%=root%>/img/board/btn_write_01.gif" width="64" height="22"
				border="0" align="absmiddle" alt="글쓰기"></a></td>

		<td width="100%" style="padding-left: 6px" valign="bottom">새글 <b><font
				class="text_acc_02"><%=navigator.getNewArticleCount()%></font></b> / 전체
			<font class="text_acc_02"><%=navigator.getTotalArticleCount()%></font></td>
		<td width="300" nowrap>
			<div align="right"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" height="5" style="padding: 0px"></td>
	</tr>
</table>

<form name="listForm" method="post" style="margin: 0px">
	<table width="100%" cellpadding="5" cellspacing="0" border="0">
		<tr>
			<td class="bg_board_title_02" height="2" colspan="11"
				style="overflow: hidden; padding: 0px"></td>
		</tr>
		<tr class="bg_board_title" align="center" height="28">
			<td nowrap><b>번호</b></td>
			<td nowrap class="board_bar" style="padding: 0px">|</td>
			<td></td>
			<td width="100%"><b>제목</b></td>
			<td nowrap class="board_bar" style="padding: 0px">|</td>
			<td width="120" nowrap><b>글쓴이</b></td>
			<td nowrap class="board_bar" style="padding: 0px">|</td>
			<td nowrap><b>조회</b></td>
			<td nowrap class="board_bar" style="padding: 0px">|</td>
			<td width="45" nowrap><b>날짜</b></td>
		</tr>
		<tr>
			<td class="bg_board_title_02" height="1" colspan="11"
				style="overflow: hidden; padding: 0px"></td>
		</tr>

		<!-- 공지기능 적용시 -->


		<!-- 공지기능 적용끝  -->
		<%
			int size = list.size();
				if (size != 0) {
					//for(int i=0;i<size;i++) {
					//ReboardDto reboardDto = list.get(i);
					for (ReboardDto reboardDto : list) {
		%>
		<tr>
			<td align="center" class="text_gray"><%=reboardDto.getSeq()%></td>
			<td></td>
			<td nowrap class="onetext" style="padding-right: 5px"></td>
			<!--td>
     
     			</td-->
			<td style="word-break: break-all;"><a
				href="javascript:viewArticle('<%=reboardDto.getSeq()%>');"
				class="link_board_03"><%=reboardDto.getSubject()%>&nbsp;&nbsp;&nbsp;</a></td>
			<td></td>
			<td style="word-break: break-all;"><a href="javascript:;"
				onclick="showSideView();" class="link_board_04"><%=reboardDto.getName()%></a></td>
			<td></td>
			<td align="center" class="text_gray"><%=reboardDto.getHit()%></td>
			<td></td>
			<td align="center" class="text_gray"><%=reboardDto.getLogtime()%></td>
		</tr>

		<tr>
			<td bgcolor="#ededed" height="1" colspan="11"
				style="overflow: hidden; padding: 0px"></td>
		</tr>
		<%
			}
				} else {
		%>
		<tr>
			<td align="center" class="text_gray" colspan="10"><br> 게시글이
				존재하지 않습니다. <br></td>
		</tr>
		<tr>
			<td bgcolor="#ededed" height="1" colspan="11"
				style="overflow: hidden; padding: 0px"></td>
		</tr>
		<%
			}
		%>

		<tr>
			<td class="bg_board_title_02" height="1" colspan="11"
				style="overflow: hidden; padding: 0px"></td>
		</tr>
	</table>
</form>
<!-- bbs end -->

<!-- 하단 페이징 -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="3" height="5"></td>
	</tr>
	<tr valign="top">
		<td nowrap><a href="javascript:moveWrite();"><img
				src="<%=root%>/img/board/btn_write_01.gif" width="64" height="22"
				border="0" align="absmiddle" alt="글쓰기"></a></td>
		<td width="100%" align="center">
			<!--PAGE--> <%=navigator.getNavigator()%></td>
		<td nowrap class="stext"><b><%=navigator.getPageNo()%></b> / <%=navigator.getTotalPageCount()%>
			pages</td>
	</tr>
</table>
<br>
<!-- 하단 페이징 -->

<!-- 검색 영역-->
<form name="searchForm" method="get" action="" onsubmit="return false;"
	style="margin: 0px">
	<!--  onsubmit="return false;" (엄청 중요!!)-->
	<input type="hidden" name="act" value="list"> <input
		type="hidden" name="bcode" value="<%=bcode%>"> <input
		type="hidden" name="pg" value="1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td colspan="3" height="10"></td>
		</tr>
		<tr>
			<td width="50%"></td>
			<td nowrap><select name="key" onchange="javascript:ch()"
				class="inp">
					<option value="subject">글제목
					<option value="name">글쓴이
					<option value="seq">글번호
			</select> <span id="sear1"> <input type="text" name="word" size="22"
					class="inp" style="margin-top: -19px;" onkeypress="javascript:if(event.keyCode == 13) {searchArticle()}">
			</span> <a href="javascript:searchArticle();"><img
					src="<%=root%>/img/board/sbtn_s.gif" width="32" height="18"
					border="0" align="absmiddle" alt="검색"></a> 
			<input type="image"src="<%=root%>/img/board/sbtn_s.gif" onclick="javascript:searchArticle();"> 
					<a href="javascript:goMyList('안효인')"> <img
					src="<%=root%>/img/board/sbtn_mytext.gif" width="82" height="20"
					align="absmiddle" alt="내가 쓴 글 보기">
			</a><br></td>
			<td width="50%" align="right"><a href="#"><img
					src="<%=root%>/img/board/sbtn_top.gif" width="24" height="11"
					align="absmiddle" alt="TOP"></a><br></td>
		</tr>
	</table>
</form>
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