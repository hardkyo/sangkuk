<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.kitri.util.*"%>
<%@ include file="/common/public.jsp"%>
	<link rel="stylesheet" type="text/css" HREF="<%=root%>/css/alice.css">
	<link rel="stylesheet" type="text/css" HREF="<%=root%>/css/oz.css">
	<script type="text/javascript" src="<%=root%>/js/prototype.js"></script>
	<script type="text/javascript" src="<%=root%>/js/extprototype.js"></script>	
	<script type="text/javascript" src="<%=root%>/js/oz.js"></script>	
	<script type="text/javascript" src="<%=root%>/js/alice.js"></script>

<script type="text/javascript">
var alice;
Event.observe(window, "load", function() {
	alice = Web.EditorManager.instance("test",{type:'detail',width:600,height:300,limit:10,family:'돋움',size:'13px'});
});	
function writeArticle(){
	if(document.writeForm.subject.value == ""){
		alert("제목을 입력하세요");
		return;
	}else if(alice.getContent() == ""){
		alert("내용을 입력하세요");
		return;
	}else{
		document.writeForm.content.value = alice.getContent();
		document.writeForm.action = "<%=root%>/reboard";
		document.writeForm.submit();
	}
}
</script>
<!-- title -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td><img src="<%=root%>/img/board/m_icon_board.gif" width="9"
			height="9" border="0" align="absmiddle" style="margin-top: -2px">
		<b>자유게시판</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; 자유로운 글을
		올리는 공간입니다<br>
		</td>
		<td align="right"></td>
	</tr>
	<tr>
		<td colspan="2" height="19"></td>
	</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" width="630">
	<tr>
		<td><img src="<%=root%>/img/board/icon_arrow_04.gif" width="4"
			height="11" border="0" align="absmiddle" vspace="4"></td>
		<td width="100%" style="padding-left: 4px"><b>글쓰기</b></td>
	</tr>
	<tr>
		<td width="630" colspan="2" height="2" class="bg_board_title_02"></td>
	</tr>
</table>
<br>

<form id="writeForm" name="writeForm" method="post" action=""
	style="margin: 0px">
<div id="attach_file_hdn"></div>
<!-- 모든 게시판의 controller에는 act(기능), bcode(게시판번호), pg(페이지번호), key(검색조건), word(검색어)
을 반드시 보내야 한다. -->
<input type="hidden" name="act" value="write">
<input type="hidden" name="bcode" value="<%=bcode%>">
<input type="hidden" name="pg" value="1">
<input type="hidden" name="key" value="">
<input type="hidden" name="word" value="">
<input type="hidden" name="content" value="">

<table border="0" cellpadding="5" cellspacing="0" width="630"
	style="table-layout: fixed">

	<tr valign="top">
		<td width="95" nowrap style="padding-left: 8px; padding-top: 10px"><img
			src="<%=root%>/img/board/e_dot.gif" width="4" height="4" border="0"
			align="absmiddle"> <b>제목</b></td>
		<td colspan="5"><input name="subject" id="subject" type="text"
			size="76" maxlength="150" class="inp_02" style="width: 300px"
			value=""><img src="<%=root%>/img/board/i_info.gif" width="12"
			height="11" border="0" align="absmiddle" vspace="8"
			style="margin: 3 3 0 6"><font class="stext">최대 한글 75자,
		영문 150자</font><br>
	</tr>
	<tr>
		<td width="620" nowrap style="padding-left: 8px; padding-top: 10px"
			colspan="5"><img src="<%=root%>/img/board/e_dot.gif" width="4"
			height="4" border="0" align="absmiddle"> <b>글내용</b> 
			<textarea name="test"></textarea>
		</td>
	</tr>
</table>
<table width="630" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td height="5" style="padding: 0px"></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" height="1"></td>
	</tr>
</table>

<table border="0" cellpadding="2" cellspacing="0" width="630">
	<tr>
		<td height="10" style="padding: 0px"></td>
	</tr>
	<tr>
		<td align="center"><a href="javascript:writeArticle();"><img
			src="<%=root%>/img/board/btn_register.gif" width="42" height="21"
			border="0" name="register" value="" alt="등록"></a> <a
			href="javascript:history.back();"><img
			src="<%=root%>/img/board/b_cancel.gif" width="42" height="21"
			border="0" name="cencel" value="" alt="취소"></a></td>
	</tr>
</table>
</form>
<br>
<br>
</body>
</html>