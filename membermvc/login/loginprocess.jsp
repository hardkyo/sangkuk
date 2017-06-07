<%@ page 
	language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" 
    import="java.sql.*,java.net.*"%>
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
//parameter 茄臂牢内爹
request.setCharacterEncoding("EUC-KR");
//id
String id = request.getParameter("id");
//pass
String pass = request.getParameter("pass");

//*2. db select
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String name = null;
try {
//2-2. Connection 积己
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.28:1521:orcl", "kitri", "kitri");	
//2-3. select sql 累己
	String sql = "";
	sql += "select name \n";
	sql += "from member \n";
	sql += "where id='" + id + "' and pass='" + pass + "'";
//2-3. Statement 积己
	stmt = conn.createStatement();
//2-4. select 角青. >> ResultSet积己
	rs = stmt.executeQuery(sql);
//2-5. next() >> 窜刀, if vvv, while
	if(rs.next()) {
		//2-6. name	get
		name = rs.getString("name");
	}

	
} catch(Exception e) {
	e.printStackTrace();
} finally {
	try {
//2-7. rs, stmt, conn close << finally
		if(rs != null)
			rs.close();
		if(stmt != null)
			stmt.close();
		if(conn != null)
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


//* 3. response page
if(name != null) {
	response.sendRedirect(root + "/login/loginok.jsp?name=" + URLEncoder.encode(name, "EUC-KR"));
} else {
	response.sendRedirect(root + "/login/loginfail.jsp");
}
%>
