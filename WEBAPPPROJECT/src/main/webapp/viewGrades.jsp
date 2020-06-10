<%@page import="java.util.*"%>
<%@page import="model.Student"%>
<h1>grades</h1>
<%
ArrayList<Student> al=new ArrayList<Student>();
al=(ArrayList<Student>)request.getAttribute("students");

for(Student s:al)
{
	out.print("<tr><td>"+s.getName()+"</td><td><a href=entergrades?id="+s.getName()+">enter grades</a></td></tr>");
	
}
%>