package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session =  req.getSession();
		 int count = 0;
		 Object obj =  session.getAttribute("count");
		 if (obj != null) {
			 count =  (Integer)obj;
		 }
		 session.setAttribute("count", ++count);
	     PrintWriter out =   resp.getWriter();
	     out.println("Page1:"+count);
	     
	}
}
