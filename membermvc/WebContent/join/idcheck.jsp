<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	String root = request.getContentType();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
	function idcheck() {
		if (document.getElementById("id").value == "") {
			alert("�˻� ���̵� �Է�!");
			return;
		} else {
			document.idform.action = "";
			document.idform.submit();
		}
	}

	function iduse(id) {

	}
</script>
</head>
<body>
	<center>
		<form name="idform" method="get" action="" onsubmit="return false;">
			<input type="hidden" name="act" value="idsearch">
			<h3>���̵� �ߺ� �˻�</h3>
			<table width="350">
				<tr>
					<td class="td3">�˻��� ���̵� �Է��ϼ���</td>
				</tr>
				<tr>
					<td class="td4" style="text-align: center"><input type="text"
						name="id" id="id"
						onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
						<input type="button" value="�˻�" onclick="javascript:idcheck();">
					</td>
				</tr>
				<tr>
					<td class="td4">�˻��� ���̵� ��Ȯ�� �Է��� �� �˻� ��ư�� Ŭ���ϼ���..</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>