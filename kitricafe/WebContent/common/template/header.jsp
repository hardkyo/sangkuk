<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/common/public.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
a:link {color: #78837d; font-size: 14px; text-decoration: none;}
a:visited {color: #78837d; font-size: 14px; text-decoration: none;}
a:active {color: #78837d; font-size: 14px; text-decoration: none;}
a:hover {color: #434946; font-size: 15px; text-decoration: none;}
</style>
<script type="text/javascript" src="/naver/js/myajax.js"></script>
<script type="text/javascript">
var checkFirst = true;
var lastkeyword = "";
var loopSendKeyword = false;
var firstKey = "";

function getkeyword() {
	if(document.getElementById("keyword").value == "")
		checkFirst = true;
	
	if(checkFirst == true) {
		firstKey = "first";
		loopSendKeyword = true;
		window.setTimeout("sendkeyword();", 50);
	} else {
		firstKey = "";
	}
	checkFirst = false;
}

function sendkeyword() {
	if(loopSendKeyword == false)
		return;
	
	var keyword = document.getElementById("keyword").value;
	//alert(keyword);
	if(keyword == "") {
		checkFirst = true;
		lastkeyword = "";
		hide("search");
	} else if(keyword != lastkeyword) {
		lastkeyword = keyword;
		if(lastkeyword != "") {
			var url = "/naver/findkeyword";
			var param = "first=" + firstKey + "&keyword=" + encodeURI(lastkeyword);
			sendRequest(url, param, displayResult, "GET");
		}
	}
	window.setTimeout("sendkeyword();", 50);
}

function displayResult() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			var txt = httpRequest.responseText;
			//alert(txt);//3|자바,자바스크립트,제주도
			var result = txt.split("|");
			var count = parseInt(result[0]);
			if(count != 0) {
				var list = result[1].split(",");
				var viewStr = "";
				var len = list.length;
				for(var i=0;i<len;i++) {
					viewStr += "<a href=\"javascript:selectKeyword('" + list[i] + "');\">";
					viewStr += list[i].replace(lastkeyword, "<font color='#ff0000'>" + lastkeyword + "</font>") + "</a><br>";
				}
				var view = document.getElementById("searchlist");
				view.innerHTML = viewStr;
				show("search");
			} else {
				hide("search");
			}
		} else {
			alert("문제발생 : " + httpRequest.status);
		}
	}
}

function selectKeyword(kw) {
	document.getElementById("keyword").value = kw;
	checkFirst = true;
	loopSendKeyword = false;
	lastkeyword = "";
	hide("search");
}

function show(eid) {
	var el = document.getElementById(eid);
	if(el != null)
		el.style.display = "";
}

function hide(eid) {
	var el = document.getElementById(eid);
	if(el != null)
		el.style.display = "none";
}
/////////////////////////////////////////////////////////////

function startrank() {
	sendRequest("/naver/rank", null, displayRank, "GET");
}

function displayRank() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			var txt = httpRequest.responseText;
			document.getElementById("currentrank").innerHTML = txt;
			window.setTimeout("startrank();", 10000);
		} else {
			alert("문제발생 : " + httpRequest.status);
		}
	}
}

function selinborder(i) {
	var seltb = document.getElementById("tid" + i);
	seltb.style.border = "#00cc33 3px solid";
	seltb.style.fontSize = "13";
	seltb.style.fontWeight = "bold";
}

function seloutborder(i) {
	var seltb = document.getElementById("tid" + i);
	seltb.style.border = "#00cc33 0px solid";
	seltb.style.fontSize = "12";
	seltb.style.fontWeight = "";
}

function search(kw) {
	document.getElementById("keyword").value = kw;
	document.searchform.submit();
}
</script>
</head>
<body onload="javascript:startrank();">
<center>
<table width="1000" height="900">
<tr>
	<td colspan="3" height="80">
	<%@ include file="/common/template/top.jsp" %>
	</td>
</tr>
<tr>
	<td width="200" valign="top">
	<%@ include file="/common/template/left.jsp" %>
	</td>
	<td>
	<table width="800">
	<tr>
		<td align="center">