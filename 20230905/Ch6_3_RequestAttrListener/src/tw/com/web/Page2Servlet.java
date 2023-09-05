package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page2")
public class Page2Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out =  resp.getWriter();
		 Object v1 = req.getAttribute("value1");
		 Object v2 = req.getAttribute("value2");
		 out.println("Page2:");
		 out.println("v1:"+v1);
		 out.println("v2:"+v2);
	}
}
