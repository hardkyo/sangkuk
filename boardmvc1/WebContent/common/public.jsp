<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.util.*" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath();
// ��� jsp���� �� �־�� �� //
int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // ��ũ�� �������� ��, 0 = �Խ��� ��ϰ��������� ���Բ� �ϱ�
int pg = NumberCheck.nullToOne(request.getParameter("pg")); // �������� 0��° �������� ���⶧���� 1�� �ʱ�ȭ
String key = Encoding.nullToBlank(request.getParameter("key"));
String word = Encoding.isoToEuc(request.getParameter("word")); // ���⵵ �ѱ�ó���������

MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
<title>�Խ��� �۾���</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel="stylesheet" href="<%=root%>/css/skin_purple.css" type="text/css">
<script type="text/javascript">
var root = "<%=root%>";
var bcode = "<%=bcode%>";
var pg = "<%=pg%>";
var key = "<%=key%>";
var word = "<%=word%>";

</script>
<script type="text/javascript" src="<%=root%>/js/board.js"></script>

</head>

<body>
<form name="commonForm" method="get" action="">
<input type="hidden" name="act" value=""> <!-- ������ �׻� �ٲ�ϱ� value="" -->
<input type="hidden" name="bcode" value="">
<input type="hidden" name="pg" value="">
<input type="hidden" name="key" value="">
<input type="hidden" name="word" value="">
<input type="hidden" name="seq" value="">
</form>