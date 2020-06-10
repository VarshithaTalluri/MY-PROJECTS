import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegistrationController extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("t1");
		long mobile=Long.parseLong(req.getParameter("t2"));
		String email=req.getParameter("t3");
		String Address=req.getParameter("t4");
		String city=req.getParameter("t5");			
	}
}
