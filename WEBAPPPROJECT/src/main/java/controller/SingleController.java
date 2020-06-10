package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Staff;
import model.Student;
@WebServlet(urlPatterns= {"/reqlogin","/reqreg","/reqstaff","/reqattendance","/reqfee","/reqwelcome","/reqview","/studentview","/grades","/entergrades","/enter","/attendance","/enterattendance","/enter1","/viewGrades"})
public class SingleController extends HttpServlet
{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		Student s1=new Student();
		PrintWriter out=res.getWriter();
	String path=req.getServletPath();
	if(path.equals("/reqlogin"))
	{
		s1.setName(req.getParameter("t1"));
		s1.setPassword(req.getParameter("t2"));
		boolean b=new Dao().login(s1);
		if(b)
		{
			HttpSession session=req.getSession();
			session.setAttribute("name",s1.getName());
			RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
			rd.forward(req,res);
		}
		else
		{
			out.print("Invalid user");
		}
	}
	else if(path.equals("/reqreg"))
	{
		s1.setName(req.getParameter("t1"));
		s1.setMobile(req.getParameter("t2"));		
		s1.setEmail(req.getParameter("t3"));		
		s1.setAddress(req.getParameter("t4"));
		s1.setAddress(req.getParameter("t5"));
		s1.setFee(Integer.parseInt(req.getParameter("t6")));
		boolean b=new Dao().register(s1);
    if(b)
    {
    	out.print("Registration done successfully");
    }
    else
    {
    	out.print("Registration failed");
    }
	}
	else if(path.equals("/reqfee"))
	{
		HttpSession session=req.getSession();
		s1.setName((session.getAttribute("name").toString()));
		s1.setFee(Integer.parseInt(req.getParameter("t1")));
		boolean b=new Dao().fee(s1);
		if(b)
		{
			out.print("payment done successfully.....");
		
		}
		else
		{
			out.print("payment failed!!!!");
		}
	}
	else if(path.equals("/reqview"))
	{
		 ArrayList<Student> al=new ArrayList<Student>();
		 al=new Dao().viewallstudents();
		
			 req.setAttribute("list",al);
			 RequestDispatcher rd=req.getRequestDispatcher("viewallstudents.jsp");
			 rd.forward(req,res);
	}
	else if(path.equals("/studentview"))
	{
		HttpSession session=req.getSession();
		s1.setName((session.getAttribute("name").toString()));
		ArrayList<Student> al=new ArrayList<Student>();
		al=new Dao().studentview(s1);	 
		out.print("<body bgcolor=DACBC9><center><br><br><table border=2  cellpadding=15><tr bgcolor=skyblue><th>Name</th><th>mobile</th><th>email</th><th>Address</th><th>password</th><th>grades</th><th>attendance</th><th>fee</th><th>paid</th><th>due</th></tr></body>");
			for(Student s:al)
			   {
				 out.print("<tr><td>"+s.getName()+"</td><td>"+s.getMobile()+"</td><td>"+s.getEmail()+"</td><td>"+s.getAddress()+"</td><td>"+s.getPassword()+"</td><td>"+s.getGrades()+"</td><td>"+s.getAttendance()+"</td><td>"+s.getFee()+"</td><td>"+s.getPaid()+"</td><td>"+s.getDue()+"</td></tr>");
			   }
	}

	else if(path.equals("/reqstaff"))
	{
		Staff s=new Staff();
		ResultSet rs=null;
		s.setUsername(req.getParameter("t1"));
		s.setUsername(req.getParameter("t2"));
		boolean b=new Dao().staff(s);
		b=new Dao().staff(s);
		if(b)
		{	
			RequestDispatcher rd =req.getRequestDispatcher("enterdetails.html");
			rd.forward(req, res);
		}
		
	}
	else if(path.equals("/grades"))
	{
		ArrayList<Student> al=new ArrayList<Student>();
		al=new Dao().viewallstudents();
		req.setAttribute("students",al);
		RequestDispatcher rd=req.getRequestDispatcher("viewGrades.jsp");
		rd.forward(req,res);

		
	}
	else if(path.equals("/entergrades"))
	{
	 s1.setName(req.getParameter("id"));
	  req.setAttribute("name",s1.getName());
	  RequestDispatcher rd=req.getRequestDispatcher("Entergradesform.jsp");
	  rd.forward(req, res);
	}
	else if(path.equals("/enter"))
	{
		s1.setName(req.getParameter("t1"));
		s1.setGrades(req.getParameter("t2"));
		boolean b=new Dao().updateGrades(s1);
		if(b)
		{
			RequestDispatcher rd=req.getRequestDispatcher("grades");
			rd.forward(req, res);
		}
		else
		{
			out.print("<center>entering Grades Failed click here to <a href=grades>Go back</a></center>");
		}
	}
	else if(path.equals("/attendance"))
	{
		ArrayList<Student> al=new ArrayList<Student>();
		al=new Dao().viewallstudents();
		out.print("<body bgcolor=DACBC9><center><table border=5 cellpadding=12><tr bgcolor=skyblue><td>Name</td><td>Enter attendance</td></tr>");
		for(Student s:al)
		{
			out.print("<tr><td>"+s.getName()+"</td><td><a href=enterattendance?id="+s.getName()+">enter attendance</a></td></tr>");
		}
	}
	else if(path.equals("/enterattendance"))
	{
		String Name=req.getParameter("id");
		out.print("<body bgcolor=DACBC9><br><br><br><br><h1><center>ENTER ATTENDANCE OF STUDENT</h1></center><br>");
		out.print("<center><form action=enter1><h2><tr><td>student Name:</td><td><input type=text readonly name=t1 value="+Name+"></h2></td></tr><br>");
		out.print("<tr><td>Attendance:</td><td><input type=text name=t2></td></tr><br><br>");
		out.print("<tr><td><input type=submit value=submit></td></tr></h2><br>");
	}
	else if(path.equals("/enter1"))
	{
		s1.setName(req.getParameter("t1"));
		s1.setAttendance(req.getParameter("t2"));
		boolean b=new Dao().updateattendance(s1);
		if(b)
		{
			RequestDispatcher rd=req.getRequestDispatcher("attendance");
			rd.forward(req, res);
		}
		
	      }
	
	}
}


