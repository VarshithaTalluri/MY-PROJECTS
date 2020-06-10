<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Student s=new Student();
s.setName(request.getAttribute("name").toString());
out.print("<body bgcolor=DACBC9><br><br><br><h1><center>ENTER GRADES OF STUDENT</h1></center><br>");

out.print("<center><form action=enter><tr><td>Student Name:</td><td><input type=text readonly name=t1 value="+s.getName()+"></td></tr><br><br>");
out.print("<tr><td>Grade:                       </td><td><input type=text name=t2></td></tr><br><br>");
out.print("<tr><td><input type=submit value=submit></td></tr><br>");
%>
</body>
</html>