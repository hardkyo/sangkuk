<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" 
	import="com.kitri.board.model.ReboardDto"
%>
<%@ include file="/common/public.jsp" %>
<%

ReboardDto reboardDto = (ReboardDto) request.getAttribute("article");
if(reboardDto != null) {
%>
<script>
function moveReply(seq) {
	document.commonForm.act.value = "mvreply";
	document.commonForm.bcode.value = "<%=bcode%>";
	document.commonForm.pg.value = "1";
	document.commonForm.key.value = "";
	document.commonForm.word.value = "";
	document.commonForm.seq.value = seq;
	//document.commonForm.key.value = "<%=key%>";
	//document.commonForm.word.value = "<%=word%>";
	document.commonForm.action = "<%=root%>/reboard";
	document.commonForm.submit();
}

function moveModify(seq) {
	document.commonForm.act.value = "mvmodify";
	document.commonForm.bcode.value = "<%=bcode%>";
	document.commonForm.pg.value = "1";
	document.commonForm.key.value = "";
	document.commonForm.word.value = "";
	document.commonForm.seq.value = seq;
	//document.commonForm.key.value = "<%=key%>";
	//document.commonForm.word.value = "<%=word%>";
	document.commonForm.action = "<%=root%>/reboard";
	document.commonForm.submit();
}
</script>
<!-- title -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td><img src="<%=root%>/img/board/m_icon_board.gif" width="9"
			height="9" border="0" align="absmiddle" style="margin-top: -2px">
		<b>�����Խ���</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; �����ο� ����
		�ø��� �����Դϴ�<br>
		</td>
		<td align="right"></td>
	</tr>
	<tr>
		<td colspan="2" height="19"></td>
	</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<form name="bbsForm" id="bbsbbs" method="post"><input
		type="hidden" name="" value="">
	<tr>
		<td valign="bottom" nowrap>
		
		<a href="javascript:moveWrite();"><img
			src="<%=root%>/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="�۾���"></a> 
		<a href="javascript:moveReply('<%=reboardDto.getSeq() %>');"><img
			src="<%=root%>/img/board/btn_reply.gif" width="40" height="22"
			border="0" align="absmiddle" alt="���"></a>
<%
/* System.out.println(memberDto.getId() + "\t" + reboardDto.getId());
 */	if(memberDto.getId().equals(reboardDto.getId())) {
%>			
		<a href="javascript:moveModify('<%=reboardDto.getSeq() %>');"><img
			src="<%=root%>/img/board/btn_modify.gif"
			border="0" align="absmiddle" alt="�ۼ���"></a> 
		<a href="javascript:deleteArticle('<%=reboardDto.getSeq() %>');"><img
			src="<%=root%>/img/board/btn_delete.gif"
			border="0" align="absmiddle" alt="�ۻ���"></a>
<%
}
%>		
		</td>
		<td valign="bottom" width="100%" style="padding-left: 4px"></td>
		<td align="right" nowrap valign="bottom"><a
			href="javascript:firstArticle();">�ֽŸ��</a> <font color="#c5c5c5">|</font>
		<a href="javascript:listArticle('<%=pg%>');">���</a> <font color="#c5c5c5">|</font>

		<a href="javascript:goBbsRead();"><img
			src="<%=root%>/img/board/icon_up.gif" border="0" align="absmiddle"
			hspace="3">����</a> <font color="#c5c5c5">|</font> <a
			href="javascript:goBbsRead();">�Ʒ���<img
			src="<%=root%>/img/board/icon_down.gif" border="0" align="absmiddle"
			hspace="3"></a></td>
	</tr>
	<tr>
		<td colspan="3" height="5" style="padding: 0px"></td>
	</tr>
</table>

<table border="0" cellpadding="5" cellspacing="0" width="100%">
	<tr>
		<td class="bg_board_title_02" colspan="2" height="2"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr height="28">
		<td class="bg_board_title" colspan="2" style="padding-left: 14px">
		<b><font class="text"> <%=reboardDto.getSubject() %> </font></b></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" colspan="2" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr height="26">
		<td width="100%" style="padding-left: 14px"><font class="stext">��ȣ
		:</font> <font class="text_commentnum"><%=reboardDto.getSeq() %></font> &nbsp; <font
			class="stext">�۾��� :</font> <a href="javascript:;"
			onClick="showSideView();" class="link_board_02"><%=reboardDto.getName() %></a><br>
		</td>
		<td style="padding-right: 14px" nowrap class="stext">��ȸ : <font
			class="text_commentnum"><%=reboardDto.getHit() %></font> &nbsp; ��ũ�� : <font
			class="text_commentnum">0</font> &nbsp; ��¥ : <font
			class="text_commentnum"><%=reboardDto.getLogtime() %></font></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" colspan="2" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>

<table border="0" cellpadding="15" cellspacing="0" width="100%">
	<tr valign="top">
		<td bgcolor="#ffffff" width="100%" class="text"
			style="padding-bottom: 8px; line-height: 1.3" id="clix_content">



		<P><%=reboardDto.getContent() %></P>



		</td>
		<td nowrap valign="top" align="right" style="padding-left: 0px">

		</td>
	</tr>
</table>

<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="bg_board_title_02" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>

<!-- �ϴ� ����¡ -->
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td colspan="3" height="5" style="padding: 0px"></td>
	</tr>
	<tr valign="top">
		<td nowrap>
		<a href="javascript:moveWrite();"><img
			src="<%=root%>/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="�۾���"></a> 
		<a href="javascript:moveReply('<%=reboardDto.getSeq() %>');"><img
			src="<%=root%>/img/board/btn_reply.gif" width="40" height="22"
			border="0" align="absmiddle" alt="���"></a>
		</td>
		<td style="padding-left: 4px" width="100%"><a href=""
			target="new"><img src="<%=root%>/img/board/btn_print.gif"
			width="30" height="18" border="0" align="absmiddle" alt="�μ�"></a></td>

		<td align="right" nowrap><a href="javascript:firstArticle();">�ֽŸ��</a>
		<font color="#c5c5c5">|</font> <a href="javascript:listArticle('<%=pg%>');">���</a>
		<font color="#c5c5c5">|</font> <a href="javascript:goBbsRead();"><img
			src="<%=root%>/img/board/icon_up.gif" border="0" align="absmiddle"
			hspace="3">����</a> <font color="#c5c5c5">|</font> <a
			href="javascript:goBbsRead();">�Ʒ���<img
			src="<%=root%>/img/board/icon_down.gif" border="0" align="absmiddle"
			hspace="3"></a></td>
	</tr>
</table>
<br>
</body>
</html>
<%
} else {
%>
<script>
alert("�������� URL�����Դϴ�.");
document.location.href = "<%=root%>";
</script>
<%	
}
%>











