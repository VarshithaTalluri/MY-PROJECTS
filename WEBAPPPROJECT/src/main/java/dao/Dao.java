package dao;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

import model.Staff;
import model.Student;
public class Dao
{
	SessionFactory sf=null;
	public Dao()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Staff.class);
		sf=cfg.buildSessionFactory();
	}
	
	public boolean login(Student s)
	{
		boolean b=false;
		Session se=sf.openSession();
		s=(Student) se.get(Student.class,s.getName());
		if(s!=null)
		{
		   b=true;	
		}
		return b;
	}
	
	public boolean register(Student s)
	{
		boolean b=false;
		Session se=sf.openSession();
		Object obj= se.save(s);
		if(obj!=null)
		{
			b=true;
		}
		return b;
	}
	public boolean fee(Student s)
	{
		Session se=sf.openSession();
		boolean b=false;
		Student s1=new Student();
	    s1=(Student) se.get(Student.class,s.getName());
	    se.close();
	    Session ss=sf.openSession();
	    Transaction tx=ss.beginTransaction();
	    s1.setPaid(s1.getPaid()+s.getFee());
	    s1.setDue(s1.getDue()-s.getFee());
	    ss.update(s1);
	    tx.commit();
	    b=true;
	    ss.close();
		return b;
}

	public ArrayList<Student> studentview(Student s)
	{
		Session se=sf.openSession();
		s=(Student) se.get(Student.class,s.getName());
		ArrayList<Student> al=new ArrayList<Student>();
		al.add(s);
		se.close();
		return al;
	}
	
	public boolean staff(Staff s)
	{ 
		boolean b=false;
		Session se=sf.openSession();
	    Transaction tx=se.beginTransaction();
		s=(Staff) se.get(Staff.class,s.getUsername());
		Object obj=se.save(s);
		tx.commit();
		if(obj!=null)
		{
			b=true;
		}
	    se.close();
		return b;
		
	}
	public ArrayList<Student> viewallstudents()
	{
		Session se=sf.openSession();
		org.hibernate.Query q=se.createQuery("from Student");
		ArrayList<Student> al=(ArrayList<Student>) q.list();
    	se.close();
		return al;
	}
	public boolean updateGrades(Student s)
	{
		boolean b=false;
		Session se=sf.openSession();
		Student st=new Student();
		st=(Student) se.get(Student.class,s.getName());
		st.setGrades(s.getGrades());
		se.close();
		Session sc=sf.openSession();
		Transaction tx=sc.beginTransaction();
        sc.update(st);
        tx.commit();
        b=true;
        sc.close();
		return b;
	}
	public boolean updateattendance(Student s)
	{
	 Session se=sf.openSession();
	 Student st=new Student();
	 st=(Student)se.get(Student.class,s.getName());
	 st.setAttendance(s.getAttendance());
	 se.close();
	 Session sg=sf.openSession();
	Transaction tx=sg.beginTransaction();
	sg.update(st);
	tx.commit();
	boolean b=true;
	return b;
	}
}
