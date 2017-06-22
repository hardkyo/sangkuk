<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String root = request.getContextPath();
%>
<script type="text/javascript">
   	function moveFreeBoardList() {
   		document.location.href = "<%=root%>/freeboard?act=mvfreelist";
		document.submit();
	}
   	
   	function moveGallerydList() {
		document.location.href = "<%=root%>/gallery?act=mvgallerylist";
		document.submit();
	}
</script>
<body>

<!-- board common form -->
<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value="">
	<input type="hidden" name="bcode" value="">
	<input type="hidden" name="pg" value="">
	<input type="hidden" name="key" value="">
	<input type="hidden" name="word" value="">
	<input type="hidden" name="seq" value="">
</form>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">

				<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation">
					<div class="navbar-header">

						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<%=root%>/admin?act=main"><strong>Bike</strong></a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">추천경로</a></li>
							<li class=""><a href="javascript:moveFreeBoardList();">자유게시판</a></li>
							<li class=""><a href="javascript:moveGallerydList();">앨범</a></li>
							<li class=""><a href="#">후기</a></li>
							<li class="dropdown"><a class="dropdown-toggle" href="#"
								data-toggle="dropdown">모임<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#">신청</a></li>
									<li><a href="#">탈퇴</a></li>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a class="dropdown-toggle" href="#"
								data-toggle="dropdown">회원관리<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#">로그인</a></li>
									<li><a href="#">회원가입</a></li>
									<li><a href="#">마이페이지</a></li>
									<li class="divider"></li>
									<li><a href="#">로그아웃</a></li>
								</ul></li>
						</ul>
					</div>

				</nav>
				<br/>
				<br/>
				<br/>
