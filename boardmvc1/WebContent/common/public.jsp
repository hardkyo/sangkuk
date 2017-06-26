<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.util.*" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath();
// 모든 jsp에는 꼭 있어야 함 //
int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // 링크가 지워졌을 때, 0 = 게시판 목록같은곳으로 가게끔 하기
int pg = NumberCheck.nullToOne(request.getParameter("pg")); // 페이지는 0번째 페이지가 없기때문에 1로 초기화
String key = Encoding.nullToBlank(request.getParameter("key"));
String word = Encoding.isoToEuc(request.getParameter("word")); // 여기도 한글처리해줘야함

MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
<title>게시판 글쓰기</title>
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
<input type="hidden" name="act" value=""> <!-- 값들이 항상 바뀌니까 value="" -->
<input type="hidden" name="bcode" value="">
<input type="hidden" name="pg" value="">
<input type="hidden" name="key" value="">
<input type="hidden" name="word" value="">
<input type="hidden" name="seq" value="">
</form>