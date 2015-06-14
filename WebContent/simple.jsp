<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pojos.Simple"%><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Web Project</title>
</head>
<body>
<form method="post" action="/SimpleWebProject/SimpleServlet">
<b><i><font size="3" color="red">Please enter your details!!!</font></i></b>
<br/><br/>
First name: <input name="first_name"/>
<br/><br/>
Last name: <input name="last_name"/>
<br/><br/>
Inst Id: <input name="instrument_id"/>
<br/><br/>
Date of Birth: <input name="dob"/> <i>(format:YYYY-MM-DD)</i>
<br/><br/>
<input type="submit"/>

</form>

<%

Simple simple = (Simple)session.getAttribute("simple");

if(simple != null) {
	out.println(simple.getFirstName());
	out.println(simple.getLastName());
	out.println(simple.getInstId());
	out.println(simple.getDob());
	//out.println("shajahan");
	//out.println(simple.getSessEx());
}

%>

</body>
</html>