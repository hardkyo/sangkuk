<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kitri.member.model.*"%>
    <%
    String root = request.getContextPath();
    MemberDetailDto mmdto = (MemberDetailDto) request.getAttribute("modify");
    if(mmdto!=null){
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
function modify(){
	
	if(document.getElementById("pass").value  == "") {
		alert("��й�ȣ �Է�!");
		return;
	} else if(document.getElementById("pass").value != document.getElementById("passcheck").value) {
		alert("��й�ȣ Ȯ��!");
		return;
	} else {
		document.joinform.action = "<%=root%>/user";
		document.joinform.submit();
	}
}

function openzip(){
	window.open("<%=root%>/user?act=mvzip","zip","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
}

function openidcheck(){
	window.open("<%=root%>/user?act=mvidck","idck","top=200, left=300, width=400, height=180, menubar=no, status=no, toolbar=no, location=no, scrollbars=no");
}
</script>
 </head>

 <body>
  <center>
	<h3>ȸ����������</h3>
	<form class="mem" name ="joinform" method="post" action="">
	<input type="hidden" name="act" value="modify">
	 <table width="780" height="700" cellspacing="4" cellpadding="5">
			<tr>
			 <td class="td1">�̸�<font color="red">*</font></td>
			 <td class="td3"><%=mmdto.getName() %></td>
			</tr>
			
<!--
			<tr>
			 <td class="td2">�ֹε�Ϲ�ȣ<font color="red">*</font></td>
			 <td class="td4"><input type="text" name="reginum1" value="" size="12" maxlength="6"> -
			 <input type="text" name="reginum2" value="" size="12" maxlength="7"></td>
			</tr>

			<tr>
			 <td class="td1">�г���(����)<font color="red">*</font></td>
			 <td class="td3"><input type="text" name="nickname" value="" size="12">&nbsp;&nbsp; �Ǹ��� ������� �ʴ� ���񽺿��� ���Ǵ� <font color="#3cb371">����</font>�Դϴ�.<br>�Է����� ������ ��� ȸ������ �̸��� ��ϵ˴ϴ�.</td>
			</tr>
-->

			<tr>
			 <td class="td2">���̵�(ID)<font color="red">*</font></td>
			 <td class="td4"><%=mmdto.getId() %></td>
			</tr>

			<tr>
			 <td class="td1">��й�ȣ�Է�<font color="red">*</font></td> 
	         <td class="td3"><input type="password" name="pass" id="pass" size="12" maxlength="12">&nbsp;&nbsp;<font color="#3cb371">6~12</font>�ڸ��� ����(��ҹ��� ����)�̳� ����</td>
			</tr>

			<tr>
			 <td class="td2">��й�ȣȮ��<font color="red">*</font></td> 
	         <td class="td4"><input type="password" name="passcheck" id="passcheck" size="12" maxlength="12">&nbsp;&nbsp;��й�ȣ�� �ѹ��� �Է��ϼ���</td>
			</tr>
<!--
            <tr>
			 <td width="120" class="td1">��й�ȣ ��߱�<font color="red">*</font><br>���� ����</td>
			 <td class="td3">
			  <select name="question">
			   <option value="">���� �����ϴ� ������?(��: ����)</option>
			   <option value="">� �� ��¦ ģ���� �̸���?</option>
			   <option value="">���� �����ϴ� ������?</option>
			   <option value="">���� �����ϰ� ���� �����?</option>
			   <option value="">��￡ ���� �߾��� ��Ҵ�?</option>
			   <option value="">���� �����ϴ� ��������?</option>
			  <option value="">ģ���鿡�� �������� ���� � �� ������ �ִٸ�?</option>
			  </select><br>
			  Ȥ�� ��й�ȣ�� �ؾ������ ��� ���⿡�� ������ ������ �ϰԵ˴ϴ�.
			 </td>
			</tr>

			<tr>
			 <td width="120" class="td2">��й�ȣ ��߱�<font color="red">*</font><br>�亯 �Է�</td> 
	         <td class="td4"><input type="text" name="answer" size="35"><br>
			 ������ �����Ͻ� ������ ���� �亯�� �Է��ϼ���.<br>
			 ��й�ȣ�� �ؾ������ ��� �� �亯�� �̿��Ͽ� ��й�ȣ�� ��߱� ������ �� �ֽ��ϴ�.</td>
			</tr>
-->
		    <tr>
			 <td class="td1">����ó<font color="red">*</font></td>
			 <td class="td3">
			  �� �� ��&nbsp;&nbsp;<select name="tel1" >
			   <option value="">----</option>
		       <option value="010" selected="selected">010</option>
			   <option value="011">011</option>
			   <option value="016">016</option>
			   <option value="017">017</option>
			   <option value="018" >018</option>
			  </select> -
					<input type="text" name="tel2" size="4" maxlength="4" value="<%=mmdto.getTel2() %>"> -
					<input type="text" name="tel3" size="4" maxlength="4" value="<%=mmdto.getTel3() %>"><br>
<!--
			  ������ȭ&nbsp;<select name="tel1">
			   <option value="">----</option>
		       <option value="010">02</option>
			   <option value="010">031</option>
			   <option value="010">032</option>
			   <option value="010">033</option>
			   <option value="010">041</option>
			  </select> -
					<input type="text" name="tel2" value="" size="4" maxlength="4" > -
					<input type="text" name="tel3" value="" size="4" maxlength="4" >
					<input type="radio" name="location" value="��" checked>��
        	        <input type="radio" name="location" value="ȸ��">ȸ��
					<br>�޴����̳� ������ȭ �߿��� <font color="#3cb371">�ϳ��� �ݵ�� �Է��ϼž� �մϴ�.</font>
-->
			 </td>
			</tr>

			<tr>
			 <td class="td2">�����ȣ<font color="red">*</font></td>
			 <td class="td4"><input type="text" name="zip1" id="zip1" value="<%=mmdto.getZip1() %>" size="5" maxlength="3" readonly="readonly"> -
			 <input type="text" name="zip2" id="zip2" value="<%=mmdto.getZip2() %>" size="5" maxlength="3" readonly="readonly">
			 <input type="button" value="�����ȣ�˻�" onclick="javascript:openzip();"></td>
			</tr>
			<tr>
			 <td class="td1">�ּ�<font color="red">*</font></td>
			 <td class="td3"><input type="text" name="addr1" id="addr1" value="<%=mmdto.getAddr1() %>" size="100"></td>
			</tr>

			<tr>
			 <td class="td2">���ּ�<font color="red">*</font></td>
			 <td class="td4"><input type="text" name="addr2" id="addr2" size="100" value="<%=mmdto.getAddr2() %>"></td>
			</tr>

            <tr>
			 <td class="td1">�ַ� ���� �̸���<font color="red">*</font></td>
			 <td class="td3"><input type="text" name="email1" id="email1" value="<%=mmdto.getEmail1() %>" size="12"> @
					<!--<input type="text" name="direct" value="" size=12>-->
	                <select name="email2">
					<!--<option value="naver.com">�����Է�</option>-->
		            <option value="naver.com">naver.com</option>
					<option value="hanmail.net">hanmail.net</option>
					</select></td>
			</tr>
<!--			
			<tr>
			 <td class="td2">����<font color="red">*</font></td> 
	         <td class="td4"><input type="radio" name="gender" value="��" checked>����
        	        <input type="radio" name="gender" value="��">����</td>
			</tr>

			<tr>
			 <td class="td1">��ȥ����<font color="red">*</font></td> 
	         <td class="td3"><input type="radio" name="married" value="��ȥ" checked>��ȥ 
				<input type="radio" name="married" value="��ȥ">��ȥ</td>
        	   
			</tr>

			<tr>
			 <td class="td2">��� & ���ɻ���</td>
			 <td class="td4"><input type="checkbox" name="��ǻ��">��ǻ��&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="����">����&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="����">����&nbsp;&nbsp;&nbsp;&nbsp;
				    <input type="checkbox" name="����">����&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="����">����&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="IT">IT&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="����">����&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="IT">����
			</tr>
-->
			<tr>
             <td colspan="2" align="center">
             <input type="button" value="ȸ������" onclick="javascript:modify();">
&nbsp;&nbsp;
	          <input type="reset" value="���">
	         </td>
	   		</tr>
   </table>
   </form>
  </center>
 </body>
</html>
<% }else {
	response.sendRedirect(root+"/user?act=mvlogin");

} %>
