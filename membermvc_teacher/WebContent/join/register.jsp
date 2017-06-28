<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.sql.*"%>
<%!public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}%>
<%
String root = request.getContextPath();
	//1.get
	//parameter 한글인코딩
	request.setCharacterEncoding("EUC-KR");
	//id
	String id = request.getParameter("id");
	//name
	String name = request.getParameter("name");
	//pass
	String pass = request.getParameter("pass");
	//tel1
	String tel1 = request.getParameter("tel1");
	//tel2
	String tel2 = request.getParameter("tel2");
	//tel3
	String tel3 = request.getParameter("tel3");
	//zip1
	String zip1 = request.getParameter("zip1");
	//zip2
	String zip2 = request.getParameter("zip2");
	//zip3
	String zip3 = request.getParameter("zip3");
	//addr1
	String addr1 = request.getParameter("addr1");
	//addr2
	String addr2 = request.getParameter("addr2");
	//email1
	String email1 = request.getParameter("email1");
	//email2
	String email2 = request.getParameter("email2");

	//insert
	//driver loading >>선언부 init()
	//connection
	Connection conn = null;
	Statement stmt = null;
	int cnt = 0;
	//sql

	/*
	insert all
	into member values('id','name','email1','email2')
	into member_detail('id','tel1','tel2','tel3','zip1','zip2','addr1','addr2',sysdate);
	*/
	//statement
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.28:1521:orcl", "kitri", "kitri");
		String sql = "";
		sql += "insert all \n";
		sql += "into member values ('" + id + "','" + name + "','" + pass + "','" + email1 + "','" + email2
				+ "') \n";
		sql += "into member_detail values ('" + id + "','" + tel1 + "','" + tel2 + "','" + tel3 + "','" + zip1
				+ "', \n";
		sql += "'" + zip2 + "','" + addr1 + "','" + addr2 + "',sysdate) \n";
		sql += "select * from dual";
		
		stmt = conn.createStatement();
		cnt = stmt.executeUpdate(sql);
	} catch (Exception e) {

	} finally {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			
		}
	}

	//insert >>int값
	//finally
	System.out.println(cnt);
	if (cnt != 0) {
		System.out.println("af");
		request.setAttribute("name", name);
		request.setAttribute("id", id);
		request.setAttribute("email", email1+"@"+email2);
		request.setAttribute("tel", tel1+"-"+tel2+"-"+tel3);
		request.setAttribute("address", zip1+"-"+zip2+" "+ addr1+" "+addr2);
//		response.sendRedirect(root+"/join/registerok.jsp");
		RequestDispatcher disp = request.getRequestDispatcher("/join/registerok.jsp");
		disp.forward(request, response);
	} else {
		response.sendRedirect(root+"/join/registerfail.jsp");
	}
%>
