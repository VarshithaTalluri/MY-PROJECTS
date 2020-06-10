<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list off students</title>
</head>
<body bgcolor=DACBC9>
<center><br><br>
<%
ArrayList<Student> al=new ArrayList<Student>();
al=(ArrayList<Student>)request.getAttribute("list");
if(al!=null)
{
out.print("<table border=2  cellpadding=15><tr bgcolor=skyblue><th>Name</th><th>mobile</th><th>email</th><th>Address</th><th>password</th><th>grades</th><th>attendance</th><th>fee</th><th>paid</th><th>due</th></tr></body>");
for(Student s: al)
 {
	   out.print("<tr><td>"+s.getName()+"</td><td>"+s.getMobile()+"</td><td>"+s.getEmail()+"</td><td>"+s.getAddress()+"</td><td>"+s.getPassword()+"</td><td>"+s.getPassword()+"</td><td>"+s.getAttendance()+"</td><td>"+s.getFee()+"</td><td>"+s.getPaid()+"</td><td>"+s.getDue()+"</td></tr>");
 }
}
%>
</body>
</html>