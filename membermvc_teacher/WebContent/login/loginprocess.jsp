<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.sql.*"%>

<%!//드라이버로딩 init()
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}%>
	
<%
String root = request.getContextPath();


	//get
	//인코딩
	request.setCharacterEncoding("EUC-KR");
	//name
	String id = request.getParameter("id");
	//pass
	String pass = request.getParameter("pass");
	//Connection
	Connection conn = null;
	//Sql select

	//Statement
	Statement stmt = null;
	//ResultSet
	ResultSet rs = null;
	String name = null;
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.28:1521:orcl", "kitri", "kitri");
		stmt = conn.createStatement();
		String sql = "select name from member where id='" + id + "' and pass='" + pass + "'";
		System.out.print(sql);
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			name = rs.getString("name");
		}

	} catch (Exception e) {

	} finally {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {

		}
	}
	//re.next
	//name=rs.getString
	//finally

	if (name != null) {
		response.sendRedirect(root+"/login/loginok.jsp?name="+URLEncoder.encode(name,"EUC-KR"));
	} else {
		response.sendRedirect(root+"/login/loginfail.jsp");
	}
%>