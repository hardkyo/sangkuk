<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*"%>
<%!
//2-1. driver loading >> init()
public void init() {
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}catch(Exception e) {
		e.printStackTrace();
	}
}
%>
<%
String root = request.getContextPath();

//*1. data get
//parameter 한글인코딩
request.setCharacterEncoding("EUC-KR");

String id = request.getParameter("id");//id
String name = request.getParameter("name");//name
String pass = request.getParameter("pass");//pass
String tel1 = request.getParameter("tel1");//tel1
String tel2 = request.getParameter("tel2");//tel2
String tel3 = request.getParameter("tel3");//tel3
String zip1 = request.getParameter("zip1");//zip1
String zip2 = request.getParameter("zip2");//zip2
String addr1 = request.getParameter("addr1");//addr1
String addr2 = request.getParameter("addr2");//addr2
String email1 = request.getParameter("email1");//email1
String email2 = request.getParameter("email2");//email2
System.out.println(name + "\t" + addr1);

//*2. db insert
Connection conn = null;
Statement stmt = null;
int cnt = 0;
try {
//2-2. Connection 생성
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.28:1521:orcl", "kitri", "kitri");
//2-3. insert sql 작성
	String sql = "";
	sql += "insert all \n";
	sql += "	into member (id, name, pass, email1, email2) \n";
	sql += "	values ('" + id + "', '" + name + "', '" + pass + "', '" + email1 + "', '" + email2 + "') \n";
	sql += "	into member_detail (id, tel1, tel2, tel3, zip1, zip2, addr1, addr2, joindate) \n";
	sql += "	values ('" + id + "', '" + tel1 + "', '" + tel2 + "', '" + tel3 + "', '" + zip1 + "', '" + zip2 + "', '" + addr1 + "', '" + addr2 + "', sysdate) \n";
	sql += "select * from dual \n";
//2-3. Statement 생성
	stmt = conn.createStatement();	
//2-4. insert문 실행. >> int
	cnt = stmt.executeUpdate(sql);
} catch(Exception e) {
	e.printStackTrace();
} finally {
	try {
//2-5. stmt, conn close << finally
		if(stmt != null)
			stmt.close();
		if(conn != null)
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

//* 3. response page
//2-4의 결과가 0이 아니라면 registerok.jsp로 이동
//이름, 아이디, 이메일, 전번, 주소
if(cnt != 0) {
	request.setAttribute("name", name);
	request.setAttribute("id", id);
	request.setAttribute("email", email1 + "@" + email2);
	request.setAttribute("tel", tel1 + "-" + tel2 + "-" + tel3);
	request.setAttribute("address", zip1 + "-" + zip2 + " " + addr1 + " " + addr2);
	RequestDispatcher disp = request.getRequestDispatcher("/join/registerok.jsp");
	disp.forward(request, response);
	//response.sendRedirect(root + "/join/registerok.jsp");
} else {
//2-4의 결과가 0이라면 registerfail.jsp로 이동
	response.sendRedirect(root + "/join/registerfail.jsp");
}
%>



