<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ page import="mobily.sms.java.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<%
	String balance="";
    Jawaly m=new Jawaly();
	if(request.getParameter("mode")!= null && request.getParameter("mode").equals("send")){
		String UserName=request.getParameter("txtUser");
		String Password=request.getParameter("txtPass");
		String senderName=request.getParameter("txtSender");
		String message=request.getParameter("txtMessage");
		String numbers=request.getParameter("txtNumbers");
		m.sendMessage(UserName, Password, numbers, message, senderName);
		balance=m.checkBalance(UserName,Password);
		String output=m.getMessage();
		out.println(output);
	}else{
		balance=m.checkBalance("","");
	}
%>
<body>
<form action="sendSMS.jsp">
	<table border="1">
		<tr>
			<td colspan="2"  align="center" >4Jawaly Send SMS Form</td>
			
		</tr>
		<tr>
			<td>Balance:</td>
			<td> <%= balance %> </td>
		</tr>
		<tr>
			<td>User Name:</td>
			<td><input type="Text" name="txtUser"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="Text" name="txtPass"/></td>
		</tr>
		<tr>
			<td>Sender Name:</td>
			<td><input type="Text" name="txtSender"/></td>
		</tr>
		<tr>
			<td>Message :</td>
			<td><textarea id="txtMessage" cols="20" name="txtMessage" rows="5"></textarea></td>
		</tr>
		<tr>
			<td>Number(s):</td>
			<td><input type="Text" name="txtNumbers"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Send"/></td>
		</tr>
		
		
	</table>
	<input type="hidden" name="mode" value ="send"/>
</form>
</body>
</html>