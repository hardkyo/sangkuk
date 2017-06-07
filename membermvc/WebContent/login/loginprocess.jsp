<%@page import="java.net.URLEncoder"%>
<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.sql.*"%>

<%
	String root = request.getContentType();
%>

<%!// 2-1 driver loading >> init()
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>
<%
	//1. data get
	//parameter 한글 인코딩
	request.setCharacterEncoding("euc-kr");

	String id = request.getParameter("id");//id
	String pass = request.getParameter("pass");//pass

	//2. db select

	//2-2 Connection 생성
	//2-3 select sql 생성
	//2-3 statment 작성
	//2-4 select 실행 >> result set 생성
	//2-5 rs.next() >> rs를 가지고 옴 - 단독, if, while
	//2-6 name get 
	//2-7 rs close, stmt close, conn close << finally 

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String name = "";
	try {

		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.28:1521:orcl", "kitri", "kitri");
		String sql = "";
		sql += "select name from MEMBER \n";
		sql += "where id = '" + id + "' \n";
		sql += "and pass = '" + pass + "'";
		System.out.print(sql);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			name = rs.getString("name");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	if (name != null) {
		response.sendRedirect(root + "/login/loginok.jsp?name=" + name + URLEncoder.encode(name, "euc-kr"));
	} else {
		response.sendRedirect(root + "/login/loginfail.jsp");
	}
%>
