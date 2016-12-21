<%@ page language="java" contentType="text/html; charset=windows-1256" 
    pageEncoding="windows-1256"%>
    <%@ page import="mobily.sms.java.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<%
	Jawaly m=new Jawaly();
	if(request.getParameter("mode")!= null && request.getParameter("mode").equals("check") && request.getParameter("Add").equals("Add Sender Name")){
		String UserName=request.getParameter("txtUser");
		String password=request.getParameter("txtPassword");
		String senderName=request.getParameter("txtSenderName");
		m.AddSender(UserName,password,senderName);
		String output=m.getMessage();
		out.println(output);
	}
	else if (request.getParameter("mode")!= null && request.getParameter("mode").equals("check") && request.getParameter("Add").equals("Activate Sender Name")){
		
		String UserName=request.getParameter("txtUser");
		String password=request.getParameter("txtPassword");
		String senderName=request.getParameter("txtSenderName");
		String ActivateCode=request.getParameter("txtActiveCode");
		m.ActiveSender(UserName, password, senderName, ActivateCode);
		String output=m.getMessage();
		out.println(output);
	}
	
%>
<body>
	<form action="AddSender.jsp">
	<table border="1">
		<tr>
			<td colspan="2"  align="center" >4jawaly Add Sender Form</td>
			
		</tr>
		<tr>
			<td>User Name:</td>
			<td><input type="Text" name="txtUser"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="Text" name="txtPassword"/></td>
		</tr>
		<tr>
			<td>Sender Name:</td>
			<td><input type="Text" name="txtSenderName" /></td>
		</tr>
		<tr>
			<td>Only for Activate Code:</td>
			<td><input id="activeCodeId" type="Text" name="txtActiveCode" onblur="addchange()"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input id="erewrw" type="submit" name="Add" value="Add Sender Name"  /><input id="erewrw2" type="submit" name="Add" value="Activate Sender Name" /></td>
		</tr>
		
		
	</table>
	<input type="hidden" name="mode" value ="check"/>
</form>
</body>
<script type="text/javascript">
debugger;


	document.getElementById('erewrw2').disabled = true;
	document.getElementById('erewrw1').disabled = false;

function addchange(){
	if(document.getElementById('activeCodeId').value){
		document.getElementById('erewrw2').disabled = false;
		document.getElementById('erewrw').disabled = true;
	}
	else {
		document.getElementById('erewrw2').disabled = true;
		document.getElementById('erewrw').disabled = false;
	}
	}


</script>
</html>