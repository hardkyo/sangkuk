<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.ajax.model.KeywordDto,java.util.List"%>
<%
List<KeywordDto> list = (List<KeywordDto>) request.getAttribute("rank");
if(list != null) {
%>
<table width="160">
<%
	int len = list.size();
	for(int i=0;i<len;i++) {
		KeywordDto keywordDto = list.get(i);
%>
<tr onmouseover="javascript:selinborder('<%=i %>');" onmouseout="javascript:seloutborder('<%=i %>');">
	<td>
	<table id="tid<%=i%>">
	<tr>
		<td width="20"><%=keywordDto.getRank() %></td>
		<td width="120">
		<a href="javascript:search('<%=keywordDto.getKeyword() %>');">
		<%=keywordDto.getKeyword() %>
		</a>
		</td>
		<td><%=keywordDto.getHit() %></td>
	</tr>
	</table>
	</td>
</tr>
<%		
	}
%>
</table>
<%
}
%>