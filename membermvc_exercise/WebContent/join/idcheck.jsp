<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String root = request.getContextPath();
	String sid = request.getParameter("sid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root%>/css/style.css" type="text/css">
<script type="text/javascript">
function idcheck(){
	if(document.getElementById("id").value == "") {
		alert("검색 아이디 입력!");
		return;
	} else {
		document.idform.action = "<%=root%>/user";
		document.idform.submit();
		}
	}

	function iduse(id) {
		opener.document.getElementById("id").value = id;
		self.close();
	}
</script>
</head>
<body>
	<center>
		<form name="idform" method="get" action="" onsubmit="return false;">
			<input type="hidden" name="act" value="idsearch">
			<h3>아이디 중복검사</h3>
			<table width="350">
				<tr>
					<td class="td3">검색할 아이디를 입력하세요</td>
				</tr>
				<tr>
					<td class="td4" style="text-align: center"><input type="text"
						name="id" id="id"
						onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
						<input type="button" value="검색" onclick="javascript:idcheck();">
					</td>
				</tr>
				<%
					if (sid == null) {
				%>
				<tr>
					<td class="td4">검색할 아이디를 정확히 입력한 후 검색 버튼을 클릭하세요..</td>
				</tr>
				<%
					} else {
						int count = Integer.parseInt(request.getParameter("count"));
						if (count == 0) {
				%>
				<tr>
					<td class="td4"><b><%=sid%></b>는 사용가능합니다.<br> <input
						type="button" value="사용" onclick="javascript:iduse('<%=sid%>');">
					</td>
				</tr>
				<%
					} else {
				%>
				<tr>
					<td class="td4"><b><%=sid%></b>는 사용중 입니다.<br> 다른 아이디로
						검색해 주세요.</td>
				</tr>
				<%
					}
					}
				%>
			</table>
		</form>
	</center>
</body>
</html>